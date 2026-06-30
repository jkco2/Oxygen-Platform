package com.ethercraft.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Data;

import java.util.List;

// 用于给用户覆盖是分配角色
@Data
@Schema(description = "用户角色分配请求")
public class UserRoleAssignDTO {

    // 角色 ID 列表
    @Schema(description = "角色 ID 列表")
    private List<Long> roleIds;

}
