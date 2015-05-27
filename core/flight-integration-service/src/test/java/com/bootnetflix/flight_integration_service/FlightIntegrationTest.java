package com.bootnetflix.flight_integration_service;

import com.bootnetflix.flight_integration_service.main.FlightIntegrationApplication;
import com.bootnetflix.flight_integration_service.service.FlightIntegrationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Ext_IdanF on 27/05/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= FlightIntegrationApplication.class)
public class FlightIntegrationTest {

    @Autowired
    FlightIntegrationService flightIntegrationService;

    @Test
    public void flightTest()
    {
        flightIntegrationService.getFlightList();

    }

}
