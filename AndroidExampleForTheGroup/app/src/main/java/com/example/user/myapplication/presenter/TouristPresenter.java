package com.example.user.myapplication.presenter;

import android.util.Log;

import com.example.user.myapplication.interactor.TouristInteractor;
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

public class TouristPresenter implements ITouristPresenter {
    private final String TAG = "Tourist Presenter";

    //생성시에 받게될 View입니다.
    private ITouristView view;
    //인터렉터입니다.
    private TouristInteractor touristInteractor;

    public TouristPresenter(ITouristView touristView) {
        /*
        ::주의::
        인터렉터를 무조건 싱글톤으로 전환해주시기 바랍니다.
         */
        touristInteractor = new TouristInteractor();
        this.view = view;
    }

    @Override
    public void sendToServer(int type, String msg) {
        Log.d(TAG, "sendToServer() CALLED");
        touristInteractor.sendToServer(type, msg);
    }
}
