package com.ethercraft.service;

import com.ethercraft.dto.UserLoginDTO;
import com.ethercraft.dto.UserRegisterDTO;
import com.ethercraft.entity.Permission;
import com.ethercraft.entity.Role;
import com.ethercraft.entity.User;
import com.ethercraft.vo.TokenVO;

import java.util.List;

public interface AuthService {

    TokenVO login(UserLoginDTO userLoginDTO);

    void register(UserRegisterDTO userRegisterDTO);

    User getUserById(Long userId);

    List<Role> getRolesById(Long userId);

    List<Permission> getPermissionsById(Long userId);
}
