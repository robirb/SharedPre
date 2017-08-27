package com.linear.sharedpre;

import android.content.Context;
import android.content.SharedPreferences;
public class UserLocalDatabase {
    private static final String PREF_NAME="robi";

    private static final String LOGIN_KEY="lllllllll";
    private static final String USER_NAME="USER_NAME";

    private Context context;
    private SharedPreferences myPref;

    public UserLocalDatabase(Context context) {
        this.context = context;
        myPref = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
    }

    public void setLogin(boolean value){
        SharedPreferences.Editor editor = myPref.edit();
        editor.putBoolean(LOGIN_KEY,value);
        editor.apply();
    }

    public boolean isLogin(){
        boolean returnValue = myPref.getBoolean(LOGIN_KEY,false);
        return returnValue;
    }

    public void setUserName(String userName){
        SharedPreferences.Editor editor = myPref.edit();
        editor.putString(USER_NAME,userName);
        editor.apply();
    }

    public String getUserName(){
        return myPref.getString(USER_NAME,"");
    }
}
