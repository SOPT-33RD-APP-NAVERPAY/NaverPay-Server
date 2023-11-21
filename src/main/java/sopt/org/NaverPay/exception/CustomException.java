package sopt.org.NaverPay.exception;

import lombok.Getter;

import javax.lang.model.type.ErrorType;

public class CustomException extends RuntimeException{
    private final ErrorType errorType;

    public CustomException(ErrorType errorType) {
       // super(errorType.getMessage());
        this.errorType = errorType;
    }
}