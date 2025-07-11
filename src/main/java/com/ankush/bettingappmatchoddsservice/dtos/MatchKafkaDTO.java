package com.ankush.bettingappmatchoddsservice.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchKafkaDTO {
    private Long matchId;
    private String homeTeam;
    private String awayTeam;
    private String startTime; // ISO String
}
