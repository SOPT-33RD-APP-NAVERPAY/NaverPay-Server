package sopt.org.NaverPay.common;

import org.springframework.http.HttpStatus;

public enum SuccessType {
    /**
     * 200 OK
     */
    LOGIN_SUCCESS(HttpStatus.OK, "로그인에 성공했습니다.");

    private final HttpStatus httpStatus;
    private String message;

    SuccessType(HttpStatus httpStatus, String message)
    {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
