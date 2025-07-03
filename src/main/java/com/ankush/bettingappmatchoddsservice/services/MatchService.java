package com.ankush.bettingappmatchoddsservice.services;

import com.ankush.bettingappmatchoddsservice.dtos.MatchRequestDTO;
import com.ankush.bettingappmatchoddsservice.dtos.MatchResponseDTO;

import java.util.List;

public interface MatchService {
    MatchResponseDTO createMatch(MatchRequestDTO dto);
    MatchResponseDTO getMatch(Long id);
    MatchResponseDTO updateMatch(Long id, MatchRequestDTO dto);
    void deleteMatch(Long id);
    List<MatchResponseDTO> listMatches();
}
