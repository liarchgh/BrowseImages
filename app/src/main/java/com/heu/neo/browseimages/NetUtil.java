package com.heu.neo.browseimages;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by neo on 2017/12/9.
 */

public class NetUtil {
    public static String doGet(String address) throws IOException{
        URL url = new URL(address);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setConnectTimeout(10000);
//        conn.setRequestProperty("Accept", "image/jepg,*/*");
//        conn.setRequestProperty("Connection", "close");
        conn.setRequestMethod("GET");
        try {
            InputStream in = conn.getInputStream();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];

            while(true){
                int len = in.read(buffer);
                if(len == -1){
                    break;
                }
                out.write(buffer, 0, len);
            }
            byte[] arr = out.toByteArray();
            String msg = new String(arr, "UTF-8");
            in.close();
            out.close();
            return msg;
        }
        catch(Exception e){
            System.out.println("E");
        }
        return "error";
    }

    public static byte[] doGetImage(String address) throws IOException{
        byte[] res = null;
        URL url = new URL(address);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setConnectTimeout(10000);
        conn.setRequestProperty("Accept", "image/jepg,*/*");
        conn.setRequestProperty("Connection", "close");
        conn.setRequestMethod("GET");
        int length = conn.getContentLength();
        int total = 0;
        try {
            InputStream in = conn.getInputStream();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];

            while(true){
                int len = in.read(buffer);
                if(len == -1){
                    break;
                }
                total += len;
                int present = (total * 100 / length);
                out.write(buffer, 0, len);
            }
            byte[] arr = out.toByteArray();
            out.close();
            return arr;
        }
        catch(Exception e){
            System.out.println("E");
        }
        return res;
    }
}
