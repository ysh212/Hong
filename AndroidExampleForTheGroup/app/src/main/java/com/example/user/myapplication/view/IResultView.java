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

import com.example.user.myapplication.domain.Officer;

/**
 * 이 인터페이스는 프레젠터에서 사용될 즉 기타 다른 메소드들을 빼고
 * 정말 프레젠터에서만 사용될 메소드들을 모아둔 인터페이스입니다.
 * 이렇게하고 액티비티가 이 뷰를 implement하게 하고
 * 이 인터페이스인 뷰 객체를 프레젠터에서 받아서 사용하게 됩니다.
 */
public interface IResultView {

    /**
     * 현 상황을 뷰에 적용시키는 메소드입니다.
     * type에 따라서 보여지게 될 텍스트를 바꾸어 주시면됩니다.
     * 혹은 다른 매개변수로 바꾸셔서 사용해도됩니다.
     * 관광객에게 지금 현재 신고 상태를 보여주기 위함입니다.
     */
    public void statusChange(int type);


    /**
     * 현 상황을 뷰에 적용시키는 메소드입니다.
     * 만약에 진행이 빠르다면 이부분을 좀더 가공해서 더 나은 상태로 만들수 있습니다.
     * 아마 지도까지도 가능할 듯 합니다.
     *
     * @param officer 배정받은 오피서 정보입니다.
     */
    public void officerAssigned(Officer officer);
}
