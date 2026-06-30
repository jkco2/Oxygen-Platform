package com.ethercraft.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "用户角色关联实体")
public class UserRole {

    // 主键 ID
    @Schema(description = "主键 ID")
    private Long id;

    // 用户 ID
    @Schema(description = "用户 ID")
    private Long userId;

    // 角色 ID
    @Schema(description = "角色 ID")
    private Long roleId;

    // 创建时间
    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}
