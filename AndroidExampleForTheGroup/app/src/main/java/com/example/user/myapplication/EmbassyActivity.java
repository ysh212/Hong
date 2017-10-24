package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.user.myapplication.presenter.EmbassyPresenter;
import com.example.user.myapplication.view.IEmbassyView;
import com.google.gson.JsonObject;

import java.util.List;

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
 * 여기는 위에 HTML의 select태그와 같은것을 주고 국가를 선택하도록 하는게 좋아보입니다.
 * 그 국가가 선택되는 순간 가능하다면 바로 데이터를 가져오도록 하면 100점입니다.
 */
public class EmbassyActivity extends AppCompatActivity implements IEmbassyView {
    private final String TAG = "Embassy Activity";

    //프레젠터 create에서 생성
    private EmbassyPresenter embassyPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_embassy);
        Log.d(TAG, "created");
        /*
        생성과 동시에 가서 데이터를 가져와야합니다.
        모든 대사관의 국가정보를 가져와야합니다.
        혹은 기준이 될만한 무언가를 가져와야합니다.
        이부분을 로딩화면에서 해도 될수 있겠습니다.
        밑의 fetchEmbassyList()메소드를 다른 곳으로 옴기셔서 하면 됩니다.
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

    @Override
    public void showDetail(JsonObject embassyJson) {
        Log.d(TAG, "showDetail() CALLED");
        /*
        위의 정보를 토대로 뷰를 전환해 주시면 됩니다.
        여기서 보여져야할 정보는 나중에 추가토록 하겠습니다.
        현재는 필요할 정보가 정확치 않아서 적지 않았습니다.
        만약 너무 길어진다면 밑에 private메소드를 하나 만들어서 추가 해주시기 바랍니다.
        이때 항상 로딩상태를 핸들러로 처리해주시기 바랍니다.
         */
        Log.d(TAG, "showDetail() DONE");
    }

    @Override
    public void setList(List<JsonObject> embassyJsonList) {
        Log.d(TAG, "setList() CALLED");
        /*
        위의 정보를 토대로 뷰를 전환해 주시면 됩니다.
        여기서 보여져야할 정보는 나중에 추가토록 하겠습니다.
        현재는 필요할 정보가 정확치 않아서 적지 않았습니다.
        만약 너무 길어진다면 밑에 private메소드를 하나 만들어서 추가 해주시기 바랍니다.
        이때 항상 로딩상태를 핸들러로 처리해주시기 바랍니다.
         */
        Log.d(TAG, "setList() DONE");
    }

    private void fetchEmbassyList(){
        Log.d(TAG, "fetchEmbassyList() CALLED");
        /*
        여기서 프레젠터를 부르세요
         */
        Log.d(TAG, "fetchEmbassyList() DONE");
    }
}
