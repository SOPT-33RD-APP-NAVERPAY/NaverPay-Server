package sopt.org.NaverPay.global.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public enum SuccessType {
    /**
     * 200 OK
     */
    LOGIN_SUCCESS(HttpStatus.OK, "로그인에 성공했습니다."),
    GET_BENEFIT_BRAND_LIST_SUCCESS(HttpStatus.OK, "유저의 혜택 브랜드 리스트 조회에 성공했습니다."),
    GET_RECOMMEND_BRAND_LIST_SUCCESS(HttpStatus.OK, "추천 혜택 브랜드 리스트 조회에 성공했습니다."),

    /**
     * 201 CREATED
     */
    ;

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}
