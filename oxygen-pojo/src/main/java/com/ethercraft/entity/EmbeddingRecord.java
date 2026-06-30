package com.ethercraft.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import com.ethercraft.enumeration.EmbeddingStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "向量记录实体")
public class EmbeddingRecord {

    // 主键 ID
    @Schema(description = "主键 ID")
    private Long id;

    // 知识片段 ID
    @Schema(description = "知识片段 ID")
    private Long chunkId;

    // 向量库记录 ID
    @Schema(description = "向量库记录 ID")
    private String embeddingId;

    // 模型名称
    @Schema(description = "模型名称")
    private String modelName;

    // 向量维度
    @Schema(description = "向量维度")
    private Integer dimension;

    // 状态
    @Schema(description = "状态")
    private EmbeddingStatus status;

    // 创建时间
    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    // 更新时间
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

}
