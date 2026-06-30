package com.ethercraft.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "知识条目标签关联实体")
public class ArticleTag {

    // 主键 ID
    @Schema(description = "主键 ID")
    private Long id;

    // 知识条目 ID
    @Schema(description = "知识条目 ID")
    private Long articleId;

    // 标签 ID
    @Schema(description = "标签 ID")
    private Long tagId;

    // 创建时间
    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}
