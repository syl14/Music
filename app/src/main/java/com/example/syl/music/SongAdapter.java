package com.example.syl.music;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by syl on 2018. 03. 27..
 */

public class SongAdapter extends ArrayAdapter<Song> {

    private static final String LOG_TAG = SongAdapter.class.getSimpleName();

    private int mItemBgColor;
    private Context activityContext;

    public SongAdapter(Activity context, ArrayList<Song> musicFiles, int itemBgColor) {
        super(context, 0, musicFiles);
        mItemBgColor = itemBgColor;
        activityContext = context;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View gridItemView = convertView;
        if (gridItemView == null) {
            gridItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.music_source, parent, false);
        }

        //Display icons and file info.
        final Song currentSoundFile = getItem(position);
        ImageView iconImageView = (ImageView) gridItemView.findViewById(R.id.icon);
        iconImageView.setImageResource(currentSoundFile.getIconID());

        TextView authorTextView = (TextView) gridItemView.findViewById(R.id.author);
        authorTextView.setText(currentSoundFile.getArtist());

        TextView titleTextView = (TextView) gridItemView.findViewById(R.id.title);
        titleTextView.setText(currentSoundFile.getTitle());

        //Setting the background color for each grid item.
        LinearLayout playFile = gridItemView.findViewById(R.id.layout);
        int color = ContextCompat.getColor(getContext(), mItemBgColor);
        playFile.setBackgroundColor(color);

        //Opening the nowPlaying activity upon clicking anywhere in the grid item.
        playFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nowPlayingIntent = new Intent(activityContext, nowPlaying.class);
                nowPlayingIntent.putExtra(nowPlaying.EXTRA_SOUND_FILE, currentSoundFile);
                activityContext.startActivity(nowPlayingIntent);
            }
        });


        return gridItemView;
    }
}


