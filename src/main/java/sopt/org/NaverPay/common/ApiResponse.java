package sopt.org.NaverPay.common;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ApiResponse<T> {
    private final int status;
    private final String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
}

