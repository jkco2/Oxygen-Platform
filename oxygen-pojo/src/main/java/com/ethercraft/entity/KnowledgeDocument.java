package com.ethercraft.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import com.ethercraft.enumeration.ContentStatus;
import com.ethercraft.enumeration.DocumentParseStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "知识文档实体")
public class KnowledgeDocument {

    // 主键 ID
    @Schema(description = "主键 ID")
    private Long id;

    // 知识库 ID
    @Schema(description = "知识库 ID")
    private Long kbId;

    // 知识空间 ID
    @Schema(description = "知识空间 ID")
    private Long spaceId;

    // 上传者用户 ID
    @Schema(description = "上传者用户 ID")
    private Long uploaderId;

    // 文件名称
    @Schema(description = "文件名称")
    private String fileName;

    // 文件地址
    @Schema(description = "文件地址")
    private String fileUrl;

    // 文件类型
    @Schema(description = "文件类型")
    private String fileType;

    // 文件大小
    @Schema(description = "文件大小")
    private Long fileSize;

    // 解析状态
    @Schema(description = "解析状态")
    private DocumentParseStatus parseStatus;

    // 解析错误信息
    @Schema(description = "解析错误信息")
    private String parseError;

    // 版本号
    @Schema(description = "版本号")
    private Integer version;

    // 状态
    @Schema(description = "状态")
    private ContentStatus status;

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
