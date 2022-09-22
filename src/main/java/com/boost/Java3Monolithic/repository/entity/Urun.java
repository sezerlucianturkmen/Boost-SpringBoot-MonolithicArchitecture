package com.boost.Java3Monolithic.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name="tblurun")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Urun {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String ad;
    String marka;
    String model;
    Double fiyat;
    Integer stok;
    boolean isactive;


}
