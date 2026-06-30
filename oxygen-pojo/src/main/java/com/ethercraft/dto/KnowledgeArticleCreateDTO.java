package com.ethercraft.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import com.ethercraft.enumeration.ContentStatus;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "知识条目创建请求")
public class KnowledgeArticleCreateDTO {

    // 标题
    @Schema(description = "标题")
    private String title;

    // 摘要
    @Schema(description = "摘要")
    private String summary;

    // 正文内容
    @Schema(description = "正文内容")
    private String content;

    // 状态
    @Schema(description = "状态")
    private ContentStatus status;

    // 标签 ID 列表
    @Schema(description = "标签 ID 列表")
    private List<Long> tagIds;

}
