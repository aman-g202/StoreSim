package com.hotwaxsystems.www.wscautomation.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by darkshadow on 25/3/18.
 */

public class SharedPrefUtil {

    Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "MyPref";

    public SharedPrefUtil(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void createLoginToken(String key, String token){
        editor.putString(key,token);
        editor.commit();
    }

    public void createLoginSessonId(String key, String sessionid){
        editor.putString(key,sessionid);
        editor.commit();
    }

    public String retrieveLoginToken(String key, String defValue){
        return sharedPreferences.getString(key,defValue);
    }

    public String retrieveLoginSessionId(String key, String defValue){
        return sharedPreferences.getString(key,defValue);
    }
}
