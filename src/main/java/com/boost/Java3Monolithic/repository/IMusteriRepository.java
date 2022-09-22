package com.boost.Java3Monolithic.repository;

import com.boost.Java3Monolithic.repository.entity.Musteri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IMusteriRepository extends JpaRepository<Musteri,Long> {
    //select * from tblmusteri where username=?
  Musteri findByUsername(String username);
    //select * from tblmusteri where adres=?
  List<Musteri> findByAdres(String adres);

  List<Musteri> findBydogumtarihiGreaterThan(int dogumtarihi);

  List<Musteri> findAllByAdLike(String ad);

  List<Musteri> findAllByAdStartsWith(String ad);
  List<Musteri> findAllByAdStartsWithAndAdresStartsWith(String ad,String adres);


  Optional<Musteri> findOptionalByUsername(String username);
  Optional<List<Musteri>> findAllOptionalByAdres(String adres);

  Musteri findByDogumtarihiOrderBy();
  Musteri findByDogumtarihiOrderByDesc();
  Musteri findTopByDogumtarihiOrderByDesc(); // 1 kayit gelir
  List<Musteri> findTop3ByDogumtarihiOrderByDesc(); // ilk 3 kayi gelir
  Optional<List<Musteri>>  findTop3OptionalByDogumtarihiOrderByDesc(); // optional olursa

  List<Musteri> findAllByDogumtarihiBetween(int start,int end);
  List<Musteri> findAllByAdresAndDogumtarihiBetween(String adres,int start,int end);

  //JPQL
  @Query("select m from Musteri m where m.email= ?1")
  Musteri senbulEmailAdresineGore(String email);
  @Query("select m from Musteri m where m.ad= ?1 and m.soyad= ?2")
  Musteri bulAdSoyad(String ad,String soyad);

  //Native SQL
  @Query(value = "select * from Musteri where email= ?1",nativeQuery = true)
  List<Musteri> getirEmailAdresinegore(String email);

  //Parametre ile sorgu oluşturma
  @Query("select m from Musteri m where m.email= :emailPR and m.ad= :adPR")
  Musteri findByNameAndEmail(@Param("adPR") String musteriadi, @Param("emailPR") String musteriEmail);



}
