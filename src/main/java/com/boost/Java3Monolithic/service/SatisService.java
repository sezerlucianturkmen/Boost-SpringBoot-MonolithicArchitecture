package com.boost.Java3Monolithic.service;

import com.boost.Java3Monolithic.repository.ISatisRepository;
import com.boost.Java3Monolithic.repository.entity.Satis;
import com.boost.Java3Monolithic.utility.ServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SatisService extends ServiceManager<Satis,Long> {
    private final ISatisRepository satisRepository;
    public SatisService(ISatisRepository satisRepository) {
        super(satisRepository);
        this.satisRepository=satisRepository;
    }

}
