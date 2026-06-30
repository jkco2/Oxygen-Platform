package com.ethercraft.controller;

import com.ethercraft.constant.PermissionCodes;
import com.ethercraft.entity.Permission;
import com.ethercraft.result.Result;
import com.ethercraft.service.PermissionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "权限管理")
@Slf4j
@RestController
@RequestMapping("/api/admin/permissions")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;

    @Operation(summary = "查询权限列表")
    @GetMapping
    @PreAuthorize(PermissionCodes.Expr.PERMISSION_MANAGE)
    public Result<List<Permission>> listPermissions() {
        return Result.success(permissionService.listPermissions());
    }

    @Operation(summary = "创建权限")
    @PostMapping
    @PreAuthorize(PermissionCodes.Expr.PERMISSION_MANAGE)
    public Result<Void> createPermission(@RequestBody Permission permission) {
        permissionService.createPermission(permission);
        return Result.success();
    }

    @Operation(summary = "修改权限")
    @PutMapping("/{permissionId}")
    @PreAuthorize(PermissionCodes.Expr.PERMISSION_MANAGE)
    public Result<Void> updatePermission(@PathVariable Long permissionId, @RequestBody Permission permission) {
        permissionService.updatePermission(permissionId, permission);
        return Result.success();
    }

    @Operation(summary = "删除权限")
    @DeleteMapping("/{permissionId}")
    @PreAuthorize(PermissionCodes.Expr.PERMISSION_MANAGE)
    public Result<Void> deletePermission(@PathVariable Long permissionId) {
        permissionService.deletePermission(permissionId);
        return Result.success();
    }
}
