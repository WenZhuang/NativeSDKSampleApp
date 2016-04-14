package com.wikitude.samples.recognition.client;

/**
 * Created by xue on 2015/12/6.
 */

import java.net.HttpURLConnection;
import java.net.URL;

import java.io.InputStream;

public class Service {
    private static Object InputStream;

    public static String loginByget(String targetName){
        String path = "http://10.103.24.106:8080/cshttp/arServlet?targetName="+targetName;
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(200);
            conn.setRequestMethod("GET");

            int code = conn.getResponseCode();
            if (code == 200){
                InputStream is = conn.getInputStream();
                String text = StreamTools.readInputStream(is);
                return text;
            }else{
                return "no response";
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
