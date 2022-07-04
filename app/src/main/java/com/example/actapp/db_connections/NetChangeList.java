package com.example.actapp.db_connections;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.actapp.R;

public class NetChangeList extends BroadcastReceiver {

   public static boolean isConnected;

    public boolean NetChangeList() {
        return isConnected;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        isConnected = NetConn.isConnectedToTheInternet(context);

        if (!isConnected)
        {
            isConnected =false;


            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            View layoutDiag = LayoutInflater.from(context).inflate(R.layout.check_net_diag, null);
            builder.setView(layoutDiag);


            Button btnRetry = layoutDiag.findViewById(R.id.btnRetry);
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            alertDialog.setCancelable(false);


            alertDialog.getWindow().setGravity(Gravity.CENTER);
            btnRetry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialog.dismiss();
                    onReceive(context, intent);
                }
            });


        }
        else
        {
            isConnected = true;
            Log.i("NNET", "NO NEEEEEEEEEEEEEEEEEEET");
        }
    }
}
