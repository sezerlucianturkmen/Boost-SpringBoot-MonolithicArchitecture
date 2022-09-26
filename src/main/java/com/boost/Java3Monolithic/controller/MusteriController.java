package com.boost.Java3Monolithic.controller;

import com.boost.Java3Monolithic.dto.response.MusteriFindByIdResponseDto;
import com.boost.Java3Monolithic.repository.entity.Musteri;
import com.boost.Java3Monolithic.repository.entity.view.VwMusteri;
import com.boost.Java3Monolithic.service.MusteriService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.boost.Java3Monolithic.constant.EndPoints.*;
import java.util.List;

@RestController
@RequestMapping(VERSION+API+MUSTERI)
@RequiredArgsConstructor
public class MusteriController {
    private final MusteriService musteriService;

    /**
     * localhost:9090/musteri/save
     */
    @GetMapping(SAVE)
    public String saveMusteri(String ad,String soyad, String adres){
        Musteri musteri = Musteri.builder()
                .ad(ad)
                .soyad(soyad)
                .adres(adres)
                .build();
        musteriService.save(musteri);
        return "Müşteri kaydedildi.";
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<Musteri>> findAll(){
        return ResponseEntity.ok(musteriService.findAll());
    }

    @GetMapping("/findallview")
    public ResponseEntity<List<VwMusteri>> findAllView(){
        return ResponseEntity.ok(musteriService.getMusteriView());
    }


    /**
     * localhost:9090/musteri/findbyadres?adres=İstanbul
     * @param adres
     * @return
     */
    @GetMapping("/findbyadres")
    public ResponseEntity<List<Musteri>> findByAdres(String adres){
        return ResponseEntity.ok(musteriService.findByAdres(adres));
    }

    @GetMapping(FINDBYID)
    public MusteriFindByIdResponseDto findByIdDto(Long id){
        /**
         * Müşteri ile ilgili 20 kalem bilginin dönmesi gerekli.
         */
        return musteriService.findByIdDto(id);
    }

}