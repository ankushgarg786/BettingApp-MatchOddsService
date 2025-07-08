package com.ankush.bettingappmatchoddsservice.services;

import com.ankush.bettingappentityservice.models.Match;
import com.ankush.bettingappentityservice.models.MatchStatus;
import com.ankush.bettingappmatchoddsservice.dtos.MatchRequestDTO;
import com.ankush.bettingappmatchoddsservice.dtos.MatchResponseDTO;
import com.ankush.bettingappmatchoddsservice.events.MatchCreatedEvent;
import com.ankush.bettingappmatchoddsservice.events.ScoreUpdateEvent;
import com.ankush.bettingappmatchoddsservice.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private MatchMapper matchMapper;
    @Autowired
    private MatchEventProducer matchEventProducer;

    @Override
    public MatchResponseDTO createMatch(MatchRequestDTO dto) {
        dto.setAwayTeam("Mumbai Indians");
        Match match = matchMapper.toEntity(dto);
        Match savedMatch=matchRepository.save(match);

        MatchCreatedEvent event = MatchCreatedEvent.builder()
                .id(savedMatch.getId())
                .homeTeam(savedMatch.getHomeTeam())
                .awayTeam(savedMatch.getAwayTeam())
                .startTime(savedMatch.getStartTime())
                .status(savedMatch.getStatus())
                .build();
        matchEventProducer.sendMatchCreatedEvent(event);

        return matchMapper.toDto(savedMatch);
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
    @Override
    public MatchResponseDTO updateMatchScore(Long matchId, String newScore, MatchStatus newStatus) {
        Match match = matchRepository.findById(matchId)
                .orElseThrow(() -> new RuntimeException("Match not found"));

        match.setScoreSummary(newScore);
        match.setStatus(newStatus);
        match.setUpdatedAt(LocalDateTime.now());

        matchRepository.save(match);

        // 🔥 Publish Score Update Event
        ScoreUpdateEvent event = ScoreUpdateEvent.builder()
                .matchId(match.getId())
                .scoreSummary(match.getScoreSummary())
                .status(match.getStatus())
                .updatedAt(match.getUpdatedAt())
                .build();

        matchEventProducer.sendScoreUpdateEvent(event);

        return matchMapper.toDto(match);
    }
}
