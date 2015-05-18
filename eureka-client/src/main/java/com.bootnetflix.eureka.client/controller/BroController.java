package com.bootnetflix.eureka.client.controller;

import com.bootnetflix.eureka.client.services.BroProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by idan on 5/18/15.
 */
@RestController
public class BroController {

    @Autowired
    BroProducerService broProducerService;

    @RequestMapping("/getBro")
    public String getBroController(@RequestParam(value = "name", required = false) String name) {
        return broProducerService.produceBro(name);
    }
}
