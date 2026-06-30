package com.ethercraft.vo;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Data;

@Data
@Schema(description = "用户角色编码响应")
public class UserRoleCodeVO {

    // 用户 ID
    @Schema(description = "用户 ID")
    private Long userId;

    // 角色编码
    @Schema(description = "角色编码")
    private String roleCode;

}
