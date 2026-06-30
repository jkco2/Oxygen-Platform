package com.ethercraft.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import com.ethercraft.enumeration.CommonStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "角色实体")
public class Role {

    // 主键 ID
    @Schema(description = "主键 ID")
    private Long id;

    // 角色编码
    @Schema(description = "角色编码")
    private String roleCode;

    // 角色名称
    @Schema(description = "角色名称")
    private String roleName;

    // 描述
    @Schema(description = "描述")
    private String description;

    // 状态
    @Schema(description = "状态")
    private CommonStatus status;

    // 创建时间
    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    // 更新时间
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

    // 逻辑删除标记
    @Schema(description = "逻辑删除标记")
    private Boolean deleted;

}
