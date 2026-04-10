package com.example.backendmodule.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public class ResponseFactory {

    public static <T> ResponseWrapper<T> success(T data, String message) {
        return new ResponseWrapper<>(
                true,
                data,
                message,
                LocalDateTime.now(),
                null
        );
    }

    public static <T> ResponseWrapper<T> success(T data) {
        return success(data, "Operação realizada com sucesso");
    }

    public static <T> ResponseWrapper<T> error(String message, List<String> errors) {
        return new ResponseWrapper<>(
                false,
                null,
                message,
                LocalDateTime.now(),
                errors
        );
    }
}
