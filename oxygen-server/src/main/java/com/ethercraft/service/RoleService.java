package com.ethercraft.service;

import com.ethercraft.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> listRoles();

    void createRole(Role role);

    void updateRole(Long roleId, Role role);

    void deleteRole(Long roleId);

    void assignRolePermissions(Long roleId, List<Long> permissionIds);
}
