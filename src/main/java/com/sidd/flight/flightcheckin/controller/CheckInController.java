package com.sidd.flight.flightcheckin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sidd.flight.flightcheckin.dto.CheckInRequestDto;
import com.sidd.flight.flightcheckin.service.CheckInService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/checkin")
@RequiredArgsConstructor
public class CheckInController {

    private final CheckInService checkInService;

    @PostMapping
    public ResponseEntity<String> checkIn (@RequestBody CheckInRequestDto request) {
      
         checkInService.checkIn(request);

        return ResponseEntity.ok("Check-in successful for " + request.getPassengerId() + 
        " on flight " + request.getFlightId());
    }

    // GET /checkin/{passengerId}
    @GetMapping("/{passengerId}")
    public ResponseEntity<String> getCheckInStatus(@PathVariable String passengerId) {
        // later you can call a service method, for now just return dummy
        return ResponseEntity.ok("Passenger " + passengerId + " is checked-in");
    }

}
