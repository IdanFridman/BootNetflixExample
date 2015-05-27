package com.bootnetflix.support.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by idan on 5/18/15.
 */

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication  {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaApplication .class).web(true).run(args);
    }



}
