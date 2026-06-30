package com.ethercraft.service;

import com.ethercraft.entity.Permission;

import java.util.List;

public interface PermissionService {

    List<Permission> listPermissions();

    void createPermission(Permission permission);

    void updatePermission(Long permissionId, Permission permission);

    void deletePermission(Long permissionId);
}
