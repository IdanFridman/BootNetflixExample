package com.bootnetflix.support.turbine;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.amqp.EnableTurbineAmqp;

/**
 * Created by idan on 5/18/15.
 */

@SpringBootApplication
@EnableTurbineAmqp
@EnableDiscoveryClient
public class TurbineApplication  {

    public static void main(String[] args) {
        new SpringApplicationBuilder(TurbineApplication.class).run(args);    }



}
