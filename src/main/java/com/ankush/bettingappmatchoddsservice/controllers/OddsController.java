package com.ankush.bettingappmatchoddsservice.controllers;

import com.ankush.bettingappmatchoddsservice.dtos.OddsRequestDTO;
import com.ankush.bettingappmatchoddsservice.dtos.OddsResponseDTO;
import com.ankush.bettingappmatchoddsservice.services.OddsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odds")
public class OddsController {

    @Autowired
    private OddsService oddsService;

    @PostMapping
    public OddsResponseDTO createOdds(@RequestBody OddsRequestDTO dto) {
        return oddsService.createOdds(dto);
    }

    @GetMapping("/{id}")
    public OddsResponseDTO getOdds(@PathVariable Long id) {
        return oddsService.getOdds(id);
    }

    @PutMapping("/{id}")
    public OddsResponseDTO updateOdds(@PathVariable Long id, @RequestBody OddsRequestDTO dto) {
        return oddsService.updateOdds(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteOdds(@PathVariable Long id) {
        oddsService.deleteOdds(id);
    }

    @GetMapping
    public List<OddsResponseDTO> getOddsByMatch(@RequestParam Long matchId) {
        return oddsService.getOddsByMatch(matchId);
    }
}
