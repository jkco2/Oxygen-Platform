package com.ethercraft.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Result<T> {
    private final int code;
    private final String message;
    private final T data;

    public static <T> Result<T> success(T data) {
        return new Result<>(200, "Success", data);
    }

    public static Result<Void> success() {
        return new Result<>(200, "Success", null);
    }

    public static Result<Void> fail(int code, String message) {
        return new Result<>(code, message, null);
    }

}
