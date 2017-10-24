package com.example.user.myapplication.service;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by USER on 2017-09-18.
 */

//사용자 기기별 token을 생성하는 클래스
public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService{
    private static final String TAG = "MyFirebaseIIDService";

    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is called when the InstanceID token
     * is initially generated so this is where you would retrieve the token.
     */
    // [START refresh_token]
    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.

        //생성 등록된 토큰을 개인 앱서버에 보내 저장해 두었다가 추가로 뭔가를 하고 싶으면 사용하도록 한다.
        sendRegistrationToServer(refreshedToken);
    }
    // [END refresh_token]

    /**
     * Persist token to third-party servers.
     *
     * Modify this method to associate the user's FCM InstanceID token with any server-side account
     * maintained by your application.
     *
     * @param token The new token.
     */

      //server에 생성된 토큰을 등록하기 위해, 생성후 바로 보낼 때 활용하는 메소드드
      private void sendRegistrationToServer(String token) {
      // TODO: Implement this method to send token to your app server.
          Log.d(TAG,"new token: " + token);

          //HttpURLConnection 방법 사용
          HttpURLConnection connection;

          try{
              URL url = new URL("서버 주소");
              connection = (HttpURLConnection)url.openConnection();
              //서버에 데이터 보낼 때, post의 경우
              connection.setDoOutput(true);
              //서버에서 데이터 가져올 때
              connection.setDoInput(true);
              //post 방식
              connection.setRequestMethod("POST");

              //Token 값을 서버에 보내기
              StringBuffer buffer = new StringBuffer();
              //형식은 맞춰서 바꿔주면 된다.
              buffer = buffer.append("Token").append("=").append(token);
              OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
              osw.write(buffer.toString());
              osw.flush();
              osw.close();

              //서버에서 값을 받아오는 경우... 필요없지만 작성
              BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
              StringBuffer sb = new StringBuffer();
              String line = null;
              while((line = br.readLine())!=null){
                  sb.append(line);
              }
              connection.disconnect();


          }catch (Exception e){

          }
      }

}

