package com.example.user.myapplication.presenter;


import com.example.user.myapplication.domain.Tourist;
import com.example.user.myapplication.domain.TouristInfo;

/**
 * Created by USER on 2017-10-17.
 */

public interface IListItemPresenter {

    //리스트 뷰에 보여줄 items들을 불러옴
    void loadRepositoryItems();

    //View에서 선택된 아이템의 위치를 나타냄
    void selectedItem(TouristInfo touristInfo);
}
