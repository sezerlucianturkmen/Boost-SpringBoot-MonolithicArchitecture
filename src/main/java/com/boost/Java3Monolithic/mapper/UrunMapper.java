package com.boost.Java3Monolithic.mapper;


import com.boost.Java3Monolithic.dto.request.UrunSaveRequestDto;
import com.boost.Java3Monolithic.dto.response.UrunGetFindByIdResponseDto;
import com.boost.Java3Monolithic.repository.entity.Urun;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UrunMapper {
    UrunMapper INSTANCE = Mappers.getMapper(UrunMapper.class);

    UrunGetFindByIdResponseDto toUrunGetFindByIdResponseDto(final Urun urun);

    Urun toUrun(final UrunSaveRequestDto dto);
}