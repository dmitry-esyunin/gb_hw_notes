package com.gb1919.gb_hw_notes;

public class Note {

    private String name;
    private String text;
    private long timestamp;
    private long index;
    private long fragment_id;


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




}
