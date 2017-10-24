package com.example.user.myapplication.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by USER on 2017-10-18.
 */

public class TouristInfo implements Serializable{
    private Tourist tourist;
    private String address;
    private Date requestTime;
    private String distance;

    public Tourist getTourist() {
        return tourist;
    }

    public void setTourist(Tourist tourist) {
        this.tourist = tourist;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "TouristInfo{" +
                "tourist=" + tourist +
                ", address='" + address + '\'' +
                ", requestTime=" + requestTime +
                ", distance='" + distance + '\'' +
                '}';
    }
}
