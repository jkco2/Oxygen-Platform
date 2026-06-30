package com.ethercraft.vo;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Data;

@Data
@Schema(description = "登录用户信息响应")
public class UserLoginVO {

    // 主键 ID
    @Schema(description = "主键 ID")
    private Long id;

    // 登录账号
    @Schema(description = "登录账号")
    private String username;

    // 昵称
    @Schema(description = "昵称")
    private String nickname;

}
