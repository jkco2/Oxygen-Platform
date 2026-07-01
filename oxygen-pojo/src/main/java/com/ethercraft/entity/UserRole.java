package com.ethercraft.entity;

import com.ethercraft.enumeration.ScopeType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "用户角色授权实体")
public class UserRole {

    @Schema(description = "主键 ID")
    private Long id;

    @Schema(description = "用户 ID")
    private Long userId;

    @Schema(description = "角色 ID")
    private Long roleId;

    @Schema(description = "角色授权范围类型")
    private ScopeType scopeType;

    @Schema(description = "角色授权范围 ID，全局角色为空")
    private Long scopeId;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}
