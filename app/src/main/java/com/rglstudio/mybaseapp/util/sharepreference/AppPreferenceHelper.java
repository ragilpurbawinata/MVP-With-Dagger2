package com.rglstudio.mybaseapp.util.sharepreference;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

public class AppPreferenceHelper implements PreferenceHelper{
    private static final String USER_PREFERENCE = "user_preference";
    private static final String USER_LOGIN = "user_login";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Inject
    public AppPreferenceHelper(Context context) {
        this.sharedPreferences = context.getSharedPreferences(USER_PREFERENCE, Context.MODE_PRIVATE);
        this.editor = sharedPreferences.edit();
    }

    @Override
    public void setIsLogin(Boolean login) {
        editor.putBoolean(USER_LOGIN, login);
        editor.apply();
    }

    @Override
    public Boolean getIsLogin() {
        return sharedPreferences.getBoolean(USER_LOGIN, false);
    }
}
