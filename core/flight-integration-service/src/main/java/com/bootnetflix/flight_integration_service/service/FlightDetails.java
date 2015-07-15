package com.bootnetflix.flight_integration_service.service;

/**
 * Created by Ext_IdanF on 12/07/2015.
 */
public class FlightDetails {

    String couponId;
    String availableFlightList;

    public FlightDetails(String avaliable,String coupon) {
        this.availableFlightList = avaliable;
        this.couponId = coupon;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getAvailableFlightList() {
        return availableFlightList;
    }

    public void setAvailableFlightList(String availableFlightList) {
        this.availableFlightList = availableFlightList;
    }

    @Override
    public String toString() {
        return "FlightDetails{" +
                "couponId='" + couponId + '\'' +
                ", availableFlightList='" + availableFlightList + '\'' +
                '}';
    }
}
