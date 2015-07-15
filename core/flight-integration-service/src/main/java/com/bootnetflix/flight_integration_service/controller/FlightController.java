package com.bootnetflix.flight_integration_service.controller;

import com.bootnetflix.flight_integration_service.service.FlightDetails;
import com.bootnetflix.flight_integration_service.service.FlightIntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created by Ext_IdanF on 27/05/2015.
 */
@RestController
public class FlightController {

    @Autowired
    FlightIntegrationService flightIntegrationService;

    @RequestMapping("/flights/list")
    public String getFlightList() {
        String result = flightIntegrationService.getFlightList();
        return result;
    }

    @RequestMapping("/flights/coupon")
    public String getCoupon() {
        String result = flightIntegrationService.getCoupon();
        return result;
    }

    @RequestMapping("/flights/all_details")
    public  DeferredResult<FlightDetails>  getAllFlightDetails() {
        DeferredResult<FlightDetails> deferredResult = flightIntegrationService.getAllFlightDetails();
        return deferredResult;
    }
}
