package com.bootnetflix.flight_integration_service.baggae_service.main;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by idan on 5/18/15.
 */
@Configuration
@ComponentScan("com.bootnetflix")
@EnableAutoConfiguration
@EnableEurekaClient
@EnableFeignClients
public class BaggageServiceApplication {


    public static void main(String[] args) {
        new SpringApplicationBuilder(BaggageServiceApplication.class).run(args);
    }

}