package com.bootnetflix.coupon_service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import javax.inject.Named;

/**
 * Created by idan on 5/30/15.
 */
@Named
public class CouponService {

    @HystrixCommand(fallbackMethod = "defaultGenerateNewCoupon")
    public String generateNewCoupon()
    {
        //assume this service can call a rest service
        System.out.println("generated New Coupon");
        return java.util.UUID.randomUUID().toString();
    }

    public String defaultGenerateNewCoupon()
    {
        System.out.printf("generated default New Coupon");
        return "333";
    }
}
