package com.weiwei.maventest;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.core.content.SharedPreferencesCompat;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author weiwei
 * @Date 2022.5.19 11:00
 */
public class SPUtil {


    public static void putStringSet(Context context, Set<String> set) {
        SharedPreferences sp = context.getSharedPreferences("weiwei", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putStringSet("weiwei", set);
        editor.apply();
    }

    public static Set<String> getStingSet(Context context,String key) {

        SharedPreferences sp = context.getSharedPreferences("weiwei", Context.MODE_PRIVATE);

        return sp.getStringSet(key,new HashSet<>());

    }
}
