package com.ethercraft.mapper;

import com.ethercraft.enumeration.ScopeType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoleAssignmentMapper {

    boolean hasGlobalPermission(@Param("userId") Long userId, @Param("permissionCode") String permissionCode);

    boolean hasScopedPermission(@Param("userId") Long userId,
                                @Param("permissionCode") String permissionCode,
                                @Param("scopeType") ScopeType scopeType,
                                @Param("scopeId") Long scopeId);

}
