package com.ayuan.douban.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SPUtils {

    private static SharedPreferences sharedPreferences;

    public static String CITYNAME = "cityname";

    public static String CITYCODE = "citycode";

    public static void putString(Context context, String key, String value) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        }
        sharedPreferences.edit().putString(key, value).commit();
    }

    public static String getString(Context context, String key, String defValue) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        }
        return sharedPreferences.getString(key, defValue);
    }

    public static void putInt(Context context, String key, int value) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        }
        sharedPreferences.edit().putInt(key, value).commit();
    }

    public static int getInt(Context context, String key, int defValue) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        }
        return sharedPreferences.getInt(key, defValue);
    }
}
