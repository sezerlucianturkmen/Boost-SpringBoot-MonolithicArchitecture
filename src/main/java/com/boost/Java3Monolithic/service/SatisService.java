package com.boost.Java3Monolithic.service;

import com.boost.Java3Monolithic.repository.ISatisRepository;
import com.boost.Java3Monolithic.repository.entity.Satis;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SatisService {
   
    private final ISatisRepository satisRepository;

    public Satis save (Satis satis){
    return  satisRepository.save(satis);
    }
    public Satis update (Satis satis){
        return  satisRepository.save(satis);
    }
    public void delete (Satis satis){
        satisRepository.delete(satis);
    }
    public List<Satis> findAll(){
        return satisRepository.findAll();
    }


}
