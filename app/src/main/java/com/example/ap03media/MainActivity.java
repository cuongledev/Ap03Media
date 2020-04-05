package com.example.ap03media;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_play_one;
    Button btn_stop;
    private MediaPlayer backgroundMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        backgroundMusic = MediaPlayer.create(this, R.raw.best_player);
        backgroundMusic.setLooping(true);
        backgroundMusic.start();
        btn_play_one = findViewById(R.id.btn_play_1);
        btn_stop = findViewById(R.id.btn_stop);
        btn_play_one.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_play_1:

                MediaPlayer player = MediaPlayer.create(this, R.raw.best_player);
                player.start();

            break;
            case R.id.btn_stop:

                backgroundMusic.stop();
                backgroundMusic.release();

                break;

            default:
                break;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        backgroundMusic.pause();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!backgroundMusic.isPlaying()){
            backgroundMusic.start();
        }
    }
}
