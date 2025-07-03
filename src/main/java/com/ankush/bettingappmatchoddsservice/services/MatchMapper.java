package com.ankush.bettingappmatchoddsservice.services;

import com.ankush.bettingappentityservice.models.Match;
import com.ankush.bettingappmatchoddsservice.dtos.MatchRequestDTO;
import com.ankush.bettingappmatchoddsservice.dtos.MatchResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MatchMapper {

    Match toEntity(MatchRequestDTO dto);

    MatchResponseDTO toDto(Match match);

}
