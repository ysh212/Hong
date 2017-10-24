package com.example.user.myapplication.view;

/** by Hong Ji Hoon aka Hongvyo on github,
 *  Kim Eun Hye,
 *  Kim Min Ji,
 *  Kwon Soon Jo,
 *  Yu Seok Hwan
 *
 * 2017 september
 * submission to the Seoul App Competition held by the Seoul City Government.
 * copyright: MIT License
 */

import com.google.gson.JsonObject;

import java.util.List;

/**
 * 이 인터페이스는 프레젠터에서 사용될 즉 기타 다른 메소드들을 빼고
 * 정말 프레젠터에서만 사용될 메소드들을 모아둔 인터페이스입니다.
 * 이렇게하고 액티비티가 이 뷰를 implement하게 하고
 * 이 인터페이스인 뷰 객체를 프레젠터에서 받아서 사용하게 됩니다.
 */
public interface IEmbassyView {

    /**
     * 프레젠터에서 불려질 디테일 보여주기입니다.
     * 우선은 JsonObject를 매개변수로 두었는데
     * 매우 안좋습니다. 그냥 DTO로 바꿀까합니다.
     * 우선 API위치를 찾을수 없어서 이렇게 하였습니다.
     *
     * @param embassyJson JsonObject
     */
    public void showDetail(JsonObject embassyJson);


    /**
     * 프레젠터에서 불려질 select 데이터 보여주기입니다.
     * 여기서도 고민되고 있는 부분은
     * 이 로직을 로딩시에 불러서 미리 셀렉트를 준비해두는 것이 좋은지
     * 아니면 뷰가 준비 될때 하는게 좋은지 잘 모르겠습니다.
     *
     * @param embassyJsonList 리스트를 받아서 select를 채워주시면 되겠습니다.
     */
    public void setList(List<JsonObject> embassyJsonList);
}
