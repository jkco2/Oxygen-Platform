package com.ethercraft.controller;

import com.ethercraft.context.UserContext;
import com.ethercraft.dto.UserLoginDTO;
import com.ethercraft.dto.UserRegisterDTO;
import com.ethercraft.entity.Permission;
import com.ethercraft.entity.Role;
import com.ethercraft.entity.User;
import com.ethercraft.result.Result;
import com.ethercraft.service.AuthService;
import com.ethercraft.vo.TokenVO;
import com.ethercraft.vo.UserMeVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "认证管理")
@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    /**
     * 用户登录
     * @param userLoginDTO 登录表单
     * @return 登录视图
     */
    @Operation(summary = "用户登录")
    @PostMapping("/login")
    public Result<TokenVO> login(@RequestBody UserLoginDTO userLoginDTO) {

        log.info("用户{}尝试登录", userLoginDTO.getUsername());

        return Result.success(authService.login(userLoginDTO));

    }

    /**
     * 用户注册
     * @param userRegisterDTO 注册表单
     * @return 注册结果
     */
    @Operation(summary = "用户注册")
    @PostMapping("/register")
    public Result<Void> register(@RequestBody UserRegisterDTO userRegisterDTO) {

        log.info("服务器尝试注册用户{}", userRegisterDTO.getUsername());

        authService.register(userRegisterDTO);

        log.info("注册成功");
        return Result.success();
    }


    @Operation(summary = "获取用户信息")
    @GetMapping("/me")
    public Result<UserMeVO> me() {

        Long userId = UserContext.getUserId();
        log.info("获取用户{}信息", userId);

        User user = authService.getUserById(userId);
        List<Role> roles = authService.getRolesById(userId);
        List<Permission> permissions = authService.getPermissionsById(userId);

        UserMeVO userMeVO = new UserMeVO();
        BeanUtils.copyProperties(user, userMeVO);
        userMeVO.setRoles(roles);
        userMeVO.setPermissions(permissions);

        return Result.success(userMeVO);
    }

    @Operation(summary = "登出")
    @PostMapping("/logout")
    public Result<Void> logout() {
        // TODO
        return Result.success();
    }

}
