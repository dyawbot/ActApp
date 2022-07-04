package com.example.actapp.db_connections;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class BgWorker extends AsyncTask<String,Void,String> {
    AlertDialog alertDialog;

    Context context;
    public BgWorker(Context ctx)
    {
        context = ctx;
    }
    @Override
    protected String doInBackground(String... strings) {

        String log_url = strings[0];
        String type = strings[1];
        //String name = strings[2];
        String _username = strings[2];
        String _password = strings[3];

        try
        {
            URL url = new URL(log_url);



            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

            String post_data="";
            if(type.equals("login"))
            {
                post_data = URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(_username, "UTF-8") + "&"
                        + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(_password, "UTF-8");
            }

            Log.i("DBCON", post_data);

            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();



            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
            String result = "";
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                result += line;
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            Log.i("RES", result);
            return result;
        }catch (Exception io)
        {
            Log.e("DBERROR", io.getMessage());
        }
        
        return null;
    }


}
