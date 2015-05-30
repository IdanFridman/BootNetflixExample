package com.bootnetflix.coupon_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by idan on 5/30/15.
 */
@RestController
public class CouponController {

    @Autowired
    CouponService couponService;


    @RequestMapping("/coupon/generate")
    public String generateCoupon() {
        return couponService.generateNewCoupon();

    }




}
