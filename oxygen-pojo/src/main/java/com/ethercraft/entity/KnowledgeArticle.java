package com.ethercraft.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import com.ethercraft.enumeration.ContentStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "知识条目实体")
public class KnowledgeArticle {

    // 主键 ID
    @Schema(description = "主键 ID")
    private Long id;

    // 知识库 ID
    @Schema(description = "知识库 ID")
    private Long kbId;

    // 知识空间 ID
    @Schema(description = "知识空间 ID")
    private Long spaceId;

    // 标题
    @Schema(description = "标题")
    private String title;

    // 摘要
    @Schema(description = "摘要")
    private String summary;

    // 正文内容
    @Schema(description = "正文内容")
    private String content;

    // 作者用户 ID
    @Schema(description = "作者用户 ID")
    private Long authorId;

    // 状态
    @Schema(description = "状态")
    private ContentStatus status;

    // 浏览次数
    @Schema(description = "浏览次数")
    private Integer viewCount;

    // 点赞次数
    @Schema(description = "点赞次数")
    private Integer likeCount;

    // 版本号
    @Schema(description = "版本号")
    private Integer version;

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
