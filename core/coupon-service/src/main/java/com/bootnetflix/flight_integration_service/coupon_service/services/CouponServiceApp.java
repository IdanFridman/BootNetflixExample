package com.bootnetflix.flight_integration_service.coupon_service.services;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by idan on 5/18/15.
 */
@Configuration
@ComponentScan("com.bootnetflix")
@EnableAutoConfiguration
@EnableEurekaClient
public class CouponServiceApp {


    public static void main(String[] args) {
        new SpringApplicationBuilder(CouponServiceApp.class).run(args);
    }

}