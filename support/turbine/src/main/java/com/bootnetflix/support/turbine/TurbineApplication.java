package com.bootnetflix.support.turbine;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.turbine.amqp.EnableTurbineAmqp;

/**
 * Created by idan on 5/18/15.
 */

@EnableAutoConfiguration
@EnableEurekaClient
@EnableTurbineAmqp
public class TurbineApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(TurbineApplication.class).run(args);
    }


}
