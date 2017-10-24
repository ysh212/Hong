package com.team.seoul.gongmo.domain;

import java.util.List;

/**
 * Created by USER on 2017-09-27.
 */

//서버에 연결된 관광객과 오피서들의 리스트 및 메세지 코드 정보를 담고 있습니다.
public class Connected {
    public static List<Officer> OFFICERS;
    public static List<Tourist> TOURISTS;

    //연결됬을 경우 코드 - 처음 서버와 연결시
    public static final int CONNECT = 1;
    //연결해제됬을 경우 코드 - 마지막
    public static final int DISCONNECT = 2;
    //접수 혹은 등록이 되었을경우
    public static final int REGISTER = 4;
    //officer가 신고내용 확인 후, 담당하겠다고 서버측에 알림
    public static final int ACCEPT = 8;
    //승인 거부된 경우
    public static final int DENIED = 16;
    //확정된 경우
    public static final int CONFIRM = 32;
    //취소된 경우
    public static final int CANCEL = 64;
    //상황이 종료된 경우 (변수 이름 바꿀 가능성이 높음)
    public static final int CASE_CLOSED = 128;
    //위치 업데이트인 경우
    public static final int LOC_UPDATE = 256;

    //이건 뭐야?
    public static final int SITU_B = 512;
    public static final int SITU_C = 1028;
    public static final int SITU_D = 2048;
    public static final int SITU_A = 4096;

}
