package com.ayuan.douban.Utils;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;

import com.ayuan.douban.vo.Subjects;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class HttpRequest {
    private static final String TAG = "HttpRequest";
    private static String IP = "https://api.douban.com/v2/movie/in_theaters?apikey=0b2bdeda43b5688921839c8ecb20399b&";

    public static ArrayList<Subjects> httpGetMovie(String[] parpam) {
        ArrayList<Subjects> movieDetail = AnalyzeJson.getMovieDetail(httpSetting(parpam));
        if (movieDetail != null) {
            return movieDetail;
        }
        return null;
    }

    public static Bitmap httpGetBitmap(String path) {

        return null;
    }

    private static String httpSetting(String[] parpam) {
        try {
            for (int i = 0; i < parpam.length; i++) {
                parpam[i] = URLEncoder.encode(parpam[i]);
            }
            String path = IP + "city=" + parpam[0] + "&start=" + parpam[1] + "&count=" + parpam[2] + "client=" + parpam[3] + "&udid=" + parpam[4];
            URL url = new URL(path);
            Log.i(TAG, "哈哈:拼接好的地址" + path);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setConnectTimeout(5000);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (inputStream != null) {
                    String jsonString = StreamUtils.StreamToString(inputStream);
                    Log.i(TAG, "哈哈:获取到了json字符串:" + jsonString);
                    if (!TextUtils.isEmpty(jsonString)) {
                        return jsonString;
                    } else {
                        return null;
                    }
                } else {
                    return null;
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}