package com.sidd.flight.flightcheckin.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.sidd.flight.flightcheckin.entity.Passenger;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void publishCheckInEvent(Passenger passenger) {
        String topic = "flight-checkin-topic";

        // You can send just passenger info, or wrap it in a DTO/event class
        kafkaTemplate.send(topic, passenger);

        System.out.println("✅ Published check-in event for passenger: " + passenger.getName());
    }
}
