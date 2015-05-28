package com.bootnetflix.flight_integration_service.service;

import com.bootnetflix.flight_integration_service.registry.RegistryService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.inject.Named;
import java.net.URI;
import java.util.Arrays;

/**
 * Created by Ext_IdanF on 26/05/2015.
 */
@Named
public class FlightIntegrationService {

    private static final Logger LOG = LoggerFactory.getLogger(FlightIntegrationService.class);
    private RestTemplate restTemplate = new RestTemplate();


    @Autowired
    RegistryService registryService;


    @HystrixCommand(fallbackMethod = "defaultFlightList")
    public String getFlightList() {
        URI uri = registryService.getServiceUrl("flight-booking-service", "http://localhost:8081/flight-booking-service");
        String url = uri.toString() + "/flights/list";
        LOG.debug("GetProduct from URL: {}", url);

        ResponseEntity<String> resultStr = restTemplate.getForEntity(url, String.class);
        LOG.debug("GetProduct http-status: {}", resultStr.getStatusCode());
        LOG.debug("GetProduct body: {}", resultStr.getBody());
        return resultStr.getBody();
    }


    public String defaultFlightList() {
        LOG.info("Using fallback method for flight-booking-service");
        return Arrays.asList(new String[]{"defaultFlight1", "defaultFlight2", "defaultFlight3"}).toString();
    }


}
