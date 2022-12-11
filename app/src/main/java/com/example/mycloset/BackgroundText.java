package com.example.mycloset;

import android.content.Context;
import android.os.AsyncTask;

public class BackgroundText extends AsyncTask<String,Void,Void> {
    Context ctx;
    BackgroundText(Context ctx)
    {

        this.ctx = ctx;
    }
    @Override
    protected void onPreExecute(){
        super.onPreExecute();
    }
    @Override
    protected Void doInBackground(String... params) {
        String method = params[0];
        if(method.equals("add"))
        {

        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void...values){
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Void aVoid){
        super.onPostExecute(aVoid);
    }
}
