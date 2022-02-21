package com.gb1919.gb_hw_notes;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable {

    private String name;
    private String text;
    private long timestamp;



    public Note(String name, String text, long timestamp) {
        this.name = name;
        this.text = text;
        this.timestamp = timestamp;
    }


    protected Note(Parcel in) {
        name = in.readString();
        text = in.readString();
        timestamp = in.readLong();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public void setName(String name) {
        this.name = name;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getName() {
        return this.name;
    }
    public String getText() {
        return this.text;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(text);
        parcel.writeLong(timestamp);
    }

}
