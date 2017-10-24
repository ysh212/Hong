package com.team.seoul.myapplication123;

import android.net.Uri;
import android.os.AsyncTask;

import org.w3c.dom.Document;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by USER on 2017-10-24.
 */

public class TmapClient extends AsyncTask<String, Void, Document>{
    HttpURLConnection connection;
    Document responseDocument;


    @Override
    protected Document doInBackground(String... strings) {
        try {

            URI uri = new URI(strings[0]);
            uri = new Uri.Builder(uri).appendPath("d");


        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
