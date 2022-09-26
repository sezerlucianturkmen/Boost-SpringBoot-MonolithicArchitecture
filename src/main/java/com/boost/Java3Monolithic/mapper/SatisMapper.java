package com.boost.Java3Monolithic.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * mapper in spring tarafından kullanılan yöndetimi için componant model =spring olmalı
 * iki alan da ortak olmayan elmanların atanması sırasında sorun cıkar bunu ignore etmesi içinde
 *
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SatisMapper {
    /**
     * Mapstruct instance ını kendisi yönetir
     */

    SatisMapper INSTANCE= Mappers.getMapper(SatisMapper.class);

}
