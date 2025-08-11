package com.sidd.flight.flightcheckin.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sidd.flight.flightcheckin.dto.CheckInRequestDto;
import com.sidd.flight.flightcheckin.entity.Flight;
import com.sidd.flight.flightcheckin.entity.Passenger;
import com.sidd.flight.flightcheckin.repository.FlightRepository;
import com.sidd.flight.flightcheckin.repository.PassengerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CheckInServiceImpl implements CheckInService {

    private final PassengerRepository passengerRepository;
    private final FlightRepository flightRepository;
    private final KafkaProducerService kafkaProducerService;
    private final NotificationMailService notificationMailService;
    
    @Override
    public void checkIn(CheckInRequestDto request) {

        Optional<Flight> flightOpt = flightRepository.findById(request.getFlightId());
        Optional<Passenger> passengerOpt = passengerRepository.findById(request.getPassengerId());

        if (flightOpt.isEmpty() || passengerOpt.isEmpty()) {
            throw new RuntimeException("Invalid flight or passenger ID");
        }

        Flight flight = flightOpt.get();
        Passenger passenger = passengerOpt.get();

        passenger.setFlight(flight);
        passenger.setCheckedIn(true);
        passengerRepository.save(passenger);

        // Simulate Kafka event
        kafkaProducerService.publishCheckInEvent(passenger);


        // 4. Send notification email
        notificationMailService.sendCheckInNotification(passenger);
    }
}

