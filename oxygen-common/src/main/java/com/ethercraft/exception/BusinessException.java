package com.ethercraft.exception;

import com.ethercraft.enumeration.ErrorCode;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final int code;

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

}
