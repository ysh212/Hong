package com.example.user.myapplication.interactor;

import android.util.Log;

import com.example.user.myapplication.domain.Tourist;
import com.example.user.myapplication.domain.TouristInfo;
import com.example.user.myapplication.service.BackgroundService;
import com.example.user.myapplication.service.TouristService;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 2017-10-17.
 */

public class ListItemInteractor implements IListItemInteractor{
    private TouristService touristService;

    public  ListItemInteractor(){
        touristService = new TouristService();
    }


    @Override
    public void nextActivity(TouristInfo touristInfo, onSelectListener listener) {
        //아이템이 체크 되었다면( >0 ), listener.onSuccess() 메소드 실행
        if (touristInfo != null){
            listener.onSuccess(touristInfo);
        }
    }

    @Override
    public void getItem(itemCallback callback) {
        //new Thread(new Runnable() {
          //  @Override
            //public void run() {
                try{
                    //touristService.setupTourist();
                    //TouristInfo info = touristService.setupTourist();
                    //List<TouristInfo> list = new ArrayList<>();
                    //list.add(loadTourist);

                    callback.onReceive(touristService.setupTourist());
                }catch (Exception e){
                    callback.onfFail(e);
                }
            //}
     //}).start();
    }

    @Override
    public void getUuid(uuidCallback callback) {
        try{
            callback.onUuid(touristService.onDutyItem());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
