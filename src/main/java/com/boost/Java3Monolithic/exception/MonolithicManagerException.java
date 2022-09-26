package com.boost.Java3Monolithic.exception;

import lombok.Getter;

@Getter
public class MonolithicManagerException extends RuntimeException{
    private final ErrorType errorType;
    public MonolithicManagerException(ErrorType errorType){
        super(errorType.getMessage()); // Runtime bir mesaj ister ona mesajı Super üzerinden erişim sağlanır
        this.errorType=errorType;
    }

    public MonolithicManagerException(ErrorType errorType,String message){
        super(message);
        this.errorType=errorType;
    }

}
