package com.boost.Java3Monolithic.service;

import com.boost.Java3Monolithic.repository.IMusteriRepository;
import com.boost.Java3Monolithic.repository.entity.Musteri;

import com.boost.Java3Monolithic.repository.entity.view.VwMusteri;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MusteriService {
    //@Autowired //interface olan repositoryden bir instance alamaızı sağlar
    //IMusteriRepository musteriRepository;

    //public MusteriService(IMusteriRepository musteriRepository){
    //this.musteriRepository=musteriRepository

    private final IMusteriRepository musteriRepository;

    public Musteri save (Musteri musteri){
    return  musteriRepository.save(musteri);
    }
    public Musteri update (Musteri musteri){
        return  musteriRepository.save(musteri);
    }
    public void delete (Musteri musteri){

/**
 * !! DİKKAT !!
 * Servisi işaretlemeyi unutmaytın.
 */
@Service
@RequiredArgsConstructor
public class MusteriService {
    /**
     * interface olarakn ektediğiniz Service ya da Repository gibi sınlarından
     * instance almak için Spring @Autowired annotaiton ını kullanabilirsiniz.
     */
    //@Autowired
    //IMusteriRepository musteriRepository;
//    public MusteriService(IMusteriRepository musteriRepository) {
//        this.musteriRepository = musteriRepository;
//    }

    private final IMusteriRepository musteriRepository;


    /**
     * Dİkkat, müşterityi kaydetmek içni veridğiniz de id si yoktur.
     * @param musteri
     * @return
     */
    public Musteri save(Musteri musteri){
        return musteriRepository.save(musteri);
    }

    /**
     * id yi de entity içinde vermelisisiz.
     * @param musteri
     * @return
     */
    public Musteri update(Musteri musteri){
        return musteriRepository.save(musteri);
    }
    public void delete(Musteri musteri){

        musteriRepository.delete(musteri);
    }
    public List<Musteri> findAll(){
        return musteriRepository.findAll();
    }


    //queries
    public List<Musteri> findByAdres(String adres){
        return musteriRepository.findByAdres(adres);
     }


}

    public List<Musteri> findByAdres(String adres){
        return musteriRepository.findByAdres(adres);
    }

    public Iterable<Musteri> saveAll(List<Musteri> musteriler){
        musteriler.forEach(musteri -> {
            musteri.setCreatedate(System.currentTimeMillis());
        });
        return musteriRepository.saveAll(musteriler);
    }

    public List<VwMusteri> getMusteriView(){
        return musteriRepository.findAllView();
    }
}

