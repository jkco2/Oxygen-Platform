package com.ethercraft.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import com.ethercraft.enumeration.UserStatus;
import lombok.Data;

// 用于用户分页查询
@Data
@Schema(description = "用户分页查询请求")
public class UserQueryDTO {

    // 页码
    @Schema(description = "页码")
    private Integer page = 1;

    // 每页数量
    @Schema(description = "每页数量")
    private Integer size  = 10;

    // 搜索关键字
    @Schema(description = "搜索关键字")
    private String keyword;

    // 状态
    @Schema(description = "状态")
    private UserStatus status;

}
