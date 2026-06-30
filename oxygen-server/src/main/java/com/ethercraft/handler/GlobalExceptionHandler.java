package com.ethercraft.handler;

import com.ethercraft.enumeration.ErrorCode;
import com.ethercraft.exception.BusinessException;
import com.ethercraft.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public Result<?> handlerBusinessException(BusinessException e) {
        return Result.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result<?> handlerException(Exception e) {
        return Result.fail(ErrorCode.UNKNOWN_ERROR.getCode(), ErrorCode.UNKNOWN_ERROR.getMessage());
    }
}
