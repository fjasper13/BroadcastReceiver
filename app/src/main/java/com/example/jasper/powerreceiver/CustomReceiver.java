package com.example.jasper.powerreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {

    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID+".ACTION_CUSTOM_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        if(intentAction != null){
            String toastMessage = "unknown intent action";
            int state = intent.getIntExtra("state",-1);
            switch (intentAction){
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage = "Power connected!";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage = "Power disconnected";
                    break;
                case ACTION_CUSTOM_BROADCAST:
                    toastMessage = "Custom Broadcast Received";
                    break;
            }
            if(intent.getAction().equals(Intent.ACTION_HEADSET_PLUG)){
                switch (state){
                    case(0):
                        toastMessage = "Headset Unconnected";
                        break;
                    case(1):
                        toastMessage = "Headset Connected";
                        break;
                    default:
                        toastMessage="aaa";
                }
            }
                Toast.makeText(context,toastMessage,Toast.LENGTH_SHORT).show();

        }
    }
}
