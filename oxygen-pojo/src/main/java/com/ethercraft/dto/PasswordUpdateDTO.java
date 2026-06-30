package com.ethercraft.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Data;

// 用于用户自己修改密码
@Data
@Schema(description = "用户修改密码请求")
public class PasswordUpdateDTO {

    // 旧密码
    @Schema(description = "旧密码")
    private String oldPassword;

    // 新密码
    @Schema(description = "新密码")
    private String newPassword;

}
