package com.boost.Java3Monolithic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/satis")
public class SatisController {

    @GetMapping("/save")
    public String save(){
        return "Satis kayit edildi";
    }
    @GetMapping("/findall")
    public String findAll(){
        return "Satislar listelendi";
    }


}
