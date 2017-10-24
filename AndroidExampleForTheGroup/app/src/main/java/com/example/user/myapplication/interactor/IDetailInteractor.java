package com.example.user.myapplication.interactor;

import com.skp.Tmap.TMapView;

/**
 * Created by USER on 2017-10-16.
 */

public interface IDetailInteractor {
    interface checkedBtnListener{

        //이벤트 성공시
        void onSuccess();

    }

    void checkEvent(String radioMsg, checkedBtnListener listener);

    void tMapInfo(TMapView tMapView);

}
