package com.boost.Java3Monolithic.service;

import com.boost.Java3Monolithic.repository.IUrunRepository;
import com.boost.Java3Monolithic.repository.entity.Urun;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UrunService {

    private final IUrunRepository urunRepository;

    public Urun save (Urun urun){
    return  urunRepository.save(urun);
    }
    public Urun update (Urun urun){
        return  urunRepository.save(urun);
    }
    public void delete (Urun urun){
        urunRepository.delete(urun);
    }
    public List<Urun> findAll(){
        return urunRepository.findAll();
    }




}
