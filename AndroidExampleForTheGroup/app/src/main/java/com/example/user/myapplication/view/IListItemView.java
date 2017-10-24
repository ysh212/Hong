package com.example.user.myapplication.view;

import com.example.user.myapplication.domain.Tourist;
import com.example.user.myapplication.domain.TouristInfo;

import java.util.Date;
import java.util.List;

/**
 * Created by USER on 2017-10-17.
 */

public interface IListItemView {

    //DetailActivity로 이동
    void navigateToDetail(TouristInfo touristInfo);

    //목록에 데이터 보여주기 - 주소, 거리, 언어,(+요청시간) - TouristInfo 클래스
    void showInfo(List<TouristInfo> touristInfo);

    void showFail();

}
