package com.example.user.myapplication.service;

import android.util.Log;

import com.google.gson.JsonObject;

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

public class WriterService implements IWriterService {
    private final String TAG = "Writer Service";


    @Override
    public Socket connect() {
        Log.d(TAG, "connect() CALLED");
        /*
        여기서 만드는 소켓은 항상 기억하도록 해야합니다.
        신고가 끝이나고 서버쪽에서 소켓을 끈을때까지
        기억할 수 있도록 처리하셔야합니다.
        생성과 동시에 sendToServer를 사용해야하는데 이전에 우선 BackgroundService를 시작해야합니다.
        이때 인텐트를 필요로하는데 context부분때문에 애매합니다.
        제가 볼때 이런경우에는 어쩔수 없이 프레젠터까지 가야하지 않나 생각합니다.
        하다가 더 좋은 방법이 생각나면 그때 바꾸면 되겠습니다.

        여기서 try catch 해주시고
        IOException시에 문제없이 매끄럽게 진행되도록 Socket을 널로 바꾸어버리세요
        그리고 tourist 정보를 지워버리는것도 나쁘지 않은것 같습니다.
         */
        Log.d(TAG, "connect() -> "+ "여기에 리턴값을 넣어주세요");
        return null;
    }

    @Override
    public void sendToServer(int type, String msg) {
        Log.d(TAG, "sendToServer() CALLED");
        /*
        서버에 어떤 메세지든 보낼 수 있도록 만드시면 됩니다.
        이때 Tourist 객체를 탑제해서 보내야합니다.
        이 Tourist객체는 글로벌에서 있는지 없는지 확인하고서
        없다면 TouristService를 불러서 만들어주고
        있다면 그냥 그 Tourist 객체를 사용하면 됩니다.
         */
        Log.d(TAG, "sendToServer() DONE");
    }

    @Override
    public void disconnect() {
        Log.d(TAG, "disconnect() CALLED");
        /*
        서버에 연결을 끈겠다는 메세지를 보내야합니다.
        위의 메소드호출해서 써도 됩니다.
         */
        Log.d(TAG, "disconnect() DONE");
    }

    /**
     * 전달할 데이터를 Json형태로 바꿉니다
     * 여기서 사용한 패키지는 Gson입니다.
     * 구글에 올려둔 문서 참조 (기본적으로 약속된 코드들)
     * private인 이유는 여기서만 사용될 예정이라 그렇습니다.
     *
     * @param type 파이널 스태틱인 코드들 중 하나(상황에 맞는 걸로)
     * @param msg 전달되야하는 메세지
     * @return dataJson JsonObject인 제이손데이터
     */
    private JsonObject getDataJson(int type, String msg) {
        JsonObject dataJson = new JsonObject();
        /*
         * 이곳에 로직을 입력해주세요
         */
        return dataJson;
    }
}
