package com.sidd.flight.flightcheckin.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sidd.flight.flightcheckin.entity.Flight;
import com.sidd.flight.flightcheckin.repository.FlightRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/flights")
@RequiredArgsConstructor
public class FlightController {

    // This controller will handle flight-related operations

     private final FlightRepository flightRepository;

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
}
