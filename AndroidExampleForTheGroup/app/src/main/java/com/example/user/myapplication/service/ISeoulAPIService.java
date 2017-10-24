package com.example.user.myapplication.service;

import java.util.List;
import java.util.Map;

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

/**
 * 서울시 api 접근용 인터페이스입니다.
 */
interface ISeoulAPIService {

    /**
     * 모든 대사관 정보를 리턴합니다. 맵의 리스트인 상태 혹은 JsonObject가 될 가능성이 있습니다.
     *
     * @return list
     */
    public List<Map> fetchEmbassyList();

    /**
     * 하나의 대사관 정보를 리턴합니다.
     * 매개변수가 하나 있어야하는데 지금 아직 api가 어떤 값을 리턴하는지를 몰라서 쓰지 않았습니다.
     */
    public String fetchEmbassyInfo();
}
