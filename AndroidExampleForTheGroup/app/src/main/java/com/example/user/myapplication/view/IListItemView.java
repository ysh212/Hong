package com.example.user.myapplication.view;

import com.example.user.myapplication.domain.Tourist;
import com.example.user.myapplication.domain.TouristInfo;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by USER on 2017-10-17.
 */

public interface IListItemView {

    //DetailActivity로 이동
    void navigateToDetail(TouristInfo touristInfo);

    //목록에 데이터 보여주기 - 주소, 거리, 언어,(+요청시간) - TouristInfo 클래스
    void showInfo(List<TouristInfo> touristInfo);

    void showFail();

    //목록에서 수행되어진 아이템을 리스트에서 삭제하기
    void deleteListItem(UUID uuid);

}
