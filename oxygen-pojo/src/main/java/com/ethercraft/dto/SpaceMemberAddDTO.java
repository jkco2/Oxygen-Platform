package com.ethercraft.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import com.ethercraft.enumeration.SpaceRole;
import lombok.Data;

@Data
@Schema(description = "空间成员添加请求")
public class SpaceMemberAddDTO {

    // 用户 ID
    @Schema(description = "用户 ID")
    private Long userId;

    // 空间角色
    @Schema(description = "空间角色")
    private SpaceRole spaceRole;

}
