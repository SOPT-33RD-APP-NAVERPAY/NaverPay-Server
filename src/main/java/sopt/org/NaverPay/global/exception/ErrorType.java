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
    VALIDATION_WRONG_TYPE_EXCEPTION(HttpStatus.BAD_REQUEST, "잘못된 타입이 입력되었습니다."),
    HEADER_REQUEST_MISSING_EXCEPTION(HttpStatus.BAD_REQUEST, "요청에 필요한 헤더값이 존재하지 않습니다."),
    INVALID_HTTP_METHOD(HttpStatus.BAD_REQUEST, "지원되지 않는 HTTP Method 요청입니다."),

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
    INDEX_OUT_OF_BOUNDS(HttpStatus.INTERNAL_SERVER_ERROR, "인덱스 범위를 초과했습니다."),

    ;

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }

}
