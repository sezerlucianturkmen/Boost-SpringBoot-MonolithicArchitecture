package com.boost.Java3Monolithic.service;

import com.boost.Java3Monolithic.repository.IMusteriRepository;
import com.boost.Java3Monolithic.repository.entity.Musteri;
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
