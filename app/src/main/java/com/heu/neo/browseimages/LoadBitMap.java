package com.heu.neo.browseimages;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;

/**
 * Created by neo on 2017/12/9.
 */

public class LoadBitMap extends AsyncTask<String, Integer, Bitmap>{
    private Bitmap bm = null;

    public LoadBitMap(Bitmap bm) {
        this.bm = bm;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        super.onPostExecute(result);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        publishProgress(0);
        String url = strings[0];
        try {
            byte[] data = NetUtil.doGetImage(url);
            bm = BitmapFactory.decodeByteArray(data, 0, data.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bm;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }
}
