package com.udacity.gradle.builditbigger.main;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.backend.myApi.model.MyBean;

import java.io.IOException;

import in.connectitude.jokesjavalibrary.JokesActivity;

public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    private String TAG = "Background";
    private View progressBar;

    public EndpointsAsyncTask(Context context,View progressBar){
        this.context = context;
        this.progressBar = progressBar;
    }
    public EndpointsAsyncTask(Context context){
        this.context = context;


    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (progressBar != null) {
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        Log.i(TAG, "doInBackground: ");
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/");

            myApiService = builder.build();
        }

       String name = "Jokes are loaded";

        try {
            return myApiService.sayHi(name).execute().getData();
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
            return null;
        }

       /* try {
           // MyBean jokeBean = myApiService.sayJoker().execute();
            //return jokeBean.getData();
        } catch (IOException e) {
            return null;
        }*/

    }


    @Override
    protected void onPostExecute(String result) {
//        progressBar.setVisibility(View.GONE);
        Intent intent = new Intent(context, JokesActivity.class);
        intent.putExtra("joke", result);
        context.startActivity(intent);
    }
}