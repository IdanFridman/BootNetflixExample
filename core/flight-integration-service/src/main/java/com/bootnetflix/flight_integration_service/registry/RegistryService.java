package com.bootnetflix.flight_integration_service.registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

import javax.inject.Named;
import java.net.URI;

/**
 * Created by Ext_IdanF on 26/05/2015.
 */
@Named
public class RegistryService {

    private static final Logger LOG = LoggerFactory.getLogger(RegistryService.class);


    @Autowired
    LoadBalancerClient loadBalancer;

    public URI getServiceUrl(String serviceId, String fallbackUri) {
        URI uri;
        try {
            ServiceInstance instance = loadBalancer.choose(serviceId);
            uri = instance.getUri();
            LOG.debug("Resolved serviceId '{}' to URL '{}'.", serviceId, uri);

        } catch (RuntimeException e) {
            // Eureka not available, use fallback
            uri = URI.create(fallbackUri);
            LOG.error("Failed to resolve serviceId '{}'. Fallback to URL '{}'.", serviceId, uri);
        }

        return uri;
    }

}
