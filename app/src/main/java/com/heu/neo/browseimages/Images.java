package com.heu.neo.browseimages;

import android.graphics.BitmapFactory;
import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.app.AliasActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Images extends AppCompatActivity {
    public static final int MY_MSG = 0;
    public static final int MY_PIC = 1;

    //查找界面中的控件
//    final ImageView iv = (ImageView)findViewById(R.id.iv);
//    final ImageView iv0 = (ImageView)findViewById(R.id.iv0);
//    final TextView tv = (TextView)findViewById(R.id.tv);
//    final EditText wd = (EditText)findViewById(R.id.word);
//    final Button bts = (Button)findViewById(R.id.bts);
//    //创建滚动进度条
//    ProgressDialog dialog = new ProgressDialog(this);
    //加载百度图片搜索获取的链接

    public void searchImages(View view){
        final EditText wd = (EditText)findViewById(R.id.word);
        final ImageView iv = (ImageView)findViewById(R.id.iv);
        final ProgressDialog dialog = new ProgressDialog(this);
        final TextView tv = (TextView)findViewById(R.id.tv);
        LoadImageUrls lt = new LoadImageUrls(dialog, tv);
        dialog.setMessage("Loading......");
        //加载百度图片搜索获取的链接
        //获取用户输入的关键字
        String word = wd.getText().toString();
        //拼接百度图片搜索的链接
        String url = "http://image.baidu.com/search/index?tn=baiduimage&word="+word;
        try {
            List<String>urls = lt.execute(url).get();
//            for(int i = 0; i < urls.size(); ++i){
//                new LoadPic(dialog, iv).execute(urls.get(i));
//            }
            //根据获取的图片链接加载图片
            new LoadPic(dialog, iv).execute(urls.get(3));
//            new LoadPic(dialog, iv0).execute(urls.get(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);
//        dialog.setMessage("Loading......");

//    LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.FILL_PARENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT
//        );


//        String url = "http://acm.hdu.edu.cn/images/banner.jpg";
//        LoadPic lp = new LoadPic(dialog, iv);
//        lp.execute(url);
//        LoadText lt = new LoadText(dialog, tv);
//        String word = "iphone";
//        url = "https://image.baidu.com/search/index?tn=baiduimage&word="+word;
//        lt.execute(url);

//        final Handler mainHandler = new Handler();
//        {
//            @Override
//            public void handleMessage(Message msg) {
//                super.handleMessage(msg);
////                tv2.setText(msg.what);
//                switch(msg.what){
//                    case MY_MSG:
//                        tv.setText((String)msg.obj);
//                        break;
//                    case MY_PIC:
//                        break;
//                }
//            }
//        };

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                String url = "http://www.bilibili.com";
//                try {
//                    String res = NetUtil.doGet(url);
//                    Message msg = new Message();
//                    msg.what = MY_MSG;
//                    msg.obj = res;
//                    mainHandler.sendMessage(msg);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                String url = "http://acm.hdu.edu.cn/images/banner.jpg";
//                try {
////                    new LoadPic(this, null, iv);
//                    byte[] res = NetUtil.doGetImage(url);
//                    final Bitmap bm = BitmapFactory.decodeByteArray(res, 0, res.length);
////                    runOnUiThread(new Runnable() {
////                        @Override
////                        public void run() {
////                        }
////                    });
//
//                    //直接运行
////                    iv.post(new Runnable() {
////                        @Override
////                        public void run() {
////                            iv.setImageBitmap(bm);
////                        }
////                    });
//
////                    //延迟运行
////                    iv.postDelayed(
////                    new Runnable() {
////                        @Override
////                        public void run() {
////                            iv.setImageBitmap(bm);
////                        }
////                    }, 3000);
////
//////                    Message msg = new Message();
//////                    msg.what = MY_PIC;
//////                    msg.obj = ;
//////                    mainHandler.sendMessage(msg);
////                    url = "http://www.bilibili.com";
//////                    url = "http://image.baidu.com/i?tn=baiduimagejson&word=周杰伦&pn=10&rn=10&ie=utf8";
////                    final String rest = NetUtil.doGet(url);
////
////                    tv.postDelayed(new Runnable() {
////                        @Override
////                        public void run() {
////                            tv.setText(rest);
////                        }
////                    }, 5000);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
    }
}
