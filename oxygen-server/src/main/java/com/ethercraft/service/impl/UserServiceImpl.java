package com.ethercraft.service.impl;

import com.ethercraft.dto.*;
import com.ethercraft.entity.User;
import com.ethercraft.enumeration.UserStatus;
import com.ethercraft.mapper.UserMapper;
import com.ethercraft.result.PageResult;
import com.ethercraft.service.UserService;
import com.ethercraft.vo.UserPageVO;
import com.ethercraft.vo.UserRoleCodeVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private final UserMapper userMapper;

    @Override
    public PageResult<UserPageVO> pageUsers(UserPageQueryDTO queryDTO) {

        PageInfo<UserPageVO> pageInfo =
                PageHelper.startPage(queryDTO.getPage(), queryDTO.getSize())
                        .doSelectPageInfo(() -> userMapper.pageUsers(queryDTO));

        List<UserPageVO> users = pageInfo.getList();
        if (!users.isEmpty()) {
            List<Long> userIds = users.stream()
                    .map(UserPageVO::getId)
                    .toList();
            Map<Long, List<String>> roleMap = userMapper.listUserRoleCodes(userIds).stream()
                    .collect(Collectors.groupingBy(
                            UserRoleCodeVO::getUserId,
                            Collectors.mapping(UserRoleCodeVO::getRoleCode, Collectors.toList())
                    ));
            users.forEach(user -> user.setRoles(roleMap.getOrDefault(user.getId(), List.of())));
        }

        return new PageResult<>(
                users,
                pageInfo.getTotal(),
                pageInfo.getPageNum(),
                pageInfo.getPageSize(),
                pageInfo.getPages()
        );
    }

    @Override
    public void createUser(UserCreateDTO userCreateDTO) {

        User user = new User();

        BeanUtils.copyProperties(userCreateDTO, user);
        if (user.getStatus() == null) {
            user.setStatus(UserStatus.ACTIVE);
        }
        userMapper.createUser(user);

        List<Long> roleIds = userCreateDTO.getRoleIds();

        if (roleIds != null && !roleIds.isEmpty()) {
            userMapper.insertUserRoles(user.getId(), roleIds);
        }

    }

    @Override
    public void updateUser(UserUpdateDTO userUpdateDTO, Long userId) {

        User user = new User();

        BeanUtils.copyProperties(userUpdateDTO, user);
        user.setId(userId);

        userMapper.updateUser(user);

    }

    @Override
    public void updateUserStatus(Long userId, UserStatusUpdateDTO userStatusUpdateDTO) {

        userMapper.updateUserStatus(userId, userStatusUpdateDTO);

    }

    @Override
    public void assignUserRoles(Long userId, UserRoleAssignDTO userRoleAssignDTO) {

        userMapper.deleteUserRolesByUserId(userId);

        List<Long> roleIds = userRoleAssignDTO.getRoleIds();
        if (roleIds != null && !roleIds.isEmpty()) {
            userMapper.insertUserRoles(userId, roleIds);
        }

    }

    @Override
    public void resetUserPassword(Long userId, UserPasswordResetDTO userPasswordResetDTO) {

        String newPassword = encoder.encode(userPasswordResetDTO.getNewPassword());

        userMapper.updateUserPassword(userId, newPassword);

    }

    @Override
    public void deleteUser(Long userId) {

        userMapper.deleteUserRolesByUserId(userId);
        userMapper.deleteUser(userId);

    }
}
