package com.example.playerservices;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {

    MediaPlayer Player;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate(){

        Toast.makeText(this,"Service Created....!",Toast.LENGTH_SHORT).show();
        Player = MediaPlayer.create(this, R.raw.music);
        Player.setLooping(true);
        Player.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "Service Started....!", Toast.LENGTH_SHORT).show();
        Player.start();
//        return START_STICKY;
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {

        Toast.makeText(this, "Service Destroyed....!", Toast.LENGTH_SHORT).show();
      /* super.onDestroy();
       Player.stop();*/
        Player.release();

    }
}
