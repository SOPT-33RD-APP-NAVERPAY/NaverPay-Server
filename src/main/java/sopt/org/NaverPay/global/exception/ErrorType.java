package sopt.org.NaverPay.global.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public enum ErrorType {
    /**
     * 400 BAD REQUEST
     */
    REQUEST_VALIDATION_EXCEPTION(HttpStatus.BAD_REQUEST, "잘못된 요청입니다"),
    ALREADY_LIKE_BRAND(HttpStatus.BAD_REQUEST, "이미 찜하기 한 브랜드 입니다."),
    NOT_FOUND_BRAND_LIKE(HttpStatus.BAD_REQUEST, "브랜드 찜하기 내역이 존재하지 않습니다."),

    /**
     * 401 UNAUTHORIZED
     */

    /**
     * 404 NOT FOUND
     */
    NOT_FOUND_USER(HttpStatus.NOT_FOUND, "존재하지 않는 유저입니다."),
    NOT_FOUND_BRAND(HttpStatus.NOT_FOUND, "존재하지 않는 브랜드입니다."),

    /**
     * 500 INTERNAL SERVER ERROR
     */
    ;

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }

}
