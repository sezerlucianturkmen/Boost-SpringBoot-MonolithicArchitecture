package com.boost.Java3Monolithic.service;

import com.boost.Java3Monolithic.repository.ISatisRepository;
import com.boost.Java3Monolithic.repository.IUrunRepository;
import com.boost.Java3Monolithic.repository.entity.Urun;
import com.boost.Java3Monolithic.utility.ServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrunService extends ServiceManager<Urun,Long> {
    private final IUrunRepository urunRepository;
    public UrunService(IUrunRepository urunRepository) {
        super(urunRepository);
        this.urunRepository=urunRepository;
    }

}
