package com.millionsllp.agentapppro;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class WebAppInterface{

    Context mContext;

    /** Instantiate the interface and set the context */
    WebAppInterface(Context c) {
        mContext = c;
    }

    /** Show a toast from the web page */
    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void setUser(String AgencyCode, String AgentCode, String ApiToken){

        SharedPreferences preferences =
                mContext.getSharedPreferences("com.millionsllp.agentapp", Context.MODE_PRIVATE);

        preferences.edit().putString("AgencyCode", AgencyCode).commit();
        preferences.edit().putString("AgentCode", AgentCode).commit();
        preferences.edit().putString("ApiToken", ApiToken).commit();

        Log.e("WebApplication","AgencyCode :"+AgencyCode);
    }

        public void startTracing(){

        Intent notificationIntent = new Intent(mContext, MyLocation.class);
        mContext.startService(notificationIntent);
    }
}
