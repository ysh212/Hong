package com.example.user.myapplication.presenter;

import com.skp.Tmap.TMapView;

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

public interface IDetailPresenter {

    /**
     * 현위치를 기반으로 지도를 보여줍니다.
     */
    public void loadMap(TMapView tMapView);

    //확인 버튼 클릭하면 서버로 데이터 전송
    public void sendToServer();

    //커스텀뷰에서 선택된 아이템에 대한 정보를 보여줌
    public  void getInfo();
}
