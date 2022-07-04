package com.example.actapp.db_connections;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetConn {

    public static boolean isConnectedToTheInternet(Context context) {
        ConnectivityManager cons = (ConnectivityManager)
                context.getSystemService(context.CONNECTIVITY_SERVICE);
        if (cons != null) {
            NetworkInfo[] info = cons.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }

        }
        return false;

    }
}
