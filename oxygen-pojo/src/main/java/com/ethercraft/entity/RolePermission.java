package com.ethercraft.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "角色权限关联实体")
public class RolePermission {

    // 主键 ID
    @Schema(description = "主键 ID")
    private Long id;

    // 角色 ID
    @Schema(description = "角色 ID")
    private Long roleId;

    // 权限 ID
    @Schema(description = "权限 ID")
    private Long permissionId;

    // 创建时间
    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}
