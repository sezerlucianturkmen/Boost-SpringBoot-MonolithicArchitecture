package com.boost.Java3Monolithic.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
<<<<<<< HEAD
=======
import lombok.experimental.SuperBuilder;
>>>>>>> 63f0fc8 (Lesson & Learn)

import javax.persistence.*;

@Table(name="tblmusteri")
@Entity
@AllArgsConstructor//parametreli tüm contructorları yapar
@NoArgsConstructor//parametresiz const
<<<<<<< HEAD
@Data // getter setter
@Builder // builder pattern
public class Musteri {
=======
@SuperBuilder// builder pattern
@Data // getter setter

public class Musteri extends Default {
>>>>>>> 63f0fc8 (Lesson & Learn)
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
<<<<<<< HEAD
    boolean isactive;
=======

>>>>>>> 63f0fc8 (Lesson & Learn)
}
