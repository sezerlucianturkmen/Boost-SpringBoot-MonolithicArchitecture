package com.boost.Java3Monolithic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.boost.Java3Monolithic.constant.EndPoints.*;
/**
 * RestAPI yazmak için kullanıyoruz.
 */
@RestController
/**
 * URL: http://localhost:9090/satis
 */
@RequestMapping(VERSION+API+SATIS)
public class SatisController {
    /**
     * http://localhost:9090/satis/save
     * @return
     */
    @GetMapping(SAVE)
    public String save(){
        return "Kayıt Başarılı";
    }

    /**
     * http://localhost:9090/satis/update
     * @return
     */
    @GetMapping(UPDATE)
    public String update(){
        return "Güncelleme Başarılı";
    }
}
