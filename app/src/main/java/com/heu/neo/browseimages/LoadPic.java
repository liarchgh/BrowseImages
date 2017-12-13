package com.heu.neo.browseimages;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;

/**
 * Created by neo on 2017/12/9.
 */

public class LoadPic extends AsyncTask<String, Integer, Bitmap>{
    private ProgressDialog dialog;
    private ImageView imageView;

    public LoadPic(ProgressDialog dialog, ImageView imageView) {
        this.dialog = dialog;
        this.imageView = imageView;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        super.onPostExecute(result);
        if(dialog != null){
            dialog.dismiss();
        }
        if(imageView != null && result != null){
            imageView.setImageBitmap(result);
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
    protected Bitmap doInBackground(String... strings) {
        publishProgress(0);
        String url = strings[0];
        Bitmap bm = null;
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
        dialog.setMessage("has load "+values[0]+"%");
    }
}
