package com.ethercraft.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Data;

// 用于用户登录
@Data
@Schema(description = "用户登录请求")
public class UserLoginDTO {

    // 登录账号
    @Schema(description = "登录账号")
    private String username;

    // 登录密码
    @Schema(description = "登录密码")
    private String password;

}
