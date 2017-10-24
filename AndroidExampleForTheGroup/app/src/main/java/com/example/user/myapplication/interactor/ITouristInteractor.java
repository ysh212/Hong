package com.example.user.myapplication.interactor;

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

import com.example.user.myapplication.domain.Officer;

import java.util.List;
import java.util.Map;

/**
 * 이 인터렉터는 동기화로 움직이면서 서비스들과 소통하게될 클래스의 부모입니다.
 */
interface ITouristInteractor {

    /**
     * WriterService를 불러서 (싱글톤으로 구현해도되고 안해도 됩니다.)
     *
     *
     * @param type 파이널 스태틱인 코드들 중 하나(상황에 맞는 걸로)
     * @param msg 전달되야하는 메세지
     */
    public void sendToServer(int type, String msg);


    /**
     * 모든 대사관 정보를 리턴합니다. 맵의 리스트인 상태 혹은 JsonObject가 될 가능성이 있습니다.
     *
     * @return list
     */
    public List<Map> fetchEmbassyList();

    /**
     * 하나의 대사관 정보를 리턴합니다.
     * 매개변수가 하나 있어야하는데 지금 아직 api가 어떤 값을 리턴하는지를 몰라서 쓰지 않았습니다.
     */
    public String fetchEmbassyInfo();


    /**
     * BackgroundService에서 ListeningService를 통해
     * Result프레젠터를 호출할 메소드입니다.
     * 듣기 서비스에서 처리된 결과에 따라 전달 받게 됩니다.
     */
    public void statusChange();



    public void officerAssigned(Officer officer);
}
