package com.bootnetflix.flight_integration_service.service;

import com.bootnetflix.flight_integration_service.registry.RegistryService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.command.ObservableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

import javax.inject.Named;

/**
 * Created by Ext_IdanF on 12/07/2015.
 */
@Named
public class FlightBookingIntegrationService {

    @Autowired
    RegistryService registryService;

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(commandProperties={@HystrixProperty(name="hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds", value = "10000")})
    public Observable<String> getAvailableFlightBookings() {
        return new ObservableResult<String>() {
            @Override
            public String invoke() {
             //   URI uri = registryService.getServiceUrl("flight-booking-service", "http://localhost:8081/flight-booking-service");
              //  String url = uri.toString() + "/flights/list";

               // ResponseEntity<String> resultStr = restTemplate.getForEntity(url, String.class);
               // return resultStr.getBody();

                return "a1,b1,c1";
            }
        };
    }
}
