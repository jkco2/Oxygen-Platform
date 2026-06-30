package com.ethercraft.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Data;

// 用于后台管理员重置用户密码
@Data
@Schema(description = "后台重置用户密码请求")
public class UserPasswordResetDTO {

    // 新密码
    @Schema(description = "新密码")
    private String newPassword;

}
