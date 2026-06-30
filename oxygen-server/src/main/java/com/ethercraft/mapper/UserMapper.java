package com.ethercraft.mapper;

import com.ethercraft.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    void createUser(User user);

    void createUserRole(@Param("roleIds") List<Long> roleIds, @Param("userId") Long userId);
}
