package com.sidd.flight.flightcheckin.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sidd.flight.flightcheckin.entity.Passenger;
import com.sidd.flight.flightcheckin.repository.PassengerRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/passengers")
@RequiredArgsConstructor
public class PassengerController {

    // This controller will handle passenger-related operations
    private final PassengerRepository passengerRepository;

    @GetMapping
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }
}
