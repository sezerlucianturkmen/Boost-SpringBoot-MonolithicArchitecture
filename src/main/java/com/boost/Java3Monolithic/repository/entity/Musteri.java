package com.boost.Java3Monolithic.repository.entity;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Table(name = "tblmusteri")
@Entity
@AllArgsConstructor // parametreli constructor
@NoArgsConstructor // default constructor
@Data // getter setter
@SuperBuilder // builder pattern
public class Musteri extends Default {
    /**
     * Tüm property lerin getter ve setter ları eklenmeli.
     * Parametreli ve Parametresiz constructor.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ad;
    String soyad;
    String adres;
    String telefon;
    int dogumtarihi;
    String email;
    String username;
    String psw;
    String il;
    String ilce;
    String mahalle;
    String sokak;
    String postakodu;
    String cinsiyet;
    String tcno;
    String dogumyeri;
    String medenihali;
    String meslek;
    String uyruk;
    boolean bildirimlerikapat;
    boolean aramalardagorunmesin;
    boolean hesaponaylandi;
    /**
     * 50 adet daha parametre olsun.
     */



}