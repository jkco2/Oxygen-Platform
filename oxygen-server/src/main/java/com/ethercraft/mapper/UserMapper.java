package com.ethercraft.mapper;

import com.ethercraft.dto.UserPageQueryDTO;
import com.ethercraft.dto.UserStatusUpdateDTO;
import com.ethercraft.entity.User;
import com.ethercraft.vo.UserPageVO;
import com.ethercraft.vo.UserRoleCodeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    void createUser(User user);

    void insertUserRoles(@Param("userId") Long userId, @Param("roleIds") List<Long> roleIds);

    List<UserPageVO> pageUsers(UserPageQueryDTO queryDTO);

    List<UserRoleCodeVO> listUserRoleCodes(@Param("userIds") List<Long> userIds);

    void updateUser(User user);

    void updateUserStatus(@Param("userId") Long userId, @Param("dto") UserStatusUpdateDTO userStatusUpdateDTO);

    void deleteUserRolesByUserId(@Param("userId") Long userId);

    void updateUserPassword(@Param("userId") Long userId, @Param("newPassword") String newPassword);

    void deleteUser(@Param("userId") Long userId);
}
