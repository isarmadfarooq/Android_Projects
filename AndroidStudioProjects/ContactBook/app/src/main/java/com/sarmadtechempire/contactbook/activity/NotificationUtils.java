package com.sarmadtechempire.contactbook.activity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import com.sarmadtechempire.contactbook.R;

public class NotificationUtils {
    private static final String CHANNEL_ID = "contact_channel_id";
    private static final int NOTIFICATION_ID = 100;
    private static final int REQUEST_CODE = 100;

    public static void showNotification(Context context, String title, String message, int imageResId) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Drawable drawable = ContextCompat.getDrawable(context, imageResId);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap largeIcon = bitmapDrawable.getBitmap();

        Intent iNotify = new Intent(context, MainActivity.class);
        iNotify.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pi = PendingIntent.getActivity(context, REQUEST_CODE, iNotify, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle()
                .bigPicture(largeIcon)
                .bigLargeIcon(largeIcon)
                .setBigContentTitle(title)
                .setSummaryText(message);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Contact Notification", NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setLargeIcon(((BitmapDrawable) (ResourcesCompat.getDrawable(context.getResources(), R.drawable.contact_book, null))).getBitmap())
                .setSmallIcon(R.drawable.new_contact)
                .setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true)
                .setOngoing(true)
                .setStyle(bigPictureStyle)
                .setContentIntent(pi)
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }
}
