package com.team.seoul.gongmo.domain;

import java.net.Socket;
import java.util.UUID;

/**
 * Created by USER on 2017-09-27.
 */

public class Tourist {
    //신고측의 상황 내용
    private String situation;
    //위도
    private Double lat;
    //경도
    private Double lon;
    //관광객이 사용하는 언어 선택
    private String lang;
    //전화번호 - 관광객
    private String phoneNum;
    //관광객 핸드폰 UUID
    private UUID touristUUID;
    //관광객의 소켓 정보(소켓을 다시 불러서 데이터를 보내야하기 때문에)
    private Socket socket;
    //officer의 핸드폰 고유번호
    private UUID officerUUID;

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

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

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public UUID getTouristUUID() {
        return touristUUID;
    }

    public void setTouristUUID(UUID touristUUID) {
        this.touristUUID = touristUUID;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public UUID getOfficerUUID() {
        return officerUUID;
    }

    public void setOfficerUUID(UUID officerUUID) {
        this.officerUUID = officerUUID;
    }

    @Override
    public String toString() {
        return "Tourist{" +
                "situation='" + situation + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", lang='" + lang + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", touristUUID=" + touristUUID +
                ", socket=" + socket +
                ", officerUUID=" + officerUUID +
                '}';
    }
}
