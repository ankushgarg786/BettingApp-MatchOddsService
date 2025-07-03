package com.ankush.bettingappmatchoddsservice.services;

import com.ankush.bettingappentityservice.models.Match;
import com.ankush.bettingappmatchoddsservice.dtos.MatchRequestDTO;
import com.ankush.bettingappmatchoddsservice.dtos.MatchResponseDTO;
import com.ankush.bettingappmatchoddsservice.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private MatchMapper matchMapper;

    @Override
    public MatchResponseDTO createMatch(MatchRequestDTO dto) {
        Match match = matchMapper.toEntity(dto);
        return matchMapper.toDto(matchRepository.save(match));
    }

    @Override
    public MatchResponseDTO getMatch(Long id) {
        Match match = matchRepository.findById(id).orElseThrow(() -> new RuntimeException("Match not found"));
        return matchMapper.toDto(match);
    }

    @Override
    public MatchResponseDTO updateMatch(Long id, MatchRequestDTO dto) {
        Match match = matchRepository.findById(id).orElseThrow(() -> new RuntimeException("Match not found"));
        match.setHomeTeam(dto.getHomeTeam());
        match.setAwayTeam(dto.getAwayTeam());
        match.setStartTime(dto.getStartTime());
        match.setScoreSummary(dto.getScoreSummary());
        match.setStatus(dto.getStatus());
        return matchMapper.toDto(matchRepository.save(match));
    }

    @Override
    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }

    @Override
    public List<MatchResponseDTO> listMatches() {
        return matchRepository.findAll().stream()
                .map(matchMapper::toDto)
                .collect(Collectors.toList());
    }
}
