package com.ankush.bettingappmatchoddsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.ankush.bettingappentityservice.models")

public class BettingAppMatchOddsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BettingAppMatchOddsServiceApplication.class, args);
    }

}
