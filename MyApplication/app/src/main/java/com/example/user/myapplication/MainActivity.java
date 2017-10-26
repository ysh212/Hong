package com.example.user.myapplication;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.myapplication.domain.LocationDto;
import com.skp.Tmap.TMapData;
import com.skp.Tmap.TMapGpsManager;
import com.skp.Tmap.TMapMarkerItem;
import com.skp.Tmap.TMapPOIItem;
import com.skp.Tmap.TMapPoint;
import com.skp.Tmap.TMapPolyLine;
import com.skp.Tmap.TMapView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity implements TMapGpsManager.onLocationChangedCallback{
    TMapView tmapview;
    List<TMapMarkerItem> list;
    TextView textView6;
    TextView textView7;
    TMapData tMapData = new TMapData();
    private boolean m_bTrackingMode = true;
    private TMapGpsManager tmapgps = null;
    TMapPolyLine tMapPolyLine;
    TMapPoint changePoint = null;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            runtime_permissions();

            textView6 = (TextView) findViewById(R.id.textView6);
            textView7 = (TextView) findViewById(R.id.textView7);
            //tmapview = new TMapView(this);
            tmapview = (TMapView)findViewById(R.id.tMap);
            //tmapview.setLayoutParams(params);

        tmapview.setSKPMapApiKey("19d9a144-6063-33ba-ab09-4af38c5add0d");
        tmapview.setLanguage(TMapView.LANGUAGE_KOREAN);
        //지도의 중심 위치좌표 - 없으면 기기의 현위치로 잡게됨(ex. 경찰서에 어플이 있다면 경찰서 위치)
        //tmapview.setCenterPoint(126.8423617, 35.5025595);

            // 주소 변경 - (위도, 경도) -> 주소로 변경
/*
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    String address = null;
                    try {
                    //임의의 위도, 경도 값
                        address = tMapData.convertGpsToAddress(37.574515,126.976930);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ParserConfigurationException e) {
                        e.printStackTrace();
                    } catch (SAXException e) {
                        e.printStackTrace();
                    }
                    textView6.setText(address);
                }
            };
            Thread thread = new Thread(r);
            thread.start();
*/
            tmapgps = new TMapGpsManager(MainActivity.this);
            tmapgps.setMinTime(1000);
            tmapgps.setMinDistance(5);
            tmapgps.setProvider(tmapgps.NETWORK_PROVIDER); //연결된 인터넷으로 현 위치를 받음, 실내일때 유용
            //gps로 현 위치를 잡음
            //tmapgps.setProvider(tmapgps.GPS_PROVIDER);
            //위치 탐색을 시작
            tmapgps.OpenGps();

            tmapview.setIconVisibility(true);

            //신고가 온 위치에 마커 표시
            //addMarker();

            //위치1 마커 - 서울역
            /*
            final TMapPoint point1 = new TMapPoint(37.555107, 126.970691);
            TMapMarkerItem markerItem1 = new TMapMarkerItem();
            markerItem1.setTMapPoint(point1);
            markerItem1.setVisible(TMapMarkerItem.VISIBLE);
            //tmapview.addMarkerItem("marker1", markerItem1);

            //위치2 마커 - 강남역
            final TMapPoint point2 = new TMapPoint(37.498206, 127.027610);
            TMapMarkerItem markerItem2 = new TMapMarkerItem();
            markerItem2.setTMapPoint(point2);
            markerItem2.setVisible(TMapMarkerItem.VISIBLE);
            //tmapview.addMarkerItem("marker2", markerItem2);


            list = new ArrayList<TMapMarkerItem>();
            list.add(0,markerItem1);
            list.add(1,markerItem2);

            //지도에 마커 추가
            for(int i =0; i<list.size(); i++){
                tmapview.addMarkerItem("marker"+i, list.get(i));
            }

            //지도를 주어진 넓이와 높이에 맞게 줌레벨을 조정
            //마커가 많아지면 다시 해서 봐야할듯
            //double latSpan = list.get(0).getPositionX() - list.get(1).getPositionX();
            //double lonSpan = list.get(0).getPositionY() - list.get(1).getPositionY();
            //tmapview.zoomToSpan(latSpan, lonSpan);
            */



            //줌레벨
            tmapview.setZoomLevel(14);
            tmapview.setMapType(TMapView.MAPTYPE_STANDARD);
            //현재보는 방향
            tmapview.setCompassMode(true);
            //화면 중심을 단말의 현재위치로 이동, 화면 중심을 단말의 현재위치로 이동시켜주는 트래핑 모드 설정
            tmapview.setTrackingMode(true);
            tmapview.setSightVisible(true);
        }

    //마커에 위치 부여하는 메소드
    public void addMarker(){
        //위도
        double latitude = 126.8423617;
        //경도
        double longitude = 35.5025595;
        //TMapPoint 생성자는 위도, 경도 위치 다름..쓰레기같음ㅡㅡ
        TMapPoint point = new TMapPoint(longitude, latitude);
        //마커 만들기 위한 객체생성
        TMapMarkerItem markerItem = new TMapMarkerItem();
        markerItem.setTMapPoint(point);
        markerItem.setVisible(TMapMarkerItem.VISIBLE);
        tmapview.addMarkerItem("marker", markerItem);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch(requestCode) {
            case 1:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_SHORT).show();
                    //enable_buttons();
                    //do ur specific task after read phone state granted
                } else {
                    Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_SHORT).show();
                }
                return;
        }
    }

    private boolean runtime_permissions() {
        // sdk버전이 23 이하이면 checking이 필요없음
        if (Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.READ_PHONE_STATE}, 1 );
            // permission 을 물었다면
            return true;
        }
        // permission checking 이 필요없다면
        return false;
    }
    //위치 변경시 마다 위치 값 반환환

   @Override
    public void onLocationChange(Location location) {
        if(m_bTrackingMode){
            tmapview.setLocationPoint(location.getLongitude(), location.getLatitude());
            tmapview.setCenterPoint(location.getLongitude(), location.getLatitude());
            Double lon = location.getLongitude();
            Double lat = location.getLatitude();
            Log.d("lon", lon.toString());
            changePoint = new TMapPoint(lat, lon);

            Runnable r1 = new Runnable() {
                @Override
                public void run() {
                    try {
                        Log.d("current123", changePoint.toString());
                        final TMapPoint point2 = new TMapPoint(37.259701, 127.078830);
                        tMapPolyLine = tMapData.findPathDataWithType(TMapData.TMapPathType.CAR_PATH, changePoint, point2, null, 0);

                        Document doc = tMapData.findPathDataAll(changePoint, point2);
                        String name = pasreXML(doc);
                        //String lat = String.valueOf(point1.getLatitude());
                        Log.d("name", name);

                        textView7.setText(name);

                        //tMapPolyLine.addLinePoint(point1);
                        //tMapPolyLine.addLinePoint(point2);
                        //locationDto.setDistance(tMapPolyLine.getDistance());
                        //textView7.setText(locationDto.toString());
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    tmapview.addTMapPath(tMapPolyLine);
                }
            };
            Thread th = new Thread(r1);
            th.start();
        }
    }

    //document parse할 메소드
    private String pasreXML(Document document) {
        String result = null;
        Element root = document.getDocumentElement();

        NodeList nodeListPlacemark = root.getElementsByTagName("Document");
        for (int i =0; i<nodeListPlacemark.getLength(); i++){
            NodeList nodeListDocumentItem = nodeListPlacemark.item(i).getChildNodes();
            for(int j=0; j<nodeListDocumentItem.getLength();j++){
                if(nodeListDocumentItem.item(j).getNodeName().equals("tmap:totalDistance")){
                    result = nodeListDocumentItem.item(j).getTextContent().trim();
                }
            }
        }
        return result;
    }

}
