package com.example.user.myapplication.service;

import android.app.ExpandableListActivity;
import android.util.Log;

import com.example.user.myapplication.domain.Global;
import com.example.user.myapplication.domain.Tourist;
import com.example.user.myapplication.domain.TouristInfo;
import com.skp.Tmap.TMapData;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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

public class TouristService implements ITouristService{
    private final String TAG = "Tourist Service";
    //위도, 경도값을 주소로 반환하기 위해 필요한 객체
    TMapData tMapData = new TMapData();
    TouristInfo touristInfo;
    Tourist tourist;
    Global global;

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
        List<UUID> listUuid = new ArrayList<>();


        //현재시간 가져오기
        long currentTime = System.currentTimeMillis();
        Date today = new Date(currentTime);
        //월, 일, 시, 분, 초 형식
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd HH:mm:ss");
        String reportTime = sdf.format(today);

        /////--------------------------------------/////
                for(int i =0; i<5; i++) {

                    touristInfo = new TouristInfo();
                    tourist = new Tourist();
                    touristInfo.setAddress("Seoul");
                    touristInfo.setDistance("1"+i+"m");
                    touristInfo.setRequestTime(reportTime);

        //만약에 이렇게 데이터가 있다면,,,,넘겨줘야되는데
                    tourist.setLat(126.11);//위도
                    tourist.setLon(37.45);//경도
                    tourist.setLang("English");
                    tourist.setPhonenum("010-0000-0000");//전화번호
                    tourist.setUuid(new UUID(3,i));//uuid - 아무거나 적음
                    tourist.setAccepted(false);//수행 여부

                    listUuid.add(new UUID(3,1));

                    touristInfo.setTourist(tourist);

                   listInfo.add(touristInfo);
                    Log.d("uuidValue: ", tourist.getUuid().toString());
                }

        /////--------------------------------------/////
        Log.d(TAG, "setupTourist() -> "+listInfo.toString());
        return listInfo;
    }

    //아이템이 수행중인지 여부 확인 - 수행중이라면(true) 리스트에서 삭제
    //매개변수 수행중인 uuid를 보내준것임...이것을 리스트에 있는 uuid와 비교=> true라면 리스트에서 삭제
    @Override
    public UUID onDutyItem() {
        //이것이 서버에서 가져온 uuid(randomUuid)라면,
        UUID randomUuid = new UUID(3,1);
        Log.d("why: ", randomUuid.toString());

        return randomUuid;
    }
}
