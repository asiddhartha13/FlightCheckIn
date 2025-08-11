package com.sidd.flight.flightcheckin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CheckInRequestDto {
   
    private Long passengerId;
    private Long flightId;
}
