package com.ethercraft.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import com.ethercraft.enumeration.SpaceVisibility;
import lombok.Data;

@Data
@Schema(description = "知识空间修改请求")
public class KnowledgeSpaceUpdateDTO {

    // 知识空间名称
    @Schema(description = "知识空间名称")
    private String spaceName;

    // 描述
    @Schema(description = "描述")
    private String description;

    // 可见性
    @Schema(description = "可见性")
    private SpaceVisibility visibility;

}
