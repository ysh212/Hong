package com.example.user.myapplication.domain;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;
import android.widget.Toast;

import com.example.user.myapplication.ListItemActivity;
import com.skp.Tmap.TMapData;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.xml.parsers.ParserConfigurationException;

/** by Hong Ji Hoon aka Hongvyo on github,
 *  Kim Eun Hye,
 *  Kim Min Ji,
 *  Kwon Soon Jo,
 *  Yu Seok Hwan
 *
 * 2017 september
 * submission to the Seoul App Competition held by the Seoul City Government.
 * copyright: MIT License
 */

public class Tourist implements Serializable {
    // 위도?
    private double lon;
    // 경도?
    // 이부분 바꿀 지도 몰라요
    private double lat;
    // 언어
    private String lang;
    // 전화번호
    private String phonenum;
    // 오피서가 배정이 되었는지 (if문 속도올릴려고 한거입니다.)
    private boolean accepted;
    // 핸폰 고유 번호
    private UUID uuid;

    // 속도를 올릴려고 한건데 다른 자료형을 사용할수 있습니다.
    // 오피서의 핸드폰 고유 번호
    private UUID officer;


    //추가 될지도 모르는 것
    //이런 변수를 추가해서 서로를 분간하는걸 빠르게 할수도 있습니다.
    //예를 들면 그냥 tourist1이렇게 스트링을 주는 걸로 말이죠.
    //private String 아무변수;


    @Override
    public String toString() {
        return "Tourist{" +
                "lon=" + lon +
                ", lat=" + lat +
                ", lang='" + lang + '\'' +
                ", phonenum='" + phonenum + '\'' +
                ", accepted=" + accepted +
                ", uuid=" + uuid +
                ", officer=" + officer +
                '}';
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getOfficer() {
        return officer;
    }

    public void setOfficer(UUID officer) {
        this.officer = officer;
    }
}
