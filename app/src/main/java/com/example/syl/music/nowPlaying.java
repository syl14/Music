package com.example.syl.music;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by syl on 2018. 03. 26..
 */

public class nowPlaying extends AppCompatActivity {

    public static final String EXTRA_SOUND_FILE = "sound";

    Button play, stop, pause;
    MediaPlayer mySound;
    Button btn;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playing);

        //Get the data from previous activity (selected song in the playlist)

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Song file = getIntent().getExtras().getParcelable(EXTRA_SOUND_FILE);

            ImageView nowPlayingFileImage = (ImageView) findViewById(R.id.coverAlbum);
            nowPlayingFileImage.setImageResource(file.getNowPlayingImageID());

            TextView nowPlayingArtistOrAuthor = (TextView) findViewById(R.id.artist_name);
            nowPlayingArtistOrAuthor.setText(file.getArtist());

            TextView nowPlayingTitle = (TextView) findViewById(R.id.songname);
            nowPlayingTitle.setText(file.getTitle());
        }
        btn = (Button) findViewById(R.id.returnToMenu);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnIntent = new Intent(nowPlaying.this, onePage.class);
                startActivity(btnIntent);

            }
        });

        // play one mp3 from the raw folder

        play = (Button) findViewById(R.id.play);
        stop = (Button) findViewById(R.id.stop);
        pause = (Button) findViewById(R.id.pause);
        mySound = MediaPlayer.create(this.getBaseContext(), R.raw.nickelback_rockstar);
        setupListeners();
    }

    private void setupListeners() {
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.pause();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySound.stop();
                mySound = MediaPlayer.create(getBaseContext(), R.raw.nickelback_rockstar);
            }
        });
    }
}



