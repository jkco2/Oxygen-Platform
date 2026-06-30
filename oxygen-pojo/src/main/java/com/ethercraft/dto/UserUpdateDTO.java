package com.ethercraft.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Data;

// 用于用户更新信息
@Data
@Schema(description = "用户资料修改请求")
public class UserUpdateDTO {

    // 昵称
    @Schema(description = "昵称")
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

}
