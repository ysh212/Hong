package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.user.myapplication.presenter.TouristPresenter;
import com.example.user.myapplication.view.ITouristView;

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
 * 관광경찰 버튼을 누를시에 시작되는 액티비티입니다.
 * 이 액티비티는 타입을 선택하고
 * 메세지를 입력받아 서버에 보내는 버튼을 포함해야합니다.
 * 이 액티비티는 보내기와 동시에 finish() 되어야합니다.
 *
 * ::주의::
 * 서비스를 여기에 바인드해서 부르면 안됩니다.
 * 이 액티비티는 종료되어야하기 때문입니다.
 * 같은 이유로 여기에 Tourist 객체를 가지고 있는것은 안됩니다.
 */
public class TouristActivity extends AppCompatActivity implements ITouristView {
    private final String TAG = "Tourist Activity";

    //프레젠터 create에서 생성
    private TouristPresenter touristPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist);
        Log.d(TAG, "created");
        /*
         * 여기서 버튼들이나 텍스트입력창등의 레퍼런스를 가져오고
         * sendToServer를 온클릭으로 추가합니다.
         */
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "started");

        /*
         *
         */
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "stopped");

        /*
         *
         */
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "paused");

        /*
         *
         */
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "resumed");

        /*
         *
         */
    }


    /**
     * 보내기 버튼이 클릭시 처리할 내용입니다.
     * 여기서 sendToServer를 불러야합니다.
     */
    private View.OnClickListener sendBtnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(TAG, "send button clicked");
            //이런식의 코드가 될듯합니다.
            //sendToServer(getType(), getMsg());
        }
    };

    /**
     * 서버에 메세지를 보내기 위한 메소드
     * TouristPresenter의 sendToServer(int type, String msg)를 호출해야합니다.
     * 이때 type과 String을 밑의 메소드 두가지를 사용해서 가져와야합니다.
     */
    private void sendToServer(int type, String msg) {
        Log.d(TAG, "sendToServer() CALLED");

        /*
         *
         */
        Log.d(TAG, "sendToServer() DONE");
    }


    /**
     * 액티비티의 현 상태에서 type값을 가져옵니다.
     *
     * @return type 파이널 스태틱인 코드들 중 하나(상황에 맞는 걸로)
     */
    private int getType() {
        Log.d(TAG, "getType() CALLED");
        int type = -1;
        /*
         * 여기에 액티비티의 데이터를 가져오는 로직을
         * 생성해 주세요
         *
         * 그리고 그 값에 따라서 type을 바꾸어주세요
         */
        Log.d(TAG, "getType() -> "+ type);
        return type;
    }


    /**
     * 액티비티의 현 상태에서 msg값을 가져옵니다.
     *
     * @return msg 전달되야하는 메세지
     */
    private String getMsg() {
        Log.d(TAG, "getMsg() CALLED");
        String msg = "";
        /*
         * 여기에 텍스트 필드의 데이터를 가져오는 로직을
         * 생성해 주세요
         */
        Log.d(TAG, "getMsg() -> "+ msg);
        return msg;
    }
}
