package com.sidd.flight.flightcheckin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sidd.flight.flightcheckin.entity.Passenger;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class NotificationMailService {

    @Autowired
    private final JavaMailSender mailSender;

    public void sendCheckInNotification(Passenger passenger) {


        // Implementation for sending email notifications
        // This method will use mailSender to send the email

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(passenger.getEmail());
        message.setSubject("Flight Check-In Confirmation");
        message.setText("Dear " + passenger.getName() + ",\n\n" + 
                        "You have successfully checked in for your flight.\n" +
                        "Flight Number: " + passenger.getFlight().getFlightNumber() + "\n" +
                        "Thank you for choosing our service!\n\n" +
                        "Best regards,\n" +
                        "Flight Check-In Team");
        mailSender.send(message);
    }

}
