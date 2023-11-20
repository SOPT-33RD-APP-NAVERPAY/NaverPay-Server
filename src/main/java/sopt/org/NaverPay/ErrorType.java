package sopt.org.NaverPay;

import org.springframework.http.HttpStatus;

public enum ErrorType {

    /**
     * 400 BAD REQUEST
     */
    // Common
    REQUEST_VALIDATION_EXCEPTION(HttpStatus.BAD_REQUEST, "잘못된 요청입니다"),
}
