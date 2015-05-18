package com.bootnetflix.hystrix.client.main;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by idan on 5/18/15.
 */
@Configuration
@ComponentScan("com.bootnetflix")
@EnableAutoConfiguration
//@EnableEurekaClient
@EnableCircuitBreaker
public class Application {


    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).run(args);
    }

}