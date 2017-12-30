package com.heu.neo.browseimages;

import android.app.ActivityManager;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Text;

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
//        final EditText wd = (EditText)findViewById(R.id.word);
//        final ImageView iv = (ImageView)findViewById(R.id.iv);
//        final ProgressDialog dialog = new ProgressDialog(this);
////        final TextView tv = (TextView)findViewById(R.id.tv);
//        final ListView lv = (ListView)findViewById(R.id.listview);
////        LoadImageUrls lt = new LoadImageUrls(dialog, tv);
//        dialog.setMessage("Loading......");
//
////        String url = "http://aa.ykbsl.com/share/single1.json";
//        String url = "http://aa.ykbsl.com/share/list1.json";
//        String data = null;
//        try {
//            data = NetUtil.doGet(url);
////            tv.setText(html);
//            Gson gson = new Gson();
//            TypeToken<List<Article>> token = new TypeToken<List<Article>>(){};
//            List<Article> al = gson.fromJson(data, token.getType());
//            final List<Map<String,String>> listMap = new ArrayList<Map<String,String>>();
//            for(Article a:al){
//                Map<String,String> map = new HashMap<String,String>();
//                map.put("title",a.getTitle());
//                map.put("data", a.getDate());
//                map.put("imgurl", a.getImgurl());
//                listMap.add(map);
//            }
//            final String[] from = {"title", "data", "imgurl"};
//            final int[] to = {R.id.listview};
//            if(!TextUtils.isEmpty(data)){
//                lv.post(new Runnable(){
//                    @Override
//                    public void run() {
//                        SimpleAdapter sa = new SimpleAdapter(Images.this, listMap, R.layout.activity_images, from, to);
//                        lv.setAdapter(sa);
//                    }
//                });
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//            String html = url;
//            tv.setText("get html over");

//        //加载百度图片搜索获取的链接
//        //获取用户输入的关键字
//        String word = wd.getText().toString();
//        //拼接百度图片搜索的链接
//        String url = "http://image.baidu.com/search/index?tn=baiduimage&word="+word;
//        try {
//            List<String>urls = lt.execute(url).get();
////            for(int i = 0; i < urls.size(); ++i){
////                new LoadPic(dialog, iv).execute(urls.get(i));
////            }
//            //根据获取的图片链接加载图片
//            new LoadPic(dialog, iv).execute(urls.get(3));
////            new LoadPic(dialog, iv0).execute(urls.get(5));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.listview);
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


//        final EditText wd = (EditText)findViewById(R.id.word);
//        final ImageView iv = (ImageView)findViewById(R.id.iv);
        final ProgressDialog dialog = new ProgressDialog(this);
//        final TextView tv = (TextView)findViewById(R.id.tv);
        final ListView lv = (ListView)findViewById(R.id.listview);
        final TextView t1 = (TextView)findViewById(R.id.t1);
        final TextView t3 = (TextView)findViewById(R.id.t3);
        final ImageView i0 = (ImageView)findViewById(R.id.iv0);
        final LoadHtml lt = new LoadHtml();
        dialog.setMessage("Loading......");

//        String url = "http://aa.ykbsl.com/share/single1.json";
        final String url = "http://aa.ykbsl.com/share/list1.json";
//        String url = "http://cn.bing.com";
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        String data = null;
                        try {
//            data = NetUtil.doGet(url);
                            data = lt.execute(url).get();
                            t3.setText(data);
//            data = NetUtil.doGetHttpClient(url);
//                            tv.setText(data);
//            data = "isisisi";
//            tv.setText(html);
                            Gson gson = new Gson();
                            TypeToken<List<Article>> token = new TypeToken<List<Article>>(){};
                            final List<Article> al = gson.fromJson(data, token.getType());
                            final List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();
                            for(Article a:al){
//                                Map<String,String> map = new HashMap<String,String>();
                                Map<String,Object> map = new HashMap<String,Object>();
                                map.put("title",a.getTitle());
                                map.put("date", a.getDate());
                                map.put("imgurl", a.getImgurl());
//                                map.put("image", new LoadBitMap().execute(a.getImgurl()));
//                                new LoadPic(dialog, i0).execute(a.getImgurl();
                                byte[] id = NetUtil.doGetImage(a.getImgurl());
                                Bitmap bm = BitmapFactory.decodeByteArray(id, 0, id.length);
                                map.put("image", bm);
                                listMap.add(map);
                            }
                            final String[] from = {"title", "date", "imgurl", "image"};
                            final int[] to = {R.id.t1, R.id.t2, R.id.t4, R.id.iv0};
//                            final SimpleAdapter sa = new SimpleAdapter(Images.this, listMap, R.layout.listview, from, to);
                            final SimpleAdapter sa = new SimpleAdapter(Images.this, listMap, R.layout.listview, from, to);
//                            sa.setViewBinder(new SimpleAdapter.ViewBinder() {
//                                public boolean setViewValue(
//                                        View view,
//                                        Object data,
//                                        String textRepresentation) {
//                                    //判断是否为我们要处理的对象
//                                    if(view instanceof ImageView  && data instanceof Bitmap){
//                                        ImageView iv = (ImageView) view;
//                                        iv.setImageBitmap((Bitmap) data);
//                                    }
//                                    else{
//                                        TextView tv = (TextView)view;
//                                        tv.setText((String)data);
//                                    }
//                                    return true;
//                                }
//                            });
                            sa.setViewBinder(new SimpleAdapter.ViewBinder() {
                                @Override
                                public boolean setViewValue(View view, Object attentionList, String textRepresentation) {
                                    // TODO Auto-generated method stub
                                    if(view instanceof ImageView && attentionList instanceof Bitmap){
                                        ImageView iv=(ImageView)view;
                                        iv.setImageBitmap((Bitmap) attentionList);
                                        return true;
                                    }else if(view instanceof TextView && attentionList instanceof String){
                                        TextView tv = (TextView)view;
                                        tv.setText((String)attentionList);
                                        return true;
                                    }
                                    return false;
                                }
                        });
                            if(!TextUtils.isEmpty(data)){
                                lv.post(new Runnable(){
                                    @Override
                                    public void run() {
                                        lv.setAdapter(sa);
//                                        sa.setViewBinder(new SimpleAdapter.ViewBinder() {
//                                            public boolean setViewValue(
//                                                    View view,
//                                                    Object data,
//                                                    String textRepresentation) {
//                                                //判断是否为我们要处理的对象
//                                                if(view instanceof ImageView  && data instanceof Bitmap){
//                                                    ImageView iv = (ImageView) view;
//                                                    iv.setImageBitmap((Bitmap) data);
//                                                }
//                                                else{
//                                                    TextView tv = (TextView)view;
//                                                    tv.setText((String)data);
//                                                }
//                                                return true;
//                                            }
//                                         });
                                    }
                                });
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
        ).start();
    }
}
