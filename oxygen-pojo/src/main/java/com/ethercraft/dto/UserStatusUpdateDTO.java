package com.ethercraft.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import com.ethercraft.enumeration.UserStatus;
import lombok.Data;

// 用于启用或禁用用户
@Data
@Schema(description = "用户状态修改请求")
public class UserStatusUpdateDTO {

    // 状态
    @Schema(description = "状态")
    private UserStatus status;

}
