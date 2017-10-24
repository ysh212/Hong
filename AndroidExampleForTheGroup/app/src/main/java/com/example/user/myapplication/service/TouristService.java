package com.example.user.myapplication.service;

import android.app.ExpandableListActivity;
import android.util.Log;

import com.example.user.myapplication.domain.Tourist;
import com.example.user.myapplication.domain.TouristInfo;
import com.skp.Tmap.TMapData;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

public class TouristService implements ITouristService{
    private final String TAG = "Tourist Service";
    //위도, 경도값을 주소로 반환하기 위해 필요한 객체
    TMapData tMapData = new TMapData();

    //싱글톤
    /*
    private static ITouristService touristService;

    public static ITouristService getInstance(){
        if(touristService == null){
            touristService = new TouristService();
        }
        return touristService;
    }
    //싱글톤일 경우, 생성자는 private
    private TouristService(){
        //불려졌을 때 1번만 수행될 내용을 작성
    };
    */

    /**
     * 기기에서 위치정보를 가져옵니다.
     */
    private String getLocation(final Double lat, final Double lon) {
        Log.d(TAG, "getLocation() CALLED");
        //tMapData = new TMapData();
        final String[] address = {null};

        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    address[0] = tMapData.convertGpsToAddress(lat, lon);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(r);
        thread.start();

        Log.d(TAG, "getLocation() -> "+"여기에 위의 로직 결과를 넣어주세요");
        return address[0];
    }

    @Override
    public List<TouristInfo> setupTourist() {
        Log.d(TAG, "setupTourist() CALLED");
        final List<TouristInfo> listInfo = new ArrayList<>();

        /////--------------------------------------/////
                for(int i =0; i<5; i++) {

                    TouristInfo touristInfo = new TouristInfo();
                    Tourist tourist = new Tourist();

                    touristInfo.setAddress("Seoul");
                    touristInfo.setDistance("1"+i+"m");
                    touristInfo.setRequestTime(new Date());
                    tourist.setLang("Korean");
                    touristInfo.setTourist(tourist);

                    listInfo.add(touristInfo);
                }

        /////--------------------------------------/////
        Log.d(TAG, "setupTourist() -> "+listInfo.toString());
        return listInfo;
    }
}
