package com.ethercraft.mapper;

import com.ethercraft.entity.Permission;
import com.ethercraft.entity.Role;
import com.ethercraft.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AuthMapper {

    User getUserByUsername(@Param("username") String username);

    void registerUser(User user);

    User getUserById(@Param("userId") Long userId);

    List<Role> getRolesById(@Param("userId") Long userId);

    List<Permission> getPermissionsById(@Param("userId") Long userId);

    void updateLastLoginTimeByUsername(@Param("username") String username);
}
