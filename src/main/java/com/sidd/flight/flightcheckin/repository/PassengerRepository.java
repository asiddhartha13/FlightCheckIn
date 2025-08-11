package com.sidd.flight.flightcheckin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sidd.flight.flightcheckin.entity.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    
    // Additional query methods can be defined here if needed

}
