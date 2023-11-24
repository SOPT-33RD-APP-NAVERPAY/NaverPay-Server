package sopt.org.NaverPay.global.advice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import sopt.org.NaverPay.global.exception.ApiResponse;
import sopt.org.NaverPay.global.exception.CustomException;
import sopt.org.NaverPay.global.exception.ErrorType;

@Slf4j
@RestControllerAdvice
@Component
@RequiredArgsConstructor
public class ControllerExceptionAdvice {

    /**
     * 400 Bad Request
     */
    // 잘못된 타입으로 요청을 보낸 경우
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ApiResponse<Exception> handlerMethodArgumentTypeMismatchException(final MethodArgumentTypeMismatchException e) {
        return ApiResponse.error(ErrorType.VALIDATION_WRONG_TYPE_EXCEPTION);
    }

    // Header에 원하는 Key가 없는 경우
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingRequestHeaderException.class)
    protected ApiResponse<Object> handlerMissingRequestHeaderException(final MissingRequestHeaderException e) {
        return ApiResponse.error(ErrorType.HEADER_REQUEST_MISSING_EXCEPTION);
    }

    // 잘못된 HTTP Method로 요청을 보낸 경우
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ApiResponse<Object> handlerHttpRequestMethodNotSupportedException(final HttpRequestMethodNotSupportedException e) {
        return ApiResponse.error(ErrorType.INVALID_HTTP_METHOD);
    }

    /**
     * 500 Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(IndexOutOfBoundsException.class)
    protected ApiResponse<Exception> handlerIndexOutOfBoundsException(final IndexOutOfBoundsException e) {
        return ApiResponse.error(ErrorType.INDEX_OUT_OF_BOUNDS, e);
    }

    /**
     * CUSTOM_ERROR
     */
    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<ApiResponse> handleCustomException(CustomException e) {

        log.error("CustomException occured: {}", e.getMessage(), e);

        return ResponseEntity.status(e.getHttpStatus())
                .body(ApiResponse.error(e.getErrorType(), e.getMessage()));
    }
}
