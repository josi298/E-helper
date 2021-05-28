package com.example.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import static android.app.ProgressDialog.show;

public class prefconfig {
    private SharedPreferences sharedPreferences;
    private Context context;

    public prefconfig(Context context){

        this.context = context;

        sharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_file),context.MODE_PRIVATE);
    }
    public void  writeLoginStatus(boolean status){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean(context.getString(R.string.pref_login_status),status);
        editor.commit();
    }

    public boolean readLoginStatus(){
        return sharedPreferences.getBoolean(context.getString(R.string.pref_login_status),false);
    }

    public void writeName(String name){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(context.getString(R.string.pref_user_name),name);
        editor.commit();

    }

    public String readName()
    {
        return sharedPreferences.getString(context.getString(R.string.pref_user_name),"user");
    }
    public void displayToast (String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
}
