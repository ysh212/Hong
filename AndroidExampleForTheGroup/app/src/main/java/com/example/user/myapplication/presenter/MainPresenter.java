package com.example.user.myapplication.presenter;

import com.example.user.myapplication.view.IMainView;

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

public class MainPresenter implements IMainPresenter {

    private IMainView view;

    public MainPresenter(IMainView view) {
        this.view = view;
    }

    @Override
    public void showHelp() {
        /*

         */
    }

    @Override
    public void closeHelp() {
        /*

         */
    }

    @Override
    public void dontShowAnyMore() {
        /*

         */
    }
}
