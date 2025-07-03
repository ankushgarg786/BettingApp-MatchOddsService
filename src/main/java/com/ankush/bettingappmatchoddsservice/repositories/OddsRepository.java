package com.ankush.bettingappmatchoddsservice.repositories;

import com.ankush.bettingappentityservice.models.Odds;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OddsRepository extends JpaRepository<Odds, Long> {
    List<Odds> findByMatchId(Long matchId);
}
