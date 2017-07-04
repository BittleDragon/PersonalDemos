package com.demoapplication.starryskydemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

/**
 * 播放音乐服务
 * Created by raoxuting on 2017/7/4.
 */

public class PlayMusicService extends Service {

    private MediaPlayer mediaPlayer;

    @Override
    public IBinder onBind(Intent intent) {
        return new PlayMusicBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (mediaPlayer == null)
            mediaPlayer = new MediaPlayer();
    }

    private void playMusic() {
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            //重置播放器
            mediaPlayer.reset();
            //绑定资源
            mediaPlayer = MediaPlayer.create(this, R.raw.yiruma_river_flows_in_you);
            //开始播放
            mediaPlayer.start();
            //是否循环
            mediaPlayer.setLooping(true);
        }
    }

    public class PlayMusicBinder extends Binder {

        public void startPlayMusic() {
            playMusic();
        }

        public void stopPlayMusic() {
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.release();
            }
        }

        public void pauseMusic() {
            if (mediaPlayer != null)
                mediaPlayer.pause();
        }
    }
}
