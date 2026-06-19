package com.ethercraft.result;

import com.ethercraft.constant.ResultStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Result<T> {
    private final int code;
    private final String message;
    private final T data;

    public static <T> Result<T> success(T data) {
        return new Result<>(ResultStatus.SUCCESS, "Success", data);
    }

    public static Result<Void> success() {
        return new Result<>(ResultStatus.SUCCESS, "Success", null);
    }

    public static Result<Void> fail() {
        return new Result<>(ResultStatus.FAIL, "Fail", null);
    }
}
