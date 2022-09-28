package com.boost.Java3Monolithic.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {
    INTERNAL_ERROR(2000, "Internal Server Error", INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(2001, "Invalid Parameter Error", BAD_REQUEST),
    MUSTERI_BULUNAMADI(1003,"Aradığınız müşteri kayıtlarda bulunamdı", INTERNAL_SERVER_ERROR),
    MUSTERI_SILINEMEDI(1004,"Müşteri silinemedi", INTERNAL_SERVER_ERROR),
    SATIS_EKLEME_SORUNU(2005,"Satış Eklenirken zorunlu alanların boş olduğu görüldü.", INTERNAL_SERVER_ERROR);


    private int code;
    private String message;
    HttpStatus httpStatus;
}
