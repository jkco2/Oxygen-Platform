package com.ethercraft.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import com.ethercraft.enumeration.CommonStatus;
import com.ethercraft.enumeration.SpaceVisibility;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "知识空间实体")
public class KnowledgeSpace {

    // 主键 ID
    @Schema(description = "主键 ID")
    private Long id;

    // 知识空间名称
    @Schema(description = "知识空间名称")
    private String spaceName;

    // 知识空间编码
    @Schema(description = "知识空间编码")
    private String spaceCode;

    // 描述
    @Schema(description = "描述")
    private String description;

    // 可见性
    @Schema(description = "可见性")
    private SpaceVisibility visibility;

    // 拥有者用户 ID
    @Schema(description = "拥有者用户 ID")
    private Long ownerId;

    // 状态
    @Schema(description = "状态")
    private CommonStatus status;

    // 创建时间
    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    // 更新时间
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

    // 逻辑删除预留字段，当前业务暂不使用
    @Schema(description = "逻辑删除预留字段，当前业务暂不使用")
    private Boolean deleted;

}
