package com.ethercraft.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import com.ethercraft.enumeration.ChunkStatus;
import com.ethercraft.enumeration.KnowledgeSourceType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "知识片段实体")
public class DocumentChunk {

    // 主键 ID
    @Schema(description = "主键 ID")
    private Long id;

    // 来源类型
    @Schema(description = "来源类型")
    private KnowledgeSourceType sourceType;

    // 来源 ID
    @Schema(description = "来源 ID")
    private Long sourceId;

    // 知识空间 ID
    @Schema(description = "知识空间 ID")
    private Long spaceId;

    // 知识库 ID
    @Schema(description = "知识库 ID")
    private Long kbId;

    // 片段序号
    @Schema(description = "片段序号")
    private Integer chunkIndex;

    // 正文内容
    @Schema(description = "正文内容")
    private String content;

    // token 数
    @Schema(description = "token 数")
    private Integer tokenCount;

    // 状态
    @Schema(description = "状态")
    private ChunkStatus status;

    // 创建时间
    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    // 更新时间
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

}
