package com.ethercraft.vo;

import io.swagger.v3.oas.annotations.media.Schema;

import com.ethercraft.entity.Permission;
import com.ethercraft.entity.Role;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "当前用户信息响应")
public class UserMeVO {

    // 主键 ID
    @Schema(description = "主键 ID")
    private Long id;

    // 登录账号
    @Schema(description = "登录账号")
    private String username;

    // 昵称
    @Schema(description = "昵称")
    private String nickname;

    // 角色列表
    @Schema(description = "角色列表")
    private List<Role> roles;

    // 权限列表
    @Schema(description = "权限列表")
    private List<Permission> permissions;

}
