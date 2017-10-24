package com.example.user.myapplication.presenter;

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


import android.content.Intent;

import com.example.user.myapplication.interactor.DetailInteractor;
import com.example.user.myapplication.interactor.IDetailInteractor;
import com.example.user.myapplication.view.IDetailView;
import com.skp.Tmap.TMapView;

/**
 * 여기서 TMAP이나 그냥 지도를 사용해야 할것 같습니다.
 *
 */
public class DetailPresenter implements IDetailPresenter, IDetailInteractor.checkedBtnListener{

    IDetailView detailView;
    IDetailInteractor detailInteractor;


    public DetailPresenter(IDetailView detailView){
        this.detailView = detailView;
        detailInteractor = new DetailInteractor();

    }


    @Override
    public void loadMap(TMapView tMapView) {
        /*
        인터렉터를 부르세요
         */
        detailInteractor.tMapInfo(tMapView);

    }

    @Override
    public void sendToServer() {

    }

    @Override
    public void getInfo() {

        detailView.detailContents();
    }


    @Override
    public void onSuccess() {

    }

}
