package com.ethercraft.service.impl;

import com.ethercraft.entity.Permission;
import com.ethercraft.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Override
    public List<Permission> listPermissions() {
        return List.of();
    }

    @Override
    public void createPermission(Permission permission) {
    }

    @Override
    public void updatePermission(Long permissionId, Permission permission) {
    }

    @Override
    public void deletePermission(Long permissionId) {
    }
}
