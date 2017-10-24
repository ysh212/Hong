package com.example.user.myapplication.domain;

import com.skp.Tmap.TMapMarkerItem;

import java.util.List;

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

public class Connected {
  //연결됬을 경우 코드
  public static final int CONNECT = 1;
  //연결해제됬을 경우 코드
  public static final int DISCONNECT = 2;
  //접수 혹은 등록이 되었을경우
  public static final int REGISTER = 4;
  //이거는 바꿀수도 있을거 같음 위랑 같은 내용이나 다름없어서
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

  public static List<TMapMarkerItem> list;
}
