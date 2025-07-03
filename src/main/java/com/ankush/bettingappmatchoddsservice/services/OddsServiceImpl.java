package com.ankush.bettingappmatchoddsservice.services;

import com.ankush.bettingappentityservice.models.Match;
import com.ankush.bettingappentityservice.models.Odds;
import com.ankush.bettingappmatchoddsservice.dtos.OddsRequestDTO;
import com.ankush.bettingappmatchoddsservice.dtos.OddsResponseDTO;
import com.ankush.bettingappmatchoddsservice.repositories.MatchRepository;
import com.ankush.bettingappmatchoddsservice.repositories.OddsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OddsServiceImpl implements OddsService {

    @Autowired
    private OddsRepository oddsRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private OddsMapper oddsMapper;

    @Override
    public OddsResponseDTO createOdds(OddsRequestDTO dto) {
        Match match = matchRepository.findById(dto.getMatchId())
                .orElseThrow(() -> new RuntimeException("Match not found"));

        Odds odds = oddsMapper.toEntity(dto);
        odds.setMatch(match);

        return oddsMapper.toDto(oddsRepository.save(odds));
    }

    @Override
    public OddsResponseDTO getOdds(Long id) {
        return oddsRepository.findById(id)
                .map(oddsMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Odds not found"));
    }

    @Override
    public OddsResponseDTO updateOdds(Long id, OddsRequestDTO dto) {
        Odds odds = oddsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Odds not found"));

        oddsMapper.updateOddsFromDto(dto, odds);

        Match match = matchRepository.findById(dto.getMatchId())
                .orElseThrow(() -> new RuntimeException("Match not found"));
        odds.setMatch(match);

        return oddsMapper.toDto(oddsRepository.save(odds));
    }

    @Override
    public void deleteOdds(Long id) {
        oddsRepository.deleteById(id);
    }

    @Override
    public List<OddsResponseDTO> getOddsByMatch(Long matchId) {
        return oddsRepository.findByMatchId(matchId).stream()
                .map(oddsMapper::toDto)
                .collect(Collectors.toList());
    }
}
