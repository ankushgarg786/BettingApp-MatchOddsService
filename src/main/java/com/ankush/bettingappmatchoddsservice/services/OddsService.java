package com.ankush.bettingappmatchoddsservice.services;

import com.ankush.bettingappmatchoddsservice.dtos.OddsRequestDTO;
import com.ankush.bettingappmatchoddsservice.dtos.OddsResponseDTO;

import java.util.List;

public interface OddsService {
    OddsResponseDTO createOdds(OddsRequestDTO dto);
    OddsResponseDTO getOdds(Long id);
    OddsResponseDTO updateOdds(Long id, OddsRequestDTO dto);
    void deleteOdds(Long id);
    List<OddsResponseDTO> getOddsByMatch(Long matchId);
}
