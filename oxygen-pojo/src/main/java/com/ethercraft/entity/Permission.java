package com.ethercraft.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import com.ethercraft.enumeration.CommonStatus;
import com.ethercraft.enumeration.ResourceType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "权限实体")
public class Permission {

    // 主键 ID
    @Schema(description = "主键 ID")
    private Long id;

    // 权限编码
    @Schema(description = "权限编码")
    private String permissionCode;

    // 权限名称
    @Schema(description = "权限名称")
    private String permissionName;

    // 资源类型
    @Schema(description = "资源类型")
    private ResourceType resourceType;

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
