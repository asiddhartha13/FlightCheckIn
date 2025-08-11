package com.sidd.flight.flightcheckin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sidd.flight.flightcheckin.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    
    // Additional query methods can be defined here if needed

}
