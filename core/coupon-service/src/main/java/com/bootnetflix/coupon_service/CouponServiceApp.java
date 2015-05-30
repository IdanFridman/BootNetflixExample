package com.bootnetflix.coupon_service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by idan on 5/18/15.
 */
@SpringBootApplication
@EnableCircuitBreaker
@EnableDiscoveryClient
@ComponentScan("com.bootnetflix")
public class CouponServiceApp {




    public static void main(String[] args) {
        new SpringApplicationBuilder(CouponServiceApp.class).run(args);
    }


}