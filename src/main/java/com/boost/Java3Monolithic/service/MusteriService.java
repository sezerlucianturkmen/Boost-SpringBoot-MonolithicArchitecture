package com.boost.Java3Monolithic.service;

import com.boost.Java3Monolithic.dto.response.MusteriFindByIdResponseDto;
import com.boost.Java3Monolithic.mapper.MusteriMapper;
import com.boost.Java3Monolithic.repository.IMusteriRepository;
import com.boost.Java3Monolithic.repository.entity.Musteri;
import com.boost.Java3Monolithic.repository.entity.view.VwMusteri;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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


    public Boolean isExistUser(String username,String password){
        return musteriRepository.isExistMusteri(username,password);
    }


    /**
     * Dİkkat, müşterityi kaydetmek içni veridğiniz de id si yoktur.
     * @param musteri
     * @return
     */
    public Musteri save(Musteri musteri){
        musteri.setCreatedate(System.currentTimeMillis());
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

    public List<Musteri> findByAdres(String adres){
        return musteriRepository.findByAdres(adres);
    }

    public Iterable<Musteri> saveAll(List<Musteri> musteriler){
        musteriler.forEach(musteri -> {
            musteri.setCreatedate(System.currentTimeMillis());
        });
        return musteriRepository.saveAll(musteriler);
    }



    public MusteriFindByIdResponseDto findByIdDto(Long id){
        Musteri musteri = musteriRepository.getReferenceById(id);
        return  MusteriMapper.INSTANCE.toMusteriFindByIdResponseDto(musteri);
        /*
        return MusteriFindByIdResponseDto.builder()
                .ad(musteri.getAd())
                .il(musteri.getIl())
                .dogumtarihi(musteri.getDogumtarihi())
                .aramalardagorunmesin(musteri.isAramalardagorunmesin())
                .email(musteri.getEposta())
                .bildirimlerikapat(musteri.isBildirimlerikapat())
                .ilce(musteri.getIlce())
                .mahalle(musteri.getMahalle())
                .sokak(musteri.getSokak())
                .soyad(musteri.getSoyad())
                .telefon(musteri.getTelefon())
                .medenihali(musteri.getMedenihali())
                .meslek(musteri.getMeslek())
                .build();
                */

    }

}