package com.example.syl.music;

import android.os.Parcel;
import android.os.Parcelable;

public class Song implements Parcelable {
    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };
    private int mIcon;
    private String mArtist;
    private String mTitle;
    private int mNowPlayingImage;

    public Song(int icon, String artist, String title, int nowPlayingImage) {
        mIcon = icon;
        mArtist = artist;
        mTitle = title;
        mNowPlayingImage = nowPlayingImage;

    }

    protected Song(Parcel in) {
        mIcon = in.readInt();
        mArtist = in.readString();
        mTitle = in.readString();
        mNowPlayingImage = in.readInt();

    }

    public int getIconID() {
        return mIcon;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getArtist() {
        return mArtist;
    }

    public int getNowPlayingImageID() {

        return mNowPlayingImage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mIcon);
        dest.writeString(mArtist);
        dest.writeString(mTitle);
        dest.writeInt(mNowPlayingImage);

    }
}
