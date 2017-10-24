package com.example.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.myapplication.domain.Tourist;
import com.example.user.myapplication.domain.TouristInfo;
import com.example.user.myapplication.presenter.DetailPresenter;
import com.example.user.myapplication.presenter.IDetailPresenter;
import com.example.user.myapplication.view.IDetailView;
import com.skp.Tmap.TMapData;
import com.skp.Tmap.TMapPoint;
import com.skp.Tmap.TMapPolyLine;
import com.skp.Tmap.TMapView;

import org.xml.sax.SAXException;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;


/**
 * Created by USER on 2017-10-16.
 */

public class DetailActivity extends AppCompatActivity implements IDetailView{

    private Button checkBtn, cancelBtn;
    TextView detailContents;
    Spinner spinner;
    TMapView tMapView;


    private IDetailPresenter detailPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //확인 버튼
        checkBtn = (Button) findViewById(R.id.checkBtn);
        //취소 버튼
        cancelBtn = (Button) findViewById(R.id.cancelBtn);
        //ListItem 목록에서 선택된 항목에 대한 상세정보를 출력
        detailContents = (TextView) findViewById(R.id.detailContents);

        //자동차를 타고 갈지, 도보로 갈지 정함
        spinner = (Spinner) findViewById(R.id.spinner);
        final String [] trans ={"자가용", "도보"};
        //drop 박스 형태로 관공서들을 보여주기
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, trans);
        spinner.setAdapter(adapter);


        tMapView = (TMapView) findViewById(R.id.tMap);

        detailPresenter = new DetailPresenter(this);
        detailPresenter.loadMap(tMapView);
        detailPresenter.getInfo();

        /*
        tMapPoint1 = new TMapPoint(35.5025595, 126.8423617);
        tMapPoint2 = new TMapPoint(35.509, 126.8423617);
        //자동차 경로 요청- 매개변수(이동수단, 출발지 좌표, 도착지좌표, 탐색옵션(교통최적 + 추천(기본값)))
        try {
            tMapPolyLine = tMapData.findPathDataWithType(TMapData.TMapPathType.CAR_PATH, tMapPoint1, tMapPoint2, null, 0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        */
        //보행자 경로 요청
        //tMapPolyLine = tMapData.findPathDataWithType(TMapData.TMapPathType.PEDESTRIAN_PATH, point1, point2, 0);


        //확인 버튼 누르면 서버로 데이터 전송
        checkBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });

        //취소 버튼 누르면 이전 페이지로 이동
        cancelBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void detailContents() {
        Intent intent = getIntent();
        TouristInfo touristInfo = (TouristInfo)intent.getSerializableExtra("selectedItem");
        detailContents.setText("주소: " + touristInfo.getAddress() + ", 거리: " + touristInfo.getDistance() + ", 언어: " + touristInfo.getTourist().getLang());
    }

    @Override
    public void loadMap() {

    }

    @Override
    public void addTourist() {

    }

    @Override
    public void removeTourist() {

    }
}
