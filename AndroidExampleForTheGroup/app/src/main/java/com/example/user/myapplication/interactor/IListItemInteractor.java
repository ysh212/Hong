package com.example.user.myapplication.interactor;

import com.example.user.myapplication.domain.Tourist;
import com.example.user.myapplication.domain.TouristInfo;

import java.util.List;
import java.util.UUID;

/**
 * Created by USER on 2017-10-17.
 */

public interface IListItemInteractor {
    //커스텀리스트뷰에서 아이템이 선택되었을 때 발생하는 메소드 작성
    interface onSelectListener{
        void onSuccess(TouristInfo touristInfo);
    }

    //서비스에서 데이터가 들어올때마다 받아들이는 콜백메소드
    interface itemCallback{
        //데이터 받음 - 성공
        void onReceive(List<TouristInfo> touristInfo);

        //데이터 못받음 - 실패
        void onfFail(Exception e);
    }

    interface uuidCallback{
        //uuid 받음 - 성공
        void onUuid(UUID uuid);
    }

    //item이 클릭되면 다음 액티비티로 넘어감
    void nextActivity(TouristInfo touristInfo, onSelectListener listener);

    //데이터가 새로 들어오면 item을 가져오는 메소드
    public void getItem(itemCallback callback);

    public void getUuid(uuidCallback callback);

}
