package com.ethercraft.vo;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Data;

@Data
@Schema(description = "登录令牌响应")
public class TokenVO {

    // 访问令牌
    @Schema(description = "访问令牌")
    private String accessToken;

    // 令牌类型
    @Schema(description = "令牌类型")
    private String tokenType;

    // 过期时间
    @Schema(description = "过期时间")
    private Long expiresIn;

    // 登录用户信息
    @Schema(description = "登录用户信息")
    private UserLoginVO userLoginVO;

}
