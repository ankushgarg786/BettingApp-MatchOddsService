package com.ankush.bettingappmatchoddsservice.dtos;

import com.ankush.bettingappentityservice.models.MatchStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MatchResponseDTO {
    private Long id;
    private String homeTeam;
    private String awayTeam;
    private LocalDateTime startTime;
    private String scoreSummary;
    private MatchStatus status;

}
