package com.ethercraft.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    UNKNOWN_ERROR(10086, "未知错误"),
    NONEXISTENT_USER(10087, "账号不存在"),
    DISABLED_USER(10088, "账号已禁用"),
    MISMATCHED_USER_AND_PASSWORD(10089, "账号或密码错误"),
    EXISTENT_USER(10090, "账号已存在"),
    FORBIDDEN(10403, "无操作权限"),
    NOT_SPACE_MEMBER(10404, "不是空间成员");

    private final int code;

    private final String message;

}
