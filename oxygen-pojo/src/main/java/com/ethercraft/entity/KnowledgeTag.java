package com.ethercraft.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "知识标签实体")
public class KnowledgeTag {

    // 主键 ID
    @Schema(description = "主键 ID")
    private Long id;

    // 知识空间 ID
    @Schema(description = "知识空间 ID")
    private Long spaceId;

    // 标签名称
    @Schema(description = "标签名称")
    private String tagName;

    // 颜色
    @Schema(description = "颜色")
    private String color;

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
