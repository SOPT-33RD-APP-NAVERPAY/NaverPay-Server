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
    GET_BENEFIT_BRAND_LIST_SUCCESS(HttpStatus.OK, "유저의 혜택 브랜드 리스트 조회에 성공했습니다."),
    GET_RECOMMEND_BRAND_LIST_SUCCESS(HttpStatus.OK, "추천 혜택 브랜드 리스트 조회에 성공했습니다."),
    BRAND_DISLIKE_SUCCESS(HttpStatus.OK, "혜택 브랜드 찜하기 취소에 성공했습니다."),
    GET_PLACE_SUCCESS(HttpStatus.OK, "현장결제 장소 조회에 성공했습니다."),
    GET_POINT_SUCCESS(HttpStatus.OK,"포인트 내역 조회에 성공했습니다."),
    GET_HOME_SUCCESS(HttpStatus.OK, "홈화면 조회에 성공했습니다."),

    /**
     * 201 CREATED
     */
    BRAND_LIKE_SUCCESS(HttpStatus.CREATED, "혜택 브랜드 찜하기 등록에 성공했습니다."),
    ;

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}
