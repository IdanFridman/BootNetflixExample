package com.bootnetflix.eureka.client.services;

import javax.inject.Named;

/**
 * Created by idan on 5/18/15.
 */
@Named
public class BroProducerService {

    public String produceBro(String name)
    {
        return name+ " - Yo Bro";

    }

}
