package com.ethercraft.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import com.ethercraft.enumeration.KnowledgeBaseStatus;
import com.ethercraft.enumeration.KnowledgeBaseVisibility;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "知识库实体")
public class KnowledgeBase {

    // 主键 ID
    @Schema(description = "主键 ID")
    private Long id;

    // 知识空间 ID
    @Schema(description = "知识空间 ID")
    private Long spaceId;

    // 知识库名称
    @Schema(description = "知识库名称")
    private String kbName;

    // 描述
    @Schema(description = "描述")
    private String description;

    // 封面地址
    @Schema(description = "封面地址")
    private String coverUrl;

    // 可见性
    @Schema(description = "可见性")
    private KnowledgeBaseVisibility visibility;

    // 拥有者用户 ID
    @Schema(description = "拥有者用户 ID")
    private Long ownerId;

    // 状态
    @Schema(description = "状态")
    private KnowledgeBaseStatus status;

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
