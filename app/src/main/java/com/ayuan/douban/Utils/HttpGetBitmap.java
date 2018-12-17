package com.ayuan.douban.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import com.ayuan.douban.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpGetBitmap {
    private static Bitmap bitmap;

    public static Bitmap getBitmap(final String path, final Context context) {
        bitmap = null;
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    File file = new File(context.getCacheDir().getPath(), Base64.encodeToString(path.getBytes(), Base64.DEFAULT));
                    //判断文件是否存在以及文件大小是否大于0
                    if (file.exists() && file.length() > 0) {
                        bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                    } else {
                        URL url = new URL(path);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setConnectTimeout(5000);
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode == 200) {
                            InputStream inputStream = httpURLConnection.getInputStream();
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            int len = -1;
                            byte[] bytes = new byte[1024];
                            while ((len = inputStream.read(bytes)) != -1) {
                                fileOutputStream.write(bytes, 0, len);
                            }
                            bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());

                            inputStream.close();
                            fileOutputStream.close();
                        } else {
                            bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.logobg);
                        }
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
