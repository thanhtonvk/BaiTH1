package com.tondz.baith1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class MessageBroadCast extends BroadcastReceiver {
    private static final String SMS_RECEVIED = "android.provider.Telephony.SMS_RECEIVED";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction()==SMS_RECEVIED){
            Bundle bundle= intent.getExtras();
            if(bundle !=null){
                Object[] pdus=(Object[])bundle.get("pdus");
                SmsMessage[]smsMessages= new SmsMessage[pdus.length];
                for (int i=0;i<pdus.length;i++){
                    smsMessages[i]=SmsMessage.createFromPdu((byte[])pdus[i]);
                }
                Toast.makeText(context,smsMessages[0].getMessageBody(),Toast.LENGTH_LONG).show();
                Log.e("TinNhan",smsMessages[0].getMessageBody());
            }
        }
    }
}
