package com.ethercraft.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "空间成员添加请求")
public class SpaceMemberAddDTO {

    @Schema(description = "用户 ID")
    private Long userId;

    @Schema(description = "空间范围角色 ID")
    private Long roleId;

}
