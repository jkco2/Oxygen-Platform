package com.ethercraft.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "空间成员角色修改请求")
public class KnowledgeMemberUpdateDTO {

    @Schema(description = "空间范围角色 ID")
    private Long roleId;

}
