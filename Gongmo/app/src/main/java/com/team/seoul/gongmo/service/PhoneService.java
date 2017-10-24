package com.team.seoul.gongmo.service;

import android.location.LocationManager;
import android.provider.Settings.Secure;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.view.View;

import com.team.seoul.gongmo.MainActivity;

import java.util.UUID;

/**
 * Created by USER on 2017-09-27.
 */

//사용을 위해 AndroidManifext.xml 에 사전 설정 필요
public class PhoneService {

    //디바이스의 식별값
    public String getDeviceUUID(Context mContext){
        final TelephonyManager tm = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);

        final String tmDevice, tmSerial, androidId;
        tmDevice = "" + tm.getDeviceId();
        tmSerial = "" + tm.getSimSerialNumber();
        androidId = "" + android.provider.Settings.Secure.getString(mContext.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);

        UUID deviceUuid = new UUID(androidId.hashCode(), ((long)tmDevice.hashCode() << 32) | tmSerial.hashCode());
        String deviceId = deviceUuid.toString();

        return deviceId;
    }

    //디바이스의 전화번호
    public String getDeviceNum(Context mContext){
        String deviceNum = null;
        TelephonyManager mtm = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
        try{
            deviceNum = mtm.getLine1Number();
            deviceNum = deviceNum.replace("+82", "0");

        }catch (Exception e){}


        return deviceNum;
    }

    //디바이스의 위치 - gps 이용
    //public String getLocation(){

    //}

}
