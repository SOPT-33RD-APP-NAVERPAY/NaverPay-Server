package sopt.org.NaverPay.common;

import org.springframework.http.HttpStatus;

public enum ErrorType {
    /**
     * 400 BAD REQUEST
     */
    REQUEST_VALIDATION_EXCEPTION(HttpStatus.BAD_REQUEST, "잘못된 요청입니다");

    private final HttpStatus httpStatus;
    private String message;

    ErrorType(HttpStatus httpStatus, String message)
    {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
