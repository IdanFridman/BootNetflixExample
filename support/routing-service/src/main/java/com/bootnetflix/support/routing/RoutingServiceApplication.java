package com.bootnetflix.support.routing;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.stereotype.Controller;

/**
 * Created by idan on 5/18/15.
 */

@SpringBootApplication
@EnableZuulProxy
@Controller
public class RoutingServiceApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(RoutingServiceApplication.class).run(args);
    }


}
