package com.ethercraft.controller;

import com.ethercraft.constant.PermissionCodes;
import com.ethercraft.dto.*;
import com.ethercraft.result.PageResult;
import com.ethercraft.result.Result;
import com.ethercraft.service.UserService;
import com.ethercraft.vo.UserPageVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Tag(name = "用户管理")
@Slf4j
@RestController
@RequestMapping("/api/admin/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "分页查询用户")
    @GetMapping
    @PreAuthorize(PermissionCodes.Expr.USER_VIEW)
    public Result<PageResult<UserPageVO>> pageUsers(@ParameterObject UserPageQueryDTO queryDTO) {
        return Result.success(userService.pageUsers(queryDTO));
    }

    @Operation(summary = "创建用户")
    @PostMapping
    @PreAuthorize(PermissionCodes.Expr.USER_CREATE)
    public Result<Void> createUser(@RequestBody UserCreateDTO userCreateDTO) {
        userService.createUser(userCreateDTO);
        return Result.success();
    }

    @Operation(summary = "修改用户资料")
    @PutMapping("/{userId}")
    @PreAuthorize(PermissionCodes.Expr.USER_UPDATE)
    public Result<Void> updateUser(@RequestBody UserUpdateDTO userUpdateDTO, @PathVariable Long userId) {
        userService.updateUser(userUpdateDTO, userId);
        return Result.success();
    }

    @Operation(summary = "修改用户状态")
    @PutMapping("/{userId}/status")
    @PreAuthorize(PermissionCodes.Expr.USER_UPDATE)
    public Result<Void> updateUserStatus(@PathVariable Long userId, @RequestBody UserStatusUpdateDTO userStatusUpdateDTO) {

        userService.updateUserStatus(userId, userStatusUpdateDTO);

        return Result.success();
    }

    @Operation(summary = "给用户分配角色")
    @PutMapping("/{userId}/roles")
    @PreAuthorize(PermissionCodes.Expr.ROLE_MANAGE)
    public Result<Void> assignUserRoles(@PathVariable Long userId, @RequestBody UserRoleAssignDTO userRoleAssignDTO) {

        userService.assignUserRoles(userId, userRoleAssignDTO);

        return Result.success();
    }

    @Operation(summary = "重置用户密码")
    @PutMapping("/{userId}/password")
    @PreAuthorize(PermissionCodes.Expr.USER_UPDATE)
    public Result<Void> resetUserPassword(@PathVariable Long userId, @RequestBody UserPasswordResetDTO userPasswordResetDTO) {
        userService.resetUserPassword(userId, userPasswordResetDTO);

        return Result.success();
    }

    @Operation(summary = "删除用户")
    @DeleteMapping("/{userId}")
    @PreAuthorize(PermissionCodes.Expr.USER_DELETE)
    public Result<Void> deleteUser(@PathVariable Long userId) {

        userService.deleteUser(userId);

        return Result.success();
    }

}
