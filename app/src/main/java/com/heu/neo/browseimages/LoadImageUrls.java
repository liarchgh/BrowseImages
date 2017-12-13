package com.heu.neo.browseimages;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.TextView;

/**
 * Created by neo on 2017/12/9.
 */

public class LoadImageUrls extends AsyncTask<String, Integer, List<String>>{
    private ProgressDialog dialog;
    private TextView tv;

    public LoadImageUrls(ProgressDialog dialog, TextView imageView) {
        this.dialog = dialog;
        this.tv = imageView;
    }

    @Override
    protected void onPostExecute(List<String> result) {
        super.onPostExecute(result);
        if(dialog != null){
            dialog.dismiss();
        }
        if(tv != null && result != null){
            for(int i = 0; i < result.size(); ++i){
                tv.setText(tv.getText().toString()+"\n"+result.get(i));
            }
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
    protected List<String> doInBackground(String... strings) {
        publishProgress(0);
        String url = strings[0];
        List<String>urls = new ArrayList<String>();
//        tv.setText(url);
        try {
            String html = NetUtil.doGet(url);
//            String html = url;
//            tv.setText("get html over");
//            tv.setText(html);
//            Pattern pattern = Pattern.compile("^(\'imgData\',.*;$");
//            Matcher matcher = pattern.matcher(html);
//            boolean b= matcher.matches();
//            //当条件满足时，将返回true，否则返回false
//            System.out.println(b);
//            publishProgress(1);

            String jsonRe = "\\('imgData',[^)]*\\)";
            Pattern pattern = Pattern.compile(jsonRe);
//            publishProgress(2);
            Matcher matcher = pattern.matcher(html);
//            publishProgress(3);
            while(matcher.find()){
//                urls.add("sssss");
//                tv.setText("find something");
                String objUrls = matcher.group();
                String urlJsonRe = "http([^\"]*?)\"";
//                String urlJsonRe = "http";
                Pattern urlJsonPattern = Pattern.compile(urlJsonRe);
                Matcher urlJsonMc = urlJsonPattern.matcher(objUrls);
                while(urlJsonMc.find()){
                    String tt = urlJsonMc.group();
                    int len = tt.length() - 1;
                    len = len>=0?len:0;
                    urls.add(tt.substring(0, len).replaceAll("\\\\/", "/"));
                }
            }
//            else{
//                urls.add("error");
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return urls;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        dialog.setMessage("loading urls "+values[0]);
    }
}
