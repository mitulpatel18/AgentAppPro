package com.millionsllp.agentapppro;

import android.location.Location;
import android.os.AsyncTask;
import android.util.Log;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CallAPI extends AsyncTask<String, String, String> {

    OkHttpClient client = new OkHttpClient();

    public Double Lon,Lat;
    public CallAPI(Location location){

        Lon=location.getLatitude();
        Lat=location.getLongitude();


    }



    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
         HttpUrl.Builder urlBuilder = HttpUrl.parse(params[0]).newBuilder();
         urlBuilder.addQueryParameter("lat", String.valueOf(Lon));
         urlBuilder.addQueryParameter("lon", String.valueOf(Lat));
        urlBuilder.addQueryParameter("AgencyCode", String.valueOf(params[1]));
        urlBuilder.addQueryParameter("AgentCode", String.valueOf(params[2]));
        urlBuilder.addQueryParameter("ApiToken", String.valueOf(params[3]));
         String url = urlBuilder.build().toString();


         Log.e("PostMethod",url);

        Request.Builder builder = new Request.Builder();
        builder.url(url);
        Request request = builder.build();



        try {
            Response response = client.newCall(request).execute();
            Log.e("PostMethod", String.valueOf(response));
            return response.body().string();
        }catch (Exception e){
            e.printStackTrace();
            Log.e("PostMethodError","Error Found");
        }
        return null;

        //return true;
    }
}
