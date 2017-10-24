package com.example.user.myapplication.service;

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
import com.google.gson.JsonObject;

/**
 * BackgroundService가 사용할 메소드입니다.
 */
interface IListeningService {

    /**
     * 인터렉터를 불러서 뷰에 영향을 주기위한 메소드입니다.
     * @param type 응답받은 타입입니다.
     */
    public void statusChange(int type);


    /**
     * 인터렉터를 불러서 뷰에 영향을 주기위한 메소드입니다.
     * @param officer 배정된 officer입니다.
     */
    public void officerAssigned(Officer officer);
}
