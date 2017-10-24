package com.example.user.myapplication.service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.user.myapplication.MainActivity;
import com.example.user.myapplication.R;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by USER on 2017-09-18.
 */

public class MyFirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {
    private static final String TAG = "MyFirebaseMsgService";

        //private String msg;

        /**
        * Called when message is received.
        *
        * @param remoteMessage Object representing the message received from Firebase Cloud Messaging.
        */

        // [START receive_message]
        @Override
        public void onMessageReceived (RemoteMessage remoteMessage){
            // [START_EXCLUDE]
            // There are two types of messages data messages and notification messages. Data messages are handled
            // here in onMessageReceived whether the app is in the foreground or background. Data messages are the type
            // traditionally used with GCM. Notification messages are only received here in onMessageReceived when the app
            // is in the foreground. When the app is in the background an automatically generated notification is displayed.
            // When the user taps on the notification they are returned to the app. Messages containing both notification
            // and data payloads are treated as notification messages. The Firebase console always sends notification
            // messages. For more see: https://firebase.google.com/docs/cloud-messaging/concept-options
            // [END_EXCLUDE]

            // TODO(developer): Handle FCM messages here.
            // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
            Log.d(TAG, "From: " + remoteMessage.getFrom());

            //우리는 data payload 방식을 사용할 것임
            // Check if message contains a data payload.
            if (remoteMessage.getData().size() > 0) {
                Log.d(TAG, "Message data payload: " + remoteMessage.getData());
                /*
                //JSONObject("...") 에 서버에서는 보내주는 데이터가 들어가면 될듯?
                //JSON 객체 생성
                //latitude(위도), longitude(경도)

                try {
                    JSONObject jsonObject = new JSONObject("");
                    Double latitude = jsonObject.getDouble("latitude");
                    Double longitude = jsonObject.getDouble("longitude");
                }catch(JSONException e){
                    e.printStackTrace();
                }
                */

                //서버로부터 데이터 전달받기 - 위도, 경도 값
                sendNotification(remoteMessage);
            }

            //우리는 data payload 방식을 사용할 것임 - 따라서 일단은 설정 안함
            // Check if message contains a notification payload.
            if (remoteMessage.getNotification() != null) {
                Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
            }

            //msg = remoteMessage.getNotification().getBody();


            // Also if you intend on generating your own notifications as a result of a received FCM
            // message, here is where that should be initiated. See sendNotification method below.

            // [END receive_message]
        }

        public void sendNotification(RemoteMessage locationMsg){
            //latitude(위도), longitude(경도) 데이터를 서버로부터 받기
            String latitude = locationMsg.getData().get("latitude");
            String longitude = locationMsg.getData().get("longitude");

            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                    new Intent(this, MainActivity.class), 0);

            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
            mBuilder.setSmallIcon(R.mipmap.ic_launcher);
            mBuilder.setContentTitle("알림이 도착했습니다.");
            mBuilder.setContentText("위도: " + latitude +", "+"경도: " + longitude);
            mBuilder.setAutoCancel(true);
            mBuilder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
            mBuilder.setVibrate(new long[]{1, 1000});

            NotificationManager notificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            notificationManager.notify(0 /* ID of notification */, mBuilder.build());

            mBuilder.setContentIntent(contentIntent);
        }

    }

