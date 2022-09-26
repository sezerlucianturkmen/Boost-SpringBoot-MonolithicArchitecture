package com.boost.Java3Monolithic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex){
        return ResponseEntity.badRequest().body("Something went wrong...: "+ex.getMessage());
    }
    @ExceptionHandler(MonolithicManagerException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleMonolithicException(MonolithicManagerException ex){
        ErrorType errorType=ex.getErrorType();
        HttpStatus httpStatus=errorType.getHttpStatus();
        return new ResponseEntity<>(createError(errorType, ex), httpStatus);
    }
    private ErrorMessage createError(ErrorType errorType, Exception exception) {
        System.out.println("Hata oluştu: " + exception.getMessage());
        return ErrorMessage.builder()
                .code(errorType.getCode())
                .message(errorType.getMessage())
                .build();
    }

    /**
     * Error Mesajlarınızı özel bir metod için de create edin. Cunku olusan hataların
     * loglanması ya da farklı islemlere tabi tututlmasi icin ayrica bir metod kullanmak daha dogru olacaktır.
     */
}
