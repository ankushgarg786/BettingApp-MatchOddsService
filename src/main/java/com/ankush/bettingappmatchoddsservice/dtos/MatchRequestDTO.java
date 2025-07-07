package com.ankush.bettingappmatchoddsservice.dtos;

import com.ankush.bettingappentityservice.models.Match;
import com.ankush.bettingappentityservice.models.MatchStatus;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchRequestDTO {
    private String homeTeam;
    private String awayTeam;
    private LocalDateTime startTime;
    private String scoreSummary;
    private MatchStatus status;

}
