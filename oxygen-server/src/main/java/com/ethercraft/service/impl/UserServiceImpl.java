package com.ethercraft.service.impl;

import com.ethercraft.dto.UserCreateDTO;
import com.ethercraft.entity.User;
import com.ethercraft.enumeration.UserStatus;
import com.ethercraft.mapper.UserMapper;
import com.ethercraft.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public void createUser(UserCreateDTO userCreateDTO) {

        User user = new User();

        BeanUtils.copyProperties(userCreateDTO, user);
        if (user.getStatus() == null) {
            user.setStatus(UserStatus.ACTIVE);
        }
        userMapper.createUser(user);

        List<Long> roleIds = userCreateDTO.getRoleIds();

        if (roleIds != null && !roleIds.isEmpty()) {
            userMapper.createUserRole(userCreateDTO.getRoleIds(), user.getId());
        }

    }
}
