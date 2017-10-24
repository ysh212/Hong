package com.example.user.myapplication.presenter;

import com.example.user.myapplication.domain.Officer;

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

interface IResultPresenter {

    /**
     * 뷰의 statusChange() 메소드를 사용할 메소드입니다.
     * @param type 응답받은 타입입니다.
     */
    public void statusChange(int type);


    /**
     * 뷰의 officerAssigned() 메소드를 사용할 메소드입니다.
     * @param officer 배정된 officer입니다.
     */
    public void officerAssigned(Officer officer);
}
