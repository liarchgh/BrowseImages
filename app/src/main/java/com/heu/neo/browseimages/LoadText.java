package com.heu.neo.browseimages;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

/**
 * Created by neo on 2017/12/9.
 */

public class LoadText extends AsyncTask<String, Integer, String>{
    private ProgressDialog dialog;
    private TextView tv;

    public LoadText(ProgressDialog dialog, TextView imageView) {
        this.dialog = dialog;
        this.tv = imageView;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if(dialog != null){
            dialog.dismiss();
        }
        if(tv != null && result != null){
            tv.setText(result);
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if(dialog != null){
            dialog.show();
        }
    }

    @Override
    protected String doInBackground(String... strings) {
        publishProgress(0);
        String url = strings[0];
        String data = null;
        try {
            data = NetUtil.doGet(url);
        } catch (Exception e) {
            data = "E";
        }
        return data;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        dialog.setMessage("has load "+values[0]+"%");
    }
}
