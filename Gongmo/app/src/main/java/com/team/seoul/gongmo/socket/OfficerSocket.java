package com.team.seoul.gongmo.socket;

import android.widget.Switch;

import com.team.seoul.gongmo.domain.Connected;
import com.team.seoul.gongmo.domain.Officer;
import com.team.seoul.gongmo.domain.Tourist;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by 유석환 on 2017-09-29.
 */

public class OfficerSocket {
    public Socket socket;
    //private String IP = "192.168.56.1";
    private String IP = "172.30.1.35";
    private int PORT  = 29705;
    private BufferedReader br;
    private PrintWriter pw;

    Connected connected;
    Officer officer;
    Tourist touristInfo;

    //고려 해야함
    /*
    public OfficerSocket(Socket socket, String data){
        this.socket = socket;
        receive();
    }
    */

    //소켓 연결
    public void startConnect(){
        Thread thread = new Thread(){
            @Override
            public void run(){
                try {
                    socket = new Socket();
                    socket.connect(new InetSocketAddress(IP, PORT));
                    br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    pw = new PrintWriter(socket.getOutputStream());

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        };
        thread.setDaemon(true);
        thread.start();
    }

    //서버로부터 데이터를 받는 메소드
    public void receive(){
        Thread thread = new Thread() {
            @Override
            public void run(){
                StringBuilder sb = new StringBuilder();
                while(true){
                    try {
                        String data = br.readLine();
                        if(data == null){
                            break;
                        }
                        sb.append(data + "\n");

                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    //서버로 받은 JSON 데이터를 Tourist DTO에 저장

                    JSONObject jsonObject = new JSONObject(sb.toString());
                    String tourist = jsonObject.getString("tourist");

                    JSONObject jsonObject1 = new JSONObject(tourist);
                    touristInfo.setSituation(jsonObject1.getString("type"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    //서버로 데이터를 보내는 메소드 - ex)사용가능한 언어;JSON형태
    public void send(final Officer officer){
        final Thread thread = new Thread(){
            @Override
            public void run(){
                while(true){
                    String officerMsg = null;
                    JSONStringer jsonStringer = new JSONStringer();

                    try {
                        officerMsg = jsonStringer.object().key("type").value(connected.CONNECT)
                                .key("officer").object()
                                .key("lang").value(officer.getLang())
                                .key("lon").value(officer.getLon())
                                .key("lat").value(officer.getLat())
                                .key("phoneNum").value(officer.getPhoneNum())
                                .key("officerUUID").value(officer.getOfficerUUID())
                                .endObject()
                                .endObject().toString();

                        pw.println(officerMsg);
                        pw.flush();
                        pw.close();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    //json 타입으로 데이터를 서버로 전송
                    //pw.println(jsonMsg());

                    //pw.flush();
                    //pw.close();
                }
            }
        };
        thread.start();
    }

}


