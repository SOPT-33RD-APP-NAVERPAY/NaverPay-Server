package sopt.org.NaverPay.global.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)// 생성자 만드는것
public class ApiResponse<T> {

    private final int status;
    private final String message;
    // status, message는 응답의 상태와 메시지를 나타내는 것이기 때문에 한번 설정되고나면 변경되지 않아야 해서 final로 설정
    // private는 외부에서 직접 접근할 수 없고, 클래스 내부에서만 접근 할 수 있게 한 것

    @JsonInclude(JsonInclude.Include.NON_NULL)  // 데이터 필드가 null인 경우 결과에 포함되지 않도록 설정하기 위해 @JsonInclude 사용
    private T data;


    public static <T> ApiResponse<T> success(SuccessType successType, T data) {
        return new ApiResponse<>(successType.getHttpStatusCode(), successType.getMessage(), data);
    }

    public static ApiResponse error(ErrorType errorType, String message) {
        return new ApiResponse<>(errorType.getHttpStatusCode(), message);
    }

}

