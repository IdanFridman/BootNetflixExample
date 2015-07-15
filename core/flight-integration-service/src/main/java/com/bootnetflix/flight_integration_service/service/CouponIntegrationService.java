package com.bootnetflix.flight_integration_service.service;

import com.bootnetflix.flight_integration_service.registry.RegistryService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.ObservableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

import javax.inject.Named;
import java.net.URI;

/**
 * Created by Ext_IdanF on 12/07/2015.
 */
@Named
public class CouponIntegrationService {

    @Autowired
    RegistryService registryService;

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand()
    public Observable<String> getCoupon() {
        return new ObservableResult<String>() {
            @Override
            public String invoke() {
                URI uri = registryService.getServiceUrl("coupon-service", "http://localhost:8081/coupon-service");
                String url = uri.toString() + "/coupon/generate";
                ResponseEntity<String> resultStr = restTemplate.getForEntity(url, String.class);
                return (String)resultStr.getBody();
            }
        };
    }
}
