package com.boost.Java3Monolithic.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name="tblmusteri")
@Entity
@AllArgsConstructor//parametreli tüm contructorları yapar
@NoArgsConstructor//parametresiz const
@Data // getter setter
@Builder // builder pattern
public class Musteri {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String ad;
    String soyad;
    String adres;
    String telefon;
    int dogumtarihi;
    String email;
    String username;
    boolean isactive;
}
