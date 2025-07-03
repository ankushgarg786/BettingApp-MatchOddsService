package com.ankush.bettingappmatchoddsservice.services;

import com.ankush.bettingappentityservice.models.Odds;
import com.ankush.bettingappmatchoddsservice.dtos.OddsRequestDTO;
import com.ankush.bettingappmatchoddsservice.dtos.OddsResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OddsMapper {
    Odds toEntity(OddsRequestDTO dto);
    OddsResponseDTO toDto(Odds odds);
    void updateOddsFromDto(OddsRequestDTO dto, @MappingTarget Odds odds);
}
