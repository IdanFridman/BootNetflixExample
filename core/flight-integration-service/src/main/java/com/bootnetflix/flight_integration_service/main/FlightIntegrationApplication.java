package com.bootnetflix.flight_integration_service.main;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by idan on 5/18/15.
 */
@SpringBootApplication
@EnableCircuitBreaker
@EnableDiscoveryClient
@ComponentScan("com.bootnetflix")
@EnableFeignClients(basePackages = {"com.bootnetflix"})
public class FlightIntegrationApplication {


    public static void main(String[] args) {
        new SpringApplicationBuilder(FlightIntegrationApplication.class).run(args);
    }

}