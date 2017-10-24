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

interface IMainPresenter {

    /*
     * 혹시나 핸들러를 사용해서 해야한다고 판단될 경우에
     * 여기까지 와서 처리를 하도록 하기 위한 메소드입니다
     * 만약에 로직이 길어진다면 따로 서비스를 생성해서 나누는 것이 맞을 겁니다.
     */


    /**
     * 도움말을 토글합니다.
     */
    public void showHelp();


    /**
     * 도움말을 토글합니다.
     */
    public void closeHelp();


    /**
     * 도움말을 더 이상 보이지 않습니다.
     * 이것 같은 경우에는 Preference라는 것에
     * 여부를 저장해두고 그 값에 따라 보이지 않도록 하는것이 좋을 듯합니다
     * 혹은 파일을 쓰게 해서 그 파일의 값을 읽고 시작하도록 하는것도 좋을 듯합니다.
     */
    public void dontShowAnyMore();
}
