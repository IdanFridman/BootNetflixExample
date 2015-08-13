package com.bootnetflix.flight_integration_service.service;

import com.bootnetflix.flight_integration_service.registry.RegistryService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.async.DeferredResult;
import rx.Observable;

import javax.inject.Named;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ext_IdanF on 26/05/2015.
 */
@Named
public class FlightIntegrationService {

    private static final Logger LOG = LoggerFactory.getLogger(FlightIntegrationService.class);
    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    FlightBookingIntegrationService flightBookingIntegrationService;

    @Autowired
    CouponIntegrationService couponIntegrationService;

    @Autowired
    RegistryService registryService;

    //demo-6
    @Autowired
    BaggageService baggageService;


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


    public String getCoupon() {
        URI uri = registryService.getServiceUrl("coupon-service", "http://localhost:8081/coupon-service");
        String url = uri.toString() + "/coupon/generate";
        LOG.debug("GetProduct from URL: {}", url);

        ResponseEntity<String> resultStr = restTemplate.getForEntity(url, String.class);
        LOG.debug("GetProduct http-status: {}", resultStr.getStatusCode());
        LOG.debug("GetProduct body: {}", resultStr.getBody());
        return resultStr.getBody();

    }


    public DeferredResult<FlightDetails> getAllFlightDetails() {


        //Calling previous defined functions
        Observable<String> availableFlightBookings = flightBookingIntegrationService.getAvailableFlightBookings();
        Observable<String> couponId = couponIntegrationService.getCoupon();




        DeferredResult<FlightDetails> result = new DeferredResult();

        Observable.zip(availableFlightBookings, couponId, (coupon, available) -> {
            // do some logic here..
            return new FlightDetails(coupon, available);
        }).subscribe(result::setResult, result::setErrorResult);
        return result;

    }


    public String getBaggageListById(String id) {
        URI uri = registryService.getServiceUrl("baggage-service", "http://localhost:8081/baggage-service");
        String url = uri.toString();// + "/baggage/list/" + id;
        LOG.info("GetBaggageList from URL: {}", url);

        ResponseEntity<String> resultStr = restTemplate.getForEntity(url, String.class);
        LOG.info("GetProduct http-status: {}", resultStr.getStatusCode());
        LOG.info("GetProduct body: {}", resultStr.getBody());
        return resultStr.getBody();

    }



    public List<String> getBaggageListByIdWithFeign(String id) {
        return baggageService.getBaggageListByFlightId(id);
    }
}
