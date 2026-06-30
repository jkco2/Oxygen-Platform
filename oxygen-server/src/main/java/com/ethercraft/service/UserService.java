package com.ethercraft.service;

import com.ethercraft.dto.*;
import com.ethercraft.result.PageResult;
import com.ethercraft.vo.UserPageVO;

public interface UserService {

    PageResult<UserPageVO> pageUsers(UserPageQueryDTO queryDTO);

    void createUser(UserCreateDTO userCreateDTO);

    void updateUser(UserUpdateDTO userUpdateDTO, Long userId);

    void updateUserStatus(Long userId, UserStatusUpdateDTO userStatusUpdateDTO);

    void assignUserRoles(Long userId, UserRoleAssignDTO userRoleAssignDTO);

    void resetUserPassword(Long userId, UserPasswordResetDTO userPasswordResetDTO);

    void deleteUser(Long userId);
}
