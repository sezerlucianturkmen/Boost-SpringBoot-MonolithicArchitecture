package com.boost.Java3Monolithic.utility;


import com.boost.Java3Monolithic.repository.entity.Musteri;
import com.boost.Java3Monolithic.repository.entity.Urun;
import com.boost.Java3Monolithic.service.MusteriService;
import com.boost.Java3Monolithic.service.UrunService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

/**
 * Uyglama ayağa kalarken veritabanına default verileri eklemek için kullanılır.
 * ancak bu sınıfın otomatik çalışması gerekecek.
 */
@RequiredArgsConstructor
@Component
public class DefaultDataImpl {

    private final MusteriService musteriService;
    private final UrunService urunService;
    @PostConstruct
    private void create(){
        saveMusteri();
        saveUrun();
    }

    private void saveUrun(){
        Urun urun = Urun.builder()
                .ad("Şeker")
                .fiyat(120d)
                .isactive(true)
                .marka("A Marka")
                .model("B Model")
                .stok(500)
                .build();
        Urun urun2 = Urun.builder()
                .ad("Un")
                .fiyat(420d)
                .isactive(true)
                .marka("A Marka")
                .model("C Model")
                .stok(100)
                .build();
        Urun urun3 = Urun.builder()
                .ad("Süt")
                .fiyat(40d)
                .isactive(true)
                .marka("F Marka")
                .model("H Model")
                .stok(50)
                .build();
        Urun urun4 = Urun.builder()
                .ad("Makarna")
                .fiyat(20d)
                .isactive(true)
                .marka("C Marka")
                .model("S Model")
                .stok(125)
                .build();
        urunService.saveAll(Arrays.asList(urun, urun2,urun3,urun4));
    }

    private void saveMusteri(){

        Musteri musteri = Musteri.builder()
                .ad("Muhammet")
                .soyad("Kaya")
                .adres("İstanbul")
                .telefon("0532 123 45 67")
                .dogumtarihi(1990)
                .email("muhammed@gmail.com").build();
        Musteri musteri1 = Musteri.builder()
                .ad("Kenan")
                .soyad("KESKİN")
                .adres("İstanbul")
                .telefon("0532 785 45 67")
                .dogumtarihi(1980)
                .email("kanen@gmail.com").build();
        Musteri musteri2 = Musteri.builder()
                .ad("Bahar")
                .soyad("TAŞ")
                .adres("Ankara")
                .telefon("0532 785 87 67")
                .dogumtarihi(1984)
                .email("bahar@gmail.com").build();
        Musteri musteri3 = Musteri.builder()
                .ad("Mehmet")
                .soyad("KAYA")
                .adres("İzmir")
                .telefon("0532 785 45 67")
                .dogumtarihi(1988)
                .email("mehmet@gmail.com").build();
        Musteri musteri4 = Musteri.builder()
                .ad("Ayşe")
                .soyad("KAYA")
                .adres("Adana")
                .telefon("0532 785 45 98")
                .dogumtarihi(1991)
                .email("ayse@gmail.com").build();
        musteriService.saveAll(Arrays.asList(musteri,musteri1,musteri2,musteri3,musteri4));
    }

}

}

