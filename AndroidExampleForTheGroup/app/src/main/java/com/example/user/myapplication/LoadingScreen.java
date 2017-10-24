package com.example.user.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

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

/**
 * 로딩화면 입니다
 * 여기서 해야할 작업은 유저의 도움말 토글여부를 계산하는 정도가 될것 같습니다.
 * 여기서 관광객 객체를 생성해도 됩니다.
 * 하지만 메모리를 생각한다면 보내기 직전에 하는게 맞아보이긴합니다.
 * 이걸 로직을 짜면서 더 생각해보시기 바랍니다.
 */
public class LoadingScreen extends AppCompatActivity {
    private final String TAG = "Loading Screen";

    // 아래의 시간만큼 지난뒤에 로직이 시작됩니다.
    final int LOADING_TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);
        Log.d(TAG, "created");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "destroyed");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "started");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "postDelayed() started");
                /*
                 * 여기에 도움말 토글 여부를 가져오는 코드를 삽입하세요
                 */
                Log.d(TAG, "isToggleOn -> " + "이곳에 토글 여부를 알려주세요");
                Intent intent = new Intent(LoadingScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
        Handler handler = new Handler();

        //이 메소드는 뒤의 시간만큼 지난뒤에 runnable을 실행합니다.
        //더 알아보고 싶다면 https://developer.android.com/reference/android/os/Handler.html 을 읽어보세요
        handler.postDelayed( runnable, LOADING_TIME);
    }
}
