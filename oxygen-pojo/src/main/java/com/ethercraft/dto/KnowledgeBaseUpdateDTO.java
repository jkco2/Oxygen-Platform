package com.ethercraft.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import com.ethercraft.enumeration.KnowledgeBaseVisibility;
import lombok.Data;

@Data
@Schema(description = "知识库修改请求")
public class KnowledgeBaseUpdateDTO {

    // 知识库名称
    @Schema(description = "知识库名称")
    private String kbName;

    // 描述
    @Schema(description = "描述")
    private String description;

    // 可见性
    @Schema(description = "可见性")
    private KnowledgeBaseVisibility visibility;

    // 封面地址
    @Schema(description = "封面地址")
    private String coverUrl;

}
