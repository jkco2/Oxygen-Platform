package com.ethercraft.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import com.ethercraft.enumeration.UserStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "用户实体")
public class User {

    // 主键 ID
    @Schema(description = "主键 ID")
    private Long id;

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

    // 手机号
    @Schema(description = "手机号")
    private String phone;

    // 头像地址
    @Schema(description = "头像地址")
    private String avatar;

    // 状态
    @Schema(description = "状态")
    private UserStatus status;

    // 最后登录时间
    @Schema(description = "最后登录时间")
    private LocalDateTime lastLoginTime;

    // 创建时间
    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    // 更新时间
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

    // 逻辑删除标记
    @Schema(description = "逻辑删除标记")
    private Boolean deleted;

}
