package com.ethercraft.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Data;

// 用于用户注册
@Data
@Schema(description = "用户注册请求")
public class UserRegisterDTO {

    // 登录账号
    @Schema(description = "登录账号")
    private String username;

    // 登录密码
    @Schema(description = "登录密码")
    private String password;

    // 昵称
    @Schema(description = "昵称")
    private String nickname;

    // 邮箱
    @Schema(description = "邮箱")
    private String email;


}
