package com.ethercraft.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import com.ethercraft.enumeration.SpaceVisibility;
import lombok.Data;

@Data
@Schema(description = "知识空间创建请求")
public class KnowledgeSpaceCreateDTO {

    // 知识空间名称
    @Schema(description = "知识空间名称")
    private String spaceName;

    // 知识空间编码
    @Schema(description = "知识空间编码")
    private String spaceCode;

    // 描述
    @Schema(description = "描述")
    private String description;

    // 可见性
    @Schema(description = "可见性")
    private SpaceVisibility visibility;

}
