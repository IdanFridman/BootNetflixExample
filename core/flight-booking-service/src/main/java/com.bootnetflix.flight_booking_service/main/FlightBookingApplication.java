package com.bootnetflix.flight_booking_service.main;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by idan on 5/18/15.
 */
@Configuration
@ComponentScan("com.bootnetflix")
@EnableAutoConfiguration
@EnableCircuitBreaker
public class FlightBookingApplication {


    public static void main(String[] args) {
        new SpringApplicationBuilder(FlightBookingApplication.class).run(args);
    }

}