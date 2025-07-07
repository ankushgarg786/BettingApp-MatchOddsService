//package com.ankush.bettingappmatchoddsservice.services;
//
//import com.ankush.bettingappmatchoddsservice.dtos.MatchKafkaDTO;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MatchKafkaConsumer {
//
//    @KafkaListener(topics = "match-events", groupId = "match-event-consumer-group")
//    public void consumeMatch(MatchKafkaDTO matchDto) {
//        System.out.println("📥 Received match from Kafka: " + matchDto);
//    }
//}
