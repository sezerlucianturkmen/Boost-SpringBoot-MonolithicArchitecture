package com.boost.Java3Monolithic.mapper;


import com.boost.Java3Monolithic.dto.response.MusteriFindByIdResponseDto;
import com.boost.Java3Monolithic.repository.entity.Musteri;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * Mapper ın spring tarafında kullanılan yönetimi için component Model olarak spring yazılmalı
 * En nihyaetinde iki sınıfı karşılaştırarak değer ataması yapıyor. bu nedenle karşılıklı
 * sınıflarda olmayan alanlar sorun yaratacakır. eşleşmeyen alanları es geçiyoruz.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MusteriMapper {
    /**
     * Mapstruct instance ı nı kendisi yaratır.
     */
    MusteriMapper INSTANCE = Mappers.getMapper(MusteriMapper.class);

    /**
     * Buradan itibaren ilgili nesnelerin değerleri bir birine atanır.
     */
    MusteriFindByIdResponseDto toMusteriFindByIdResponseDto(final Musteri musteri);
    Musteri toMusteri(final MusteriFindByIdResponseDto dto);
}