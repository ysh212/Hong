package com.team.seoul.gongmo.domain;

import java.net.Socket;
import java.util.List;
import java.util.UUID;

/**
 * Created by USER on 2017-09-27.
 */

public class Officer {
    //위도
    private Double lat;
    //경도
    private Double lon;
    //전화번호 - 1 vs 1 통신을 위함
    private String phoneNum;
    //핸드폰 고유번호 - UUID
    private String officerUUID;
    //officer가 가능한 언어리스트
    private List<String> lang;
    //office의 소켓 - 신고측과 소통하기 위해서
    private Socket socket;
    //업무중인지 판별 여부
    private boolean onDuty;
    //관광객의 핸드폰 고유번호 - UUID
    private UUID touristUUID;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getOfficerUUID() {
        return officerUUID;
    }

    public void setOfficerUUID(String officerUUID) {
        this.officerUUID = officerUUID;
    }

    public List<String> getLang() {
        return lang;
    }

    public void setLang(List<String> lang) {
        this.lang = lang;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public boolean isOnDuty() {
        return onDuty;
    }

    public void setOnDuty(boolean onDuty) {
        this.onDuty = onDuty;
    }

    public UUID getTouristUUID() {
        return touristUUID;
    }

    public void setTouristUUID(UUID touristUUID) {
        this.touristUUID = touristUUID;
    }

    @Override
    public String toString() {
        return "Officer{" +
                "lat=" + lat +
                ", lon=" + lon +
                ", phoneNum='" + phoneNum + '\'' +
                ", officerUUID=" + officerUUID +
                ", lang=" + lang +
                ", socket=" + socket +
                ", onDuty=" + onDuty +
                ", touristUUID=" + touristUUID +
                '}';
    }
}
