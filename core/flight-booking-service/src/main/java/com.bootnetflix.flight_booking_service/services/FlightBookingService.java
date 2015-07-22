package com.bootnetflix.flight_booking_service.services;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by idan on 5/18/15.
 */
@RestController
@FeignClient("bookings")
public class FlightBookingService {

    @RequestMapping("/flights/list")
    public List getAvailableFlightsList()
    {
        System.out.println("FlightBookingService, getAvailableFlightsList, returning Canada,USA,Israel ");
        return Arrays.asList("Canada,USA,Israel");
    }

    @RequestMapping("flights/book")
    public String addNewBooking()
    {
        return "success";
    }
}
