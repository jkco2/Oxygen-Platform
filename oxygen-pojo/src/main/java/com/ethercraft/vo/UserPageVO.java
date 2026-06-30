package com.ethercraft.vo;

import io.swagger.v3.oas.annotations.media.Schema;

import com.ethercraft.enumeration.UserStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Schema(description = "用户分页列表响应")
public class UserPageVO {

    // 主键 ID
    @Schema(description = "主键 ID")
    private Long id;

    // 登录账号
    @Schema(description = "登录账号")
    private String username;

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

    // 状态
    @Schema(description = "状态")
    private UserStatus status;

    // 角色列表
    @Schema(description = "角色列表")
    private List<String> roles;

    // 创建时间
    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    // 最后登录时间
    @Schema(description = "最后登录时间")
    private LocalDateTime lastLoginTime;

}
