package com.boost.Java3Monolithic.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "Hello World";
    }

    @PostMapping("/urunler")
    public String urunler() {
        return "Ürün Sayfası";
    }

}