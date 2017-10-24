package com.example.user.myapplication.presenter;

import com.example.user.myapplication.domain.Tourist;
import com.example.user.myapplication.domain.TouristInfo;
import com.example.user.myapplication.interactor.IListItemInteractor;
import com.example.user.myapplication.interactor.ListItemInteractor;
import com.example.user.myapplication.view.IListItemView;

import java.util.List;

/**
 * Created by USER on 2017-10-17.
 */

public class ListItemPresenter implements IListItemPresenter, IListItemInteractor.onSelectListener {
    IListItemView listItemView;
    IListItemInteractor listItemInteractor;


    public ListItemPresenter(IListItemView listItemView){
        this.listItemView = listItemView;
        listItemInteractor = new ListItemInteractor();
    }

    @Override
    public void loadRepositoryItems() {
        //인터렉터를 이용해서 서비스로 접근

        listItemInteractor.getItem(new IListItemInteractor.itemCallback() {
            @Override
            public void onReceive(List<TouristInfo> touristInfo) {
                //가져온 아이템을 뷰에 갱신
                listItemView.showInfo(touristInfo);
            }

            @Override
            public void onfFail(Exception e) {
                listItemView.showFail();
            }
        });

    }

    @Override
    public void selectedItem(TouristInfo touristInfo) {
        listItemInteractor.nextActivity(touristInfo, this);
    }

    @Override
    public void onSuccess(TouristInfo touristInfo) {
        if (listItemView != null){
            listItemView.navigateToDetail(touristInfo);
        }
    }
}
