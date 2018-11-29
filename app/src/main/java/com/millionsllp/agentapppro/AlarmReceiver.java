package com.millionsllp.agentapppro;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Intent background = new Intent(context, MyLocation.class);
            context.startService(background);


        }


}
