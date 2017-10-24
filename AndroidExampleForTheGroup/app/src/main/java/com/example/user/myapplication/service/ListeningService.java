package com.example.user.myapplication.service;

import com.example.user.myapplication.domain.Officer;
import com.google.gson.JsonObject;

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

public class ListeningService implements IListeningService {
    private final String TAG = "Listening Service";


    @Override
    public void statusChange(int type) {
        /*
        인터렉터를 부르세요
        만약에 여기서 로직이 길어진다면 private으로 메소드화 시켜주세요
         */
    }

    @Override
    public void officerAssigned(Officer officer) {
        /*
        인터렉터를 부르세요
        만약에 여기서 로직이 길어진다면 private으로 메소드화 시켜주세요
         */
    }
}
