package com.bootnetflix.flight_integration_service.baggae_service.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import com.netflix.hystrix.contrib.javanica.command.ObservableResult;
import rx.Observable;

import javax.inject.Named;
import java.util.concurrent.Future;

/**
 * Created by idan on 5/18/15.
 */
@Named
public class BaggageServiceImpl{



    private static final String url = "http://127.0.0.1:8082/getBro";


    @HystrixCommand(fallbackMethod = "stubbedBro")
    public String getRemoteBro(String name) {
        return(executeRemoteService(name));
    }

    @HystrixCommand(fallbackMethod = "stubbedBro")
    public Future<String> runFutureBro(final String name) {
        return new AsyncResult<String>() {
            public String invoke() {
                return(executeRemoteService(name));
            }
        };}


    @HystrixCommand(fallbackMethod = "stubbedBro")
    public Observable<String> executeObservableBro(String name) {
        return new ObservableResult<String>() {
            @Override
            public String invoke() {
                return executeRemoteService(name);
            }
        };

    }


    private String executeRemoteService(String name) {
      /*  Webb webb = Webb.create();
        return webb
                .get(url)
                .param("name", name)
                .ensureSuccess().asString().getBody();*/
        return null;
    }

    private String stubbedBro(String name) {
        return "String hello" + name + ", broService is down, Till we work it out check our stubbed bro";
    }

   /* @Override
    public List<String> getBaggageListByFlightId() {
        return Arrays.asList("2,3,4");
    }*/
}
