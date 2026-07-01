package com.ethercraft.entity;

import com.ethercraft.enumeration.CommonStatus;
import com.ethercraft.enumeration.ScopeType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "角色实体")
public class Role {

    @Schema(description = "主键 ID")
    private Long id;

    @Schema(description = "角色编码")
    private String roleCode;

    @Schema(description = "角色名称")
    private String roleName;

    @Schema(description = "描述")
    private String description;

    @Schema(description = "角色生效范围")
    private ScopeType scopeType;

    @Schema(description = "状态")
    private CommonStatus status;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

    @Schema(description = "逻辑删除预留字段")
    private Boolean deleted;

}
