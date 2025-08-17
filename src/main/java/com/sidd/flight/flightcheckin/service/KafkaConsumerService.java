package com.sidd.flight.flightcheckin.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.sidd.flight.flightcheckin.entity.Passenger;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "flight-checkin-topic", groupId = "my-group")
    public void consume(Passenger passenger) {
        System.out.println("✅ Consumed check-in event for passenger: " + passenger.getName());
    }
}
