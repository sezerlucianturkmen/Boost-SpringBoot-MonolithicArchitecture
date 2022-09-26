package com.boost.Java3Monolithic.repository;

import com.boost.Java3Monolithic.repository.entity.Musteri;
import com.boost.Java3Monolithic.repository.entity.view.VwMusteri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * !!! DİKKAT !!!
 * Bu interface bir repository sınıfıdır. Bu nedenle Spring sınıfların analiz ederken
 * üzerinde bulunan annotaiton lara bakarak onların instance larını oluşturur.
 * Buraya mutlaka @Repository annotaiton ını eklemeyi unutmayın.
 */
@Repository
public interface IMusteriRepository extends JpaRepository<Musteri,Long> {

  /**
   * !! DİKKAT !!
   * Repository sınıfları içinde sorgu yazmak için özel kelimeleri kullanıyorsunuz.
   * 1- find : kelimesi yazılır
   * 2- By :  ne için arayacağınızı belirtir. kullanacağınız entity propertisinin adını yazarsınız.
   * 3- [entity->değişkenadı] : entity değişken adını yazarsınız.
   * 4- method eğer parametre alıyor ise yazılan metne uygun bir
   * değişken talep edilir. talep edilen değişkenin adı önemli
   * değildir.
   * 5- son olarakta methodun geri dönüş tipini belirtirsiniz.
   */
  // select * from tblmusteri where username = ?
  Musteri findByUsername(String merhababenbir_degiskenim);

  // select * from tblmusteri where adres = ?
  List<Musteri> findByAdres(String adres);

  /**
   * Doğum tarihi belibir tarihten büyük olanları getir.
   * GreaterThan
   * LessThan
   * select * from tblmusteri where dogumtarihi > ?
   */
  List<Musteri> findByDogumtarihiGreaterThan(int dogumtarihi);

  /**
   * Adında belli bir karakter aranılan kişileri getir.
   * select * from tblmusteri where ad like '%?%'
   */
  // değişken adını bilerek farklı yazdım. buraya aranılan değişkenini adını
  // yazma mecburiyeti yok.
  List<Musteri> findAllByAdLike(String _Selamlar_ad_DeGisKeniniYazDim);

  /**
   * ad ve adresi a ile başlayanlar
   * select * from tblmusteri where ad like 'a%' and adres like 'a%'
   */
  List<Musteri> findAllByAdStartingWith(String ad);

  /**
   * and ile birleştirdiğiniz sorgularda sıralama önemlidir.
   */
  List<Musteri> findAllByAdStartingWithAndAdresStartingWith(String ad, String adres);

  Musteri findByAdAndSoyadAndTelefon(String musteriadi, String soyad, String telefon);

  /**
   * sorgularınız size her zaman sonuç dönmez bu nedenle null gelen sonuçlarda alabilirsiniz.
   */
  Optional<Musteri> findOptionalByUsername(String username);

  Optional<List<Musteri>> findAllOptionalByAdres(String adres);

  /**
   * ASC -> A...Z
   * DESC -> Z..A
   *
   * @return
   */
  List<Musteri> findByOrderByDogumtarihi();

  List<Musteri> findByOrderByDogumtarihiDesc();

  Musteri findTopByOrderByDogumtarihiDesc(); // sadece 1 kayıt getirir.

  /**
   * ÖNEMLİ !!!!!
   * Eğer sorgunuz birden fazla kayıt dönüyorsa tekli sonuz yazmayın.
   * CompilerTime da sorun olmaz ama kullanırken hata alırsınız.
   *
   * @return
   */
  List<Musteri> findTop3ByOrderByDogumtarihiDesc(); // ilk 3 ü getirir.

  Optional<List<Musteri>> findTop3OptionalByOrderByDogumtarihiDesc(); // ilk 3 ü getirir. Optional olarak döner.

  /**
   * select * from tblmusteri where dogumtarihi > ? and dogumtarihi < ?
   */
  List<Musteri> findAllByDogumtarihiBetween(int baslangic, int bitis);

  List<Musteri> findAllByAdresAndDogumtarihiBetween(String adres, int baslangic, int bitis);

  /**
   * 1- aktif olan müşterileri getir.
   */
  //  List<Musteri> findAllByIsactive(boolean isactive);// true, false
  //  List<Musteri> findAllByIsactiveTrue();// aktif kayıtlar
  //   List<Musteri> findAllByIsactiveFalse();// pasif kayıtlar
  /**
   * 2- id sini verdiğim müşteriyi bul
   */
  // Optional<Musteri> findById(Long id);

  /**
   * 3- ad ve soyadına göre ara ad ve soyad büyük küçük harf duyarlı olmasın
   */
  Optional<List<Musteri>> findAllOptionalByAdAndSoyad(String ad, String soyad);

  Optional<List<Musteri>> findAllOptionalByAdIgnoreCaseAndSoyadIgnoreCase(String ad, String soyad);

  /**
   * cep telefonu 555 ile başlayanları getir.
   * %555 ->
   */
  Optional<List<Musteri>> findAllOptionalByTelefonLike(String telefon);

  /**
   * 555XXXXXXX
   */
  Optional<List<Musteri>> findAllOptionalByTelefonStartingWith(String telefon);

  /**
   * XXX555XXXX
   */
  Optional<List<Musteri>> findAllOptionalByTelefonContaining(String telefon);

  /**
   * mail adresi gmail olan ankaralı ların listesi
   */
  Optional<List<Musteri>> findAllOptionalByEmailContainingAndAdres(String email, String adres);

  /**
   * Kelime bazlı soruların yetersiz kaldığı durumlarda, JPQL yada HQL yada NATIVESQL yazabilrisiniz.
   * JPQL
   */
  @Query("select m from Musteri m where m.email= ?1")
  Musteri senBulEmailAdresineGore(String email);

  @Query("select mst from Musteri mst where mst.ad= ?1 and mst.soyad= ?2")
  Musteri bulAdSoyad(String ad, String soyad);

  /**
   * Native SQL kullanımı
   * NOT: Table adı içni kontrol sağlayalım.
   */
  @Query(value = "select * from Musteri where email= ?1", nativeQuery = true)
  List<Musteri> getirEmailAdresineGore(String email);

  /**
   * Parametreyi belirterek sorgu yapmak
   * findByNameAndEmail("muhammet","muhammet@gmail.com")
   * select * from tblmusteri where email='muhammet@gmail.com' and ad='muhammet'
   */
  @Query("select m from Musteri m where m.email= :paramemail and m.ad= :paramad")
  Musteri findByNameAndEmail(
          @Param("paramad") String musteriAdi,
          @Param("paramemail") String musteriEmaili
  );
}

