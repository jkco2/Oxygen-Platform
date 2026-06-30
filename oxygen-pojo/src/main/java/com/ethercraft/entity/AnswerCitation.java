package com.ethercraft.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import com.ethercraft.enumeration.KnowledgeSourceType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "回答引用实体")
public class AnswerCitation {

    // 主键 ID
    @Schema(description = "主键 ID")
    private Long id;

    // 消息 ID
    @Schema(description = "消息 ID")
    private Long messageId;

    // 知识片段 ID
    @Schema(description = "知识片段 ID")
    private Long chunkId;

    // 来源类型
    @Schema(description = "来源类型")
    private KnowledgeSourceType sourceType;

    // 来源 ID
    @Schema(description = "来源 ID")
    private Long sourceId;

    // 来源标题
    @Schema(description = "来源标题")
    private String sourceTitle;

    // 相似度分数
    @Schema(description = "相似度分数")
    private Double score;

    // 引用文本
    @Schema(description = "引用文本")
    private String quoteText;

    // 创建时间
    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}
