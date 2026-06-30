package com.ethercraft.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import com.ethercraft.enumeration.UserStatus;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

// 用于后台管理员创建用户
@Data
@Schema(description = "后台创建用户请求")
public class UserCreateDTO {

    // 登录账号
    @Schema(description = "登录账号")
    @NotEmpty
    private String username;

    // 登录密码
    @Schema(description = "登录密码")
    @NotEmpty
    private String password;

    // 昵称
    @Schema(description = "昵称")
    @NotEmpty
    private String nickname;

    // 邮箱
    @Schema(description = "邮箱")
    private String email;

    // 手机号
    @Schema(description = "手机号")
    private String phone;

    // 头像地址
    @Schema(description = "头像地址")
    private String avatar;

    // 状态
    @Schema(description = "状态")
    private UserStatus status;

    // 角色 ID 列表
    @Schema(description = "角色 ID 列表")
    private List<Long> roleIds;

}
