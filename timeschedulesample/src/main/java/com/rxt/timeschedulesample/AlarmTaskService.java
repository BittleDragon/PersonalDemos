package com.rxt.timeschedulesample;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.util.Log;

import java.io.IOException;

/**
 * Created by raoxuting on 2017/7/11.
 */

public class AlarmTaskService extends Service {

    private MediaPlayer mediaPlayer;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("服务创建", "走了");
        if (mediaPlayer == null)
            mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                AlarmTaskService.this.stopSelf();
            }
        });
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                playMusic();
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    private void playMusic() {
        Log.e("播放音乐", "走了");
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            mediaPlayer.reset();
            try {
                mediaPlayer.setDataSource(this, Uri.parse("android.resource://"
                        + getPackageName() + "/" + R.raw.piano));
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mediaPlayer.start();
            mediaPlayer.setLooping(false);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }
}
