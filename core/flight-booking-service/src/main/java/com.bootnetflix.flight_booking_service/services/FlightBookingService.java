package com.bootnetflix.eureka.client.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by idan on 5/18/15.
 */
@RestController
public class FlightBookingService {

    @RequestMapping("/flights/list")
    public List getAvailableFlightsList()
    {
        return Arrays.asList("Canada,USA,Israel");
    }

    @RequestMapping("flights/book")
    public String addNewFile()
    {
        return "success";
    }

}
