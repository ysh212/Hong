package com.team.seoul.gongmo;

import android.content.Context;
import android.location.LocationManager;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import com.team.seoul.gongmo.domain.Connected;
import com.team.seoul.gongmo.domain.Officer;
import com.team.seoul.gongmo.service.PhoneService;
import com.team.seoul.gongmo.socket.OfficerSocket;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String data1;
    OfficerSocket officerSocket;

    PhoneService phoneService = new PhoneService();
    Spinner officeSpinner;

    Officer officer = new Officer();
    List<String> lang;

    CheckBox englishCh;
    CheckBox chineseCh;
    CheckBox japaneseCh;

    Button completeBtn;
    Button cancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("첫 화면");

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //스레드를 통해서 소켓의 ip, port 설정
        //어플리케이션이 시작되자마자 소켓 연결
        officerSocket = new OfficerSocket();
        officerSocket.startConnect();

        final String [] office = {"관광경찰", "소방서", "보건소", "대사관", "우체국"};
        officeSpinner = (Spinner)findViewById(R.id.spinner);

        //drop 박스 형태로 관공서들을 보여주기
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, office);
        officeSpinner.setAdapter(adapter);

        englishCh = (CheckBox)findViewById(R.id.englishCh);
        chineseCh = (CheckBox)findViewById(R.id.chineseCh);
        japaneseCh = (CheckBox)findViewById(R.id.japaneseCh);

        completeBtn = (Button)findViewById(R.id.completeBtn);
        cancelBtn = (Button)findViewById(R.id.cancelBtn);

        //LocationManager 객체 가져오기 - 위치 관리자 객체
        final LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        //위치 제공자 모두 가져오기
        List<String> locationList = locationManager.getAllProviders();



        //완료버튼을 눌렀을 때 실행되는 내용
        //완료 버튼을 누르면 서버로 데이터를 보내고(send),
        // 그 이후에 서버로부터 오는 데이터를 전송 받는다(receive).
        completeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                lang = new ArrayList<>();

                if(englishCh.isChecked()==true){
                    lang.add(englishCh.getText().toString());

                    //langMap.put("english", englishCh.getText().toString());
                }
                if(chineseCh.isChecked()==true){
                    lang.add(chineseCh.getText().toString());

                    //langMap.put("chinese", chineseCh.getText().toString());
                }
                if(japaneseCh.isChecked()==true){
                    lang.add(japaneseCh.getText().toString());

                    //langMap.put("japanese", japaneseCh.getText().toString());
                }
                //접수측이 사용가능한 언어를 officer 객체에 저장
                officer.setLang(lang);
                //접수측 위치
                //gps를 이용해서 위도 경도 값 가져오기 - 아래는 예시로 값 넣어서 전송되는지 확인
                officer.setLon(12.1);
                officer.setLat(20.2);

                //접수측 폰 번호
                String myNum = phoneService.getDeviceNum(getApplicationContext());
                officer.setPhoneNum(myNum);
                //접수측 UUID
                //String myUUID = phoneService.getDeviceUUID(getApplicationContext());
                //officer.setOfficerUUID(myUUID);

                //서버로 데이터 보내기
                officerSocket.send(officer);

                //서버로부터 데이터 받기


                //체크박스에 체크가 하나라도 되어있다면 다른 activity로 넘어가기
                if(lang.size() > 0){
                    for(String imsi : lang) {
                        Toast alarm = Toast.makeText(MainActivity.this, imsi, Toast.LENGTH_SHORT);
                        alarm.show();
                    }
                    //다음 화면으로 보낼 class를 두번째 매개변수에 넣어주기
                    //Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    //startActivity(intent);
                }
                //체크박스에 체크가 하나라도 되어있지 않다면, Toast로 경고문구 보여주기
                else{
                    Toast alarm = Toast.makeText(MainActivity.this, "체크박스에 체크해주세요.", Toast.LENGTH_SHORT);
                    alarm.show();
                }

            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //첫 화면에 있는 입력된 값 or 체크된 값을 초기화하기 - 임시로 만들어 둔거고 바꿔야함
                //Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                //startActivity(intent);
            }
        });

    }
}
