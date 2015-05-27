package com.bootnetflix.flight_integration_service.baggae_service.controller;

import com.bootnetflix.flight_integration_service.baggae_service.services.BroConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rx.Observable;
import rx.Observer;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by idan on 5/18/15.
 */
@RestController
public class MyController {

    @Autowired
    BroConsumerService broConsumerService;

    @RequestMapping("/executeBro")
    public String executeBro(@RequestParam(value = "name", required = false) String name) {

        String result = broConsumerService.getRemoteBro(name);
        System.out.println("result=" + result);
        return result;

    }

    @RequestMapping("/executeFutureBro")
    public String executeFutureBro(@RequestParam(value = "name", required = false) String name) throws ExecutionException, InterruptedException {
        Future<String> result = broConsumerService.runFutureBro(name);
        String myResut = result.get();
        return myResut;

    }

    Observable<String> result = null;

    @RequestMapping("/executeObservableBro")
    public String executeObservableBro(@RequestParam(value = "name", required = false) String name) throws ExecutionException, InterruptedException {


        broConsumerService.executeObservableBro(name).toBlocking().first();
        return null;
    }

    @RequestMapping("/startObserving")
    public void startObserving() {

        broConsumerService.executeObservableBro("idan").subscribe(new Observer<String>() {

            @Override
            public void onCompleted() {
                System.out.println("completed");
            }

            @Override
            public void onError(Throwable e) {
                System.out.printf(e.getMessage());
            }

            @Override
            public void onNext(String s) {
                System.out.println("on next.." + s);
            }
        });
    }

}
