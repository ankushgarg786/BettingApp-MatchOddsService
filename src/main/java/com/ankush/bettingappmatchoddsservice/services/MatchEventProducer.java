package com.ankush.bettingappmatchoddsservice.services;

import com.ankush.bettingappmatchoddsservice.events.MatchCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MatchEventProducer {

    private static final String TOPIC = "match-events";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMatchCreatedEvent(MatchCreatedEvent event) {
        kafkaTemplate.send(TOPIC, event);
    }
}
