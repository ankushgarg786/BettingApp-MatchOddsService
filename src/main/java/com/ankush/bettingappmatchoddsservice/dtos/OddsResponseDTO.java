package com.ankush.bettingappmatchoddsservice.dtos;

import com.ankush.bettingappentityservice.models.MarketType;
import lombok.Data;

@Data
public class OddsResponseDTO {
    private Long id;
    private Long matchId;
    private MarketType marketType;
    private String selection;
    private Double oddsValue;
    private Boolean isActive;
}
