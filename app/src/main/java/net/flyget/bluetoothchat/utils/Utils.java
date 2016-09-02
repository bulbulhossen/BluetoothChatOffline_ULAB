package net.flyget.bluetoothchat.utils;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import net.flyget.bluetoothchat.R;

public class Utils {
	public static final int NOTIFY_ID1 = 1001;
	
	public static void notifyMessage(Context context, String msg, Activity activity){
		//Notification builder; 
		PendingIntent contentIntent = null; 
		NotificationManager nm;

		nm = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        Intent notificationIntent = new Intent(context, activity.getClass());
        // PendingIntent.getActivity(Context context, int requestCode, Intent intent, int flags)

        contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0); 

        

        int icon = R.drawable.icon;
        long when = System.currentTimeMillis();
        Notification notification = new Notification(icon, msg, when);
        notification.defaults |= Notification.DEFAULT_VIBRATE;
        notification.defaults |= Notification.DEFAULT_SOUND;
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notification.defaults |= Notification.DEFAULT_LIGHTS;
        notification.vibrate = new long[]{300, 500};
        notification.setLatestEventInfo(context, "BluetoothChat", msg, contentIntent);

	     nm.notify(NOTIFY_ID1, notification);
	}
}
