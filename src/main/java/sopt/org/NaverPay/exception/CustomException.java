package sopt.org.NaverPay.exception;

import javax.lang.model.type.ErrorType;

public class CustomException extends RuntimeException{
    private final ErrorType errorType;

    public CustomException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }
}
