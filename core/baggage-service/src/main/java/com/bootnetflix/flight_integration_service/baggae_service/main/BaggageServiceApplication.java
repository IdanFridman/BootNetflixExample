package com.bootnetflix.flight_integration_service.baggae_service.main;

import com.bootnetflix.flight_integration_service.baggae_service.services.BaggageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by idan on 5/18/15.
 */
@Configuration
@ComponentScan("com.bootnetflix")
@EnableAutoConfiguration
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.bootnetflix"})
@RestController
public class BaggageServiceApplication {


    @Autowired
    BaggageService baggageService;

    public static void main(String[] args) {
        new SpringApplicationBuilder(BaggageServiceApplication.class).run(args);
    }

    @RequestMapping("/")
    public List<String> consume() {
        return baggageService.getBaggageListByFlightId();
    }

}