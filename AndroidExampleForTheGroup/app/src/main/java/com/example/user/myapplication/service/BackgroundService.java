package com.example.user.myapplication.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

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

public class BackgroundService extends Service {

    private final String TAG = "Background Service";
    private Socket socket;

    public BackgroundService(Socket socket){
        this.socket = socket;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand() CALLED");
        BufferedReader reader;
        String data;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            /*
             * 항상 듣고 있을 아이입니다.
             * 한줄을 읽고 다음 while문 동안 기다립니다.
             * 만약에 읽을 줄이 없다면 알아서 그냥 멈춤상태로 기다립니다.
             * 그랬다가 한줄이 오게 되면 다시 움직입니다.
             */
            while((data = reader.readLine())!= null) {
                Log.d(TAG, data);
                /*
                 * 이 곳에 로직을 입력합니다.
                 * 가장 좋다고 느껴지는 접근은 스위치를 이용해서 거르는것 같습니다.
                 * 여기서 또한 Officer인 Json이 있는지 확인하고 처리해주어야합니다.
                 * 중요한 점은 Tourist와 Officer는 동시에 1명씩밖에 존재하지 않기 때문에
                 * 그냥 메모리에 띄워두는것도 좋은 방법인듯합니다.
                 * 이럴경우 급작스런 종료에 의한 오류를 처리해주어야 할것입니다.
                 */
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.d(TAG, "Socket Problem");
        }
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
