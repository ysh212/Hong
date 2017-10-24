package com.example.user.myapplication;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.myapplication.domain.ListViewAdapter;
import com.example.user.myapplication.domain.Tourist;
import com.example.user.myapplication.domain.TouristInfo;
import com.example.user.myapplication.presenter.ListItemPresenter;
import com.example.user.myapplication.view.IListItemView;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by USER on 2017-10-17.
 */

public class ListItemActivity extends AppCompatActivity implements IListItemView{

    private ListItemPresenter listItemPresenter;
    //리스트뷰 레이아웃
    ListView listView;
    //어댑터 데이터
    private ListViewAdapter listViewAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        listItemPresenter = new ListItemPresenter(this);
        Log.d("come: ", "where1");
        //View를 먼저 설정해야 돼...(커스텀리스트뷰)
        listItemPresenter.loadRepositoryItems();
        Log.d("come: ", "where2");


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TouristInfo item = (TouristInfo) parent.getItemAtPosition(position);
                /*
                String location = item.getLocation();
                String distance = item.getDistance();
                String language = item.getLang();
                Date requestTime = item.getRequestTime();

                //클릭된 이벤트를 Toast로 보여주기 - 제대로 작동하는지 확인용일 뿐
                Toast.makeText(ListItemActivity.this, location, Toast.LENGTH_SHORT).show();

                */
                //클릭된 아이템
                listItemPresenter.selectedItem(item);
            }
        });

    }

    @Override
    public void navigateToDetail(TouristInfo touristInfo) {
        //Tourist 객체 전달을 위해 Tourist 클래스를 Serializable 인터페이스 구현.
        Intent intent = new Intent(ListItemActivity.this, DetailActivity.class);
        intent.putExtra("selectedItem", touristInfo);
        startActivity(intent);
        //startActivity(new Intent(ListItemActivity.this, DetailActivity.class));
    }

    @Override
    public void showInfo(List<TouristInfo> touristInfo) {
        //어댑터 객체 생성
        listViewAdapter = new ListViewAdapter();
        listView = (ListView) findViewById(R.id.listview1);

        listViewAdapter.addItem(touristInfo);

        listView.setAdapter(listViewAdapter);
    }

    @Override
    public void showFail() {
        Toast.makeText(ListItemActivity.this, "실패", Toast.LENGTH_SHORT).show();
    }

}


