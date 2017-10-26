package com.example.user.myapplication.service;

import com.example.user.myapplication.domain.Tourist;
import com.example.user.myapplication.domain.TouristInfo;

import java.util.List;
import java.util.UUID;

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

interface ITouristService {

    /**
     * 관광객객체를 생성합니다.
     * 이때 이 정보를 메모리에 올려두고 해야하는데 이렇게 되면 아무래도
     * 어느 위치에 기억을 시킬지가 가장 큰 문제인데
     * 로직을 짜면서 생각해주시면 됩니다.
     *
     * @return tourist 새로운 관광객 정보를 리턴합니다.
     */
    public List<TouristInfo> setupTourist();

    public UUID onDutyItem();
}
