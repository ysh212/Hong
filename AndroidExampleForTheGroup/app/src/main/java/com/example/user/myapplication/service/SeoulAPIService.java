package com.example.user.myapplication.service;

import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

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
public class SeoulAPIService implements ISeoulAPIService {
    private final String TAG = "Seoul API Service";

    HttpURLConnection  con;

    @Override
    public List<Map> fetchEmbassyList() {
        Log.d(TAG, "fetchEmbassyList() CALLED");
        List<Map> list = null;
        /*
        로직
        여기서 아래의 메소드를 부르면 될거 같습니다.
         */
        Log.d(TAG, "fetchEmbassyList() -> " + list.size());
        return null;
    }

    @Override
    public String fetchEmbassyInfo() {
        Log.d(TAG, "fetchEmbassyList() CALLED");
        String str = null;
        /*
        로직
        여기서 아래의 메소드를 부르면 될거 같습니다.
         */
        Log.d(TAG, "fetchEmbassyList() -> " + str);
        return str;
    }

    /**
     * String주소로 요청을 보내고 응답을 받은 내용을 리턴합니다.
     *
     * @param urlString String상태의 API요청 주소를 주세요
     * @return str api의 내용을 리턴합니다.
     */
    private String sendPost(String urlString){
        String str = null;
        URL url = null; //위의 내용으로 URL만들고
        HttpURLConnection http = null; //위의 내용을 가지고 Connection을 생성합니다.
        /*
        그리고 여기서 요청을 하고 응답을 받아 리턴하는 로직을 짜주세요.
         */
        return str;
    }
}
