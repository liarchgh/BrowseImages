package com.heu.neo.browseimages;

import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by neo on 2017/12/9.
 */

public class NetUtil {
    	static String doGetHttpClient(String url) {
    	    String msg = "nothing";
		try{
//			System.out.println("GetHttpClient");
//			System.out.println("URL:"+url);
			HttpClient client = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(url);
			HttpResponse response = client.execute(httpGet);
			int code = response.getStatusLine().getStatusCode();
//			System.out.println("status code: "+code);

//				Header type = response.getEntity().getContentType();
			Header[] hs = response.getAllHeaders();
//			System.out.println("header:"+hs.toString());

//			long size = response.getEntity().getContentLength();
//			System.out.println("size: " + size);

//			System.out.println("body:");
			InputStream in = response.getEntity().getContent();
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
			msg = new String(arr, "utf-8");
			System.out.println(msg);
		}
		catch(Exception e){
		    msg = "E";
			System.out.println("E");
		}
		return msg;
	}
//    public static String doGet(String address){
//        String msg = "nothing";
//        try {
////            msg = "begin";
//            URL url = new URL(address);
//            msg += "0";
//            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
//            msg += "0";
//            conn.setConnectTimeout(10000);
//    //        conn.setRequestProperty("Accept", "*/*");
//    //        conn.setRequestProperty("Connection", "close");
//            conn.setRequestMethod("GET");
////            msg += "0";
//            ByteArrayOutputStream out = new ByteArrayOutputStream();
//            msg += "0";
//            InputStream in = conn.getInputStream();
////            msg += "0";
//            byte[] buffer = new byte[1024];
//
//            while(true){
//                msg += "1";
//                int len = in.read(buffer);
//                if(len == -1){
//                    break;
//                }
//                out.write(buffer, 0, len);
//            }
//            byte[] arr = out.toByteArray();
//            msg = new String(arr, "UTF-8");
//            in.close();
//            out.close();
//        }
//        catch(Exception e){
////            System.out.println("E");
//            msg += "ENet";
//        }
//        return msg;
//    }

    public static String doGet(String address){


        String result=null;
        try{
            URL url = new URL(address);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setConnectTimeout(10000);
            conn.setRequestProperty("Accept","image/jpeg,*/*");
            conn.setRequestProperty("Connection","close");
            conn.setRequestMethod("GET");
            java.io.InputStream in = conn.getInputStream();
            ByteArrayOutputStream out =new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            while (true){
                int len =in.read(buffer);
                if(len==-1) break;
                out.write(buffer, 0,len);
            }
            byte[] arr =out.toByteArray();
            result = new String(arr,"UTF-8");
            //System.out.println(msg);
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;

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
