package com.ankush.bettingappmatchoddsservice.services;

import com.ankush.bettingappmatchoddsservice.events.MatchCreatedEvent;
import com.ankush.bettingappmatchoddsservice.events.ScoreUpdateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MatchEventProducer {

    private static final String TOPIC_MATCH_EVENTS = "match-events";

    private static final String TOPIC_SCORE_UPDATES = "score-updates";


    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMatchCreatedEvent(MatchCreatedEvent event) {
        kafkaTemplate.send(TOPIC_MATCH_EVENTS, event);
    }

    public void sendScoreUpdateEvent(ScoreUpdateEvent event) {
        kafkaTemplate.send(TOPIC_SCORE_UPDATES, event);
    }
}
