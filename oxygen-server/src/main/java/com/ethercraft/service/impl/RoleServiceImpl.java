package com.ethercraft.service.impl;

import com.ethercraft.entity.Role;
import com.ethercraft.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Override
    public List<Role> listRoles() {
        return List.of();
    }

    @Override
    public void createRole(Role role) {
    }

    @Override
    public void updateRole(Long roleId, Role role) {
    }

    @Override
    public void deleteRole(Long roleId) {
    }

    @Override
    public void assignRolePermissions(Long roleId, List<Long> permissionIds) {
    }
}
