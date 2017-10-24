package com.example.user.myapplication.presenter;

import android.util.Log;

import com.example.user.myapplication.interactor.TouristInteractor;
import com.example.user.myapplication.view.IEmbassyView;
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

public class EmbassyPresenter implements IEmbassyPresenter {
    private final String TAG = "Embassy Presenter";

    //생성시에 받게되는 View 객체입니다.
    private IEmbassyView view;
    //인터렉터
    private TouristInteractor touristInteractor;

    public EmbassyPresenter(IEmbassyView touristView) {
        /*
        ::주의::
        인터렉터를 무조건 싱글톤으로 전환해주시기 바랍니다.
         */
        touristInteractor = new TouristInteractor();
        this.view = view;
    }

    @Override
    public void fetchEmbassyList() {
        Log.d(TAG, "fetchEmbassyList() CALLED");
        /*
        인터렉터의 메소드를 호출하셔서 받은 값으로
        view의 메소드를 사용하세요!


        예제)
        이렇게 될건데 지금은 이거 안됩니다. 매개변수가 정해지지 않았습니다.
        view.setList(touristInteractor.fetchEmbassyList());
         */
        Log.d(TAG, "fetchEmbassyList() DONE");
    }

    @Override
    public void fetchEmbassyInfo() {
        Log.d(TAG, "fetchEmbassyInfo() CALLED");
        /*
        인터렉터의 메소드를 호출하셔서 받은 값으로
        view의 메소드를 사용하세요!


        예제)
        view.showDetail(touristInteractor.fetchEmbassyInfo());
         */
        Log.d(TAG, "fetchEmbassyInfo() DONE");
    }
}
