package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.example.user.myapplication.presenter.MainPresenter;
import com.example.user.myapplication.view.IMainView;

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
 * 로딩후에 바로 넘어오는 메인 액티비티입니다.
 * 이 액티비티는 앱이 완전히 종료될때까지는 finish()되어서는 안됩니다.
 *
 */
public class MainActivity extends AppCompatActivity implements IMainView {
    private final String TAG = "Main Activity";

    //프레젠터 create에서 생성
    private MainPresenter mainPresenter;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "created");

        /*
         * 이건 밑의 온클릭리스너를 어떻게 사용해야하는지 예제입니다.
         * button.setOnClickListener(touristBtnClick);
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

/* =============================================================================
 *      OnClickListener
 */

    /**
     * Tourist Police 버튼을 눌렀을시에 할 내용
     */
    private View.OnClickListener touristBtnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(TAG, "tourist button clicked");
            /*
             * 로직 부분
             * 인텐트를 생성하고 액티비티를 시작한다
             * 이때 신고 여부를 확인합니다.
             */
        }
    };

    /**
     * Location 버튼을 눌렀을시에 할 내용
     */
    private View.OnClickListener locationBtnClick= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        Log.d(TAG, "location button clicked");

            /*
             * 위와 같은 접근
             */
        }
    };

    /**
     * Visit Korea 버튼을 눌렀을시에 할 내용
     */
    private View.OnClickListener visitKoreaBtnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(TAG, "visit korea button clicked");
            /*
             * 다른 앱을 열어서 웹사이트로 연결해주어야합니다
             */
        }
    };

    /**
     * embassies 버튼을 눌렀을시에 할 내용
     */
    private View.OnClickListener embassiesBtnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(TAG, "embassies button clicked");
            /*
             * embassies액티비티로 넘겨주세요
             */
        }
    };

/* =============================================================================
 *      뷰에 영향을 줄수도 있는 메소드들입니다
 */

    /**
     * 도움말을 키는 메소드입니다.
     * 도움말을 보여줄 뷰를 생성하고 보여줘야 할겁니다.
     * 퍼블릭인 이유는 이 메소드를 프레젠터에서 불러야할 수도 있어서 입니다.
     */
    @Override
    public void showHelp() {

    }

    /**
     * 도움말을 끄는 메소드입니다.
     * 위에서 보여준 뷰를 제거해야 할겁니다.
     * 위와 같은 이유로 퍼블릭입니다.
     */
    @Override
    public void closeHelp() {

    }
}
