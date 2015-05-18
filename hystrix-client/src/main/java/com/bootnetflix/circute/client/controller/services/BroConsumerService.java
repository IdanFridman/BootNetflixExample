package com.bootnetflix.circute.client.controller.services;

import com.goebl.david.Webb;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import javax.inject.Named;

/**
 * Created by idan on 5/18/15.
 */
@Named
public class BroConsumerService {

    private static final String url="http://127.0.0.1:8082/getBro";


    @HystrixCommand(fallbackMethod = "stubbedBro")
    public String getRemoteBro(String name) {


        Webb webb = Webb.create();
        String result = webb
                .get(url)
                .param("name",name)
                .ensureSuccess().asString().getBody();
        return result;
    }

    private String stubbedBro(String name) {
        return "String hello"+name +", broService is down, Till we work it out check our stubbed bro";
    }
}
