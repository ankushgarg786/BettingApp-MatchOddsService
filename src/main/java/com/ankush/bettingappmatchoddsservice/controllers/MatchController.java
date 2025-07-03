package com.ankush.bettingappmatchoddsservice.controllers;

import com.ankush.bettingappmatchoddsservice.dtos.MatchRequestDTO;
import com.ankush.bettingappmatchoddsservice.dtos.MatchResponseDTO;
import com.ankush.bettingappmatchoddsservice.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @PostMapping
    public MatchResponseDTO createMatch(@RequestBody MatchRequestDTO dto) {
        return matchService.createMatch(dto);
    }

    @GetMapping("/{id}")
    public MatchResponseDTO getMatch(@PathVariable Long id) {
        return matchService.getMatch(id);
    }

    @PutMapping("/{id}")
    public MatchResponseDTO updateMatch(@PathVariable Long id, @RequestBody MatchRequestDTO dto) {
        return matchService.updateMatch(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteMatch(@PathVariable Long id) {
        matchService.deleteMatch(id);
    }

    @GetMapping
    public List<MatchResponseDTO> listMatches() {
        return matchService.listMatches();
    }
}
