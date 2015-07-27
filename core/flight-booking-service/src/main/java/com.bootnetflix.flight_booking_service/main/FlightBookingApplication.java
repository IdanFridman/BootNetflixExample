package com.bootnetflix.flight_booking_service.main;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by idan on 5/18/15.
 */
@SpringBootApplication //annotation is equivalent to using @Configuration, @EnableAutoConfiguration and @ComponentScan
@ComponentScan("com.bootnetflix")
@EnableDiscoveryClient
public class FlightBookingApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(FlightBookingApplication.class).run(args);
    }

}
