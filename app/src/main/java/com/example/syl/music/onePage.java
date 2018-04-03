package com.example.syl.music;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by syl on 2018. 03. 24..
 */

public class onePage extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);
        //Creating an ArrayList of the custom class "Song" to display the info about the music files
        ArrayList<Song> songs = new ArrayList<Song>();

        //Populating the ArrayList

        songs.add(new Song(R.drawable.jay_z, "Jay-Z @ Rhianna & Kanye West", "We run this town", R.drawable.art_werun));
        songs.add(new Song(R.drawable.nickel, "Nickelback", "Rockstar", R.drawable.art_rockstar));
        songs.add(new Song(R.drawable.shon, "Shontelle", "Impossible", R.drawable.art_impossible));
        songs.add(new Song(R.drawable.youn, "Young Soul Rebels", "I got Soul", R.drawable.art_i_got_soul));

        //Creating a GridView to display the tracks
        SongAdapter adapter = new SongAdapter(this, songs, R.color.iconcolor);

        GridView musicGridView = (GridView) findViewById(R.id.grid);
        musicGridView.setAdapter(adapter);
        musicGridView.setBackgroundColor(getResources().getColor(R.color.backgroundcolor));
    }
}




