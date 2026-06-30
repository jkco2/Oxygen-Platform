package com.ethercraft.controller;

import com.ethercraft.constant.PermissionCodes;
import com.ethercraft.entity.Role;
import com.ethercraft.result.Result;
import com.ethercraft.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "角色管理")
@Slf4j
@RestController
@RequestMapping("/api/admin/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @Operation(summary = "查询角色列表")
    @GetMapping
    @PreAuthorize(PermissionCodes.Expr.ROLE_MANAGE)
    public Result<List<Role>> listRoles() {
        return Result.success(roleService.listRoles());
    }

    @Operation(summary = "创建角色")
    @PostMapping
    @PreAuthorize(PermissionCodes.Expr.ROLE_MANAGE)
    public Result<Void> createRole(@RequestBody Role role) {
        roleService.createRole(role);
        return Result.success();
    }

    @Operation(summary = "修改角色")
    @PutMapping("/{roleId}")
    @PreAuthorize(PermissionCodes.Expr.ROLE_MANAGE)
    public Result<Void> updateRole(@PathVariable Long roleId, @RequestBody Role role) {
        roleService.updateRole(roleId, role);
        return Result.success();
    }

    @Operation(summary = "删除角色")
    @DeleteMapping("/{roleId}")
    @PreAuthorize(PermissionCodes.Expr.ROLE_MANAGE)
    public Result<Void> deleteRole(@PathVariable Long roleId) {
        roleService.deleteRole(roleId);
        return Result.success();
    }

    @Operation(summary = "给角色分配权限")
    @PutMapping("/{roleId}/permissions")
    @PreAuthorize(PermissionCodes.Expr.ROLE_MANAGE)
    public Result<Void> assignRolePermissions(@PathVariable Long roleId, @RequestBody List<Long> permissionIds) {
        roleService.assignRolePermissions(roleId, permissionIds);
        return Result.success();
    }
}
