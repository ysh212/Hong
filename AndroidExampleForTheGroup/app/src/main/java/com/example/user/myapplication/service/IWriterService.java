package com.example.user.myapplication.service;

import java.net.Socket;

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
interface IWriterService {

    /**
     * 연결을 시작하는 메소드입니다.
     * 이것이 퍼블릭인 이유는 인터렉터에서 사용해야할 상황이 발생할 가능성이 높아서 입니다.
     * 이 메소드로 연결이 존재하는지 확인을 먼저하고 없다면 생성하는것이 옳습니다.
     *
     * @return socket Socket을 리턴합니다
     */
    public Socket connect();


    /**
     * 서버에 JsonData를 보내는 메소드입니다.
     *
     * @param type 파이널 스태틱인 코드들 중 하나(상황에 맞는 걸로)
     * @param msg 전달되야하는 메세지
     */
    public void sendToServer(int type, String msg);


    /**
     * 연결을 해제한다는 메세지를 보내야할 메소드입니다.
     * 위와 같은 이유로 퍼블릭입니다
     * 여기서 소켓을 해제하지 않습니다
     * 서버 측에서 해제를 해야 메모리에서 해당 관광객을 제거하기가 쉽습니다
     */
    public void disconnect();
}
