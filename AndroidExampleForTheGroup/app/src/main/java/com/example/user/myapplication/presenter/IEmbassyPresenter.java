package com.example.user.myapplication.presenter;

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

interface IEmbassyPresenter {

    /**
     * 모든 국가별 대사관 정보를 가져올 메소드입니다.
     */
    public void fetchEmbassyList();

    /**
     * 해당 국가의 대사관 정보를 가져올 메소드입니다.
     * 이때 매개변수를 추가해 주어야합니다.
     */
    public void fetchEmbassyInfo();

}
