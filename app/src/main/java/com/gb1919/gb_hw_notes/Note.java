package com.gb1919.gb_hw_notes;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable {

    private String name;
    private String text;
    private long timestamp;
    private long index;


    public Note(String name, String text, long timestamp) {
        this.name = name;
        this.text = text;
        this.timestamp = timestamp;
    }


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

    }
}
