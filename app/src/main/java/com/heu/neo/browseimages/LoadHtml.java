package com.heu.neo.browseimages;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by neo on 2017/12/9.
 */

public class LoadHtml extends AsyncTask<String, Integer, String>{
    private String html = null;

    public LoadHtml() {}

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        publishProgress(0);
        String url = strings[0];
        try {
            html = NetUtil.doGet(url);
//            html = url;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return html;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }
}
