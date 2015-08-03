package com.bootnetflix.flight_integration_service.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by idan on 8/3/15.
 */
@FeignClient("baggage-service")
public interface BaggageService {

    @RequestMapping(method = RequestMethod.GET, value = "/baggage/list/{flight_id}")
    List<String> getBaggageListByFlightId(@PathVariable("flight_id") String flightId);
}

