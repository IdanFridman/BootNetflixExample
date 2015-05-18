package com.bootnetflix.circute.client.controller;

import com.bootnetflix.circute.client.controller.services.BroConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by idan on 5/18/15.
 */
@RestController
public class MyController {

    @Autowired
    BroConsumerService broConsumerService;

    @RequestMapping("/executeBro")
    public void executeBro(@RequestParam(value = "name", required = false) String name) {

        String result = broConsumerService.getRemoteBro(name);
        System.out.println("result=" + result);

    }
}
