package com.example.user.myapplication.interactor;

import com.skp.Tmap.TMapData;
import com.skp.Tmap.TMapMarkerItem;
import com.skp.Tmap.TMapPoint;
import com.skp.Tmap.TMapPolyLine;
import com.skp.Tmap.TMapView;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by USER on 2017-10-16.
 */

public class DetailInteractor implements IDetailInteractor{
    private List<TMapMarkerItem> list;
    TMapPolyLine tMapPolyLine;
    TMapData tMapData;

    @Override
    public void checkEvent(String radioMsg, checkedBtnListener listener) {

    }

    @Override
    public void tMapInfo(TMapView tMapView) {
        tMapView.setSKPMapApiKey("19d9a144-6063-33ba-ab09-4af38c5add0d");
        tMapView.setLanguage(TMapView.LANGUAGE_KOREAN);
        //지도의 중심 위치좌표 - 없으면 기기의 현위치로 잡게됨(ex. 경찰서에 어플이 있다면 경찰서 위치)
        tMapView.setCenterPoint(126.8423617, 35.5025595);
        //tmapView.setIconVisibility(true);

        //위치1 마커
        TMapPoint point1 = new TMapPoint(35.5025595, 126.8423617);
        TMapMarkerItem markerItem1 = new TMapMarkerItem();
        markerItem1.setTMapPoint(point1);
        markerItem1.setVisible(TMapMarkerItem.VISIBLE);
        //tmapview.addMarkerItem("marker1", markerItem1);

        //위치2 마커
        TMapPoint point2 = new TMapPoint(35.509, 126.8423617);
        TMapMarkerItem markerItem2 = new TMapMarkerItem();
        markerItem2.setTMapPoint(point2);
        markerItem2.setVisible(TMapMarkerItem.VISIBLE);
        //tmapview.addMarkerItem("marker2", markerItem2);



        list = new ArrayList<TMapMarkerItem>();
        list.add(0,markerItem1);
        list.add(1,markerItem2);

        /*
        try {
            //tMapPolyLine = tMapData.findPathDataWithType(TMapData.TMapPathType.PEDESTRIAN_PATH, point1, point2, null, 0);
            tMapPolyLine = tMapData.findPathDataWithType(TMapData.TMapPathType.CAR_PATH, point1, point2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        */

        //지도에 마커 추가
        for(int i =0; i<list.size(); i++){
            tMapView.addMarkerItem("marker"+i, list.get(i));

        }

        //지도를 주어진 넓이와 높이에 맞게 줌레벨을 조정
        //마커가 많아지면 다시 해서 봐야할듯
        double latSpan = list.get(0).getPositionX() - list.get(1).getPositionX();
        double lonSpan = list.get(0).getPositionY() - list.get(1).getPositionY();
        tMapView.zoomToSpan(latSpan, lonSpan);

        tMapView.setZoomLevel(14);
        tMapView.setMapType(TMapView.MAPTYPE_STANDARD);
        //tmapview.setCompassMode(true);
        //화면 중심을 단말의 현재위치로 이동시켜주는 트래핑 모드 설정
        tMapView.setTrackingMode(false);
        //tMapView.addTMapPath(tMapPolyLine);
    }

}
