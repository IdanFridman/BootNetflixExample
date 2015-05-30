package com.bootnetflix.coupon_service;

import javax.inject.Named;

/**
 * Created by idan on 5/18/15.
 */
@Named
public class BroConsumerService {


    private static final String url = "http://127.0.0.1:8082/getBro";


   /* @HystrixCommand(fallbackMethod = "additionalStubbedBro")
    public String getRemoteBro(String name) {
        return(executeRemoteService(name));
    }


    private String executeRemoteService(String name) {
        Webb webb = Webb.create();
        return webb
                .get(url)
                .param("name", name)
                .ensureSuccess().asString().getBody();
    }

    private String stubbedBro(String name) {
        return "String hello" + name + ", broService is down, Till we work it out check our stubbed bro";
    }*/

}
