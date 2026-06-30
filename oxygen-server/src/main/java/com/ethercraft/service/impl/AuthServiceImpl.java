package com.ethercraft.service.impl;

import com.ethercraft.dto.UserLoginDTO;
import com.ethercraft.dto.UserRegisterDTO;
import com.ethercraft.entity.Permission;
import com.ethercraft.entity.Role;
import com.ethercraft.entity.User;
import com.ethercraft.enumeration.ErrorCode;
import com.ethercraft.enumeration.UserStatus;
import com.ethercraft.exception.BusinessException;
import com.ethercraft.mapper.AuthMapper;
import com.ethercraft.security.JwtUtil;
import com.ethercraft.service.AuthService;
import com.ethercraft.vo.TokenVO;
import com.ethercraft.vo.UserLoginVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    // BCrypt 编码器
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    // Jwt 工具类
    private final JwtUtil jwtUtil;

    // Mapper层
    private final AuthMapper authMapper;

    @Override
    public TokenVO login(UserLoginDTO userLoginDTO) {

        // 读取数据
        User user = authMapper.getUserByUsername(userLoginDTO.getUsername());

        // 用户不存在
        if (user == null || user.getDeleted()) {
            throw new BusinessException(ErrorCode.NONEXISTENT_USER);
        }
        // 用户被冻结
        if (user.getStatus() == UserStatus.DISABLED) {
            throw new BusinessException(ErrorCode.DISABLED_USER);
        }
        // 密码错误
        if (!encoder.matches(userLoginDTO.getPassword(), user.getPassword())) {
            throw new BusinessException(ErrorCode.MISMATCHED_USER_AND_PASSWORD);
        }

        // 根据 用户 ID 和 用户账号 生成token
        String token = jwtUtil.generateToken(user.getId(), user.getUsername());

        // 包装返回数据
        UserLoginVO userLoginVO = new UserLoginVO();
        BeanUtils.copyProperties(user, userLoginVO);
        TokenVO tokenVO = new TokenVO();
        tokenVO.setAccessToken(token);
        tokenVO.setUserLoginVO(userLoginVO);
        tokenVO.setExpiresIn(jwtUtil.getExpire());

        authMapper.updateLastLoginTimeByUsername(userLoginDTO.getUsername());

        return tokenVO;
    }

    @Override
    public void register(UserRegisterDTO userRegisterDTO) {

        String username = userRegisterDTO.getUsername();
        // 账号已存在
        if (authMapper.getUserByUsername(username) != null) {
            throw new BusinessException(ErrorCode.EXISTENT_USER);
        }

        // 包装写入数据
        User user = new User();
        BeanUtils.copyProperties(userRegisterDTO, user);
        user.setPassword(encoder.encode(userRegisterDTO.getPassword()));
        user.setStatus(UserStatus.ACTIVE);

        authMapper.registerUser(user);
    }

    @Override
    public User getUserById(Long userId) {

        User user = authMapper.getUserById(userId);

        if (user == null) {
            throw new BusinessException(ErrorCode.NONEXISTENT_USER);
        }

        return user;
    }

    @Override
    public List<Role> getRolesById(Long userId) {

        List<Role> res = authMapper.getRolesById(userId);

        if (res == null) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR);
        }

        return res;
    }

    @Override
    public List<Permission> getPermissionsById(Long userId) {
        List<Permission> res = authMapper.getPermissionsById(userId);

        if (res == null) {
            throw new BusinessException(ErrorCode.UNKNOWN_ERROR);
        }

        return res;
    }

}
