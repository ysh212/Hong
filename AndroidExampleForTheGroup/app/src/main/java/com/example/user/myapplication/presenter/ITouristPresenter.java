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

interface ITouristPresenter {

    /**
     * TouristInteractor의 sentToServer(int type, String msg)를 호출하게 됩니다.
     * 그와 동시에 핸들러를 통해 전송중임을 알려주어야합니다.
     * 이때 뷰의 context를 이용해서 하면 되겠습니다.
     * 만약에 이것이 먼가 이상하다면 전송중임을 알리는 메소드는 따로 서비스를 생성하는것도 방법이긴합니다.
     *
     * @param type 파이널 스태틱인 코드들 중 하나(상황에 맞는 걸로)
     * @param msg 전달되야하는 메세지
     */
    public void sendToServer(int type, String msg);
}
