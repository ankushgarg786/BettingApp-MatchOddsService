package com.ankush.bettingappmatchoddsservice.repositories;

import com.ankush.bettingappentityservice.models.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match,Long> {
}
