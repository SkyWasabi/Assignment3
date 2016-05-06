package com.example.dakeh.assignment3;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

import java.util.Date;

/**
 * Created by dakeh on 5/2/2016.
 */
public class Clipping {
    int id;
    String notes;
    int drawableid;
    String date;
    long fkid;

    public Clipping() {};

    public Clipping(String notes, int drawableid, String date) {
        this.notes = notes;
        this.drawableid = drawableid;
        this.date = date;
    }

    public Clipping(String notes, int drawableid, String date, long fkid) {
        this.notes = notes;
        this.drawableid = drawableid;
        this.date = date;
        this.fkid = fkid;
    }

    public Clipping(int id, String notes, int drawableid, String date) {
        this.id = id;
        this.notes = notes;
        this.drawableid = drawableid;
        this.date = date;
    }

    public Clipping(int id, String notes, int drawableid, String date, long fkid) {
        this.id = id;
        this.notes = notes;
        this.drawableid = drawableid;
        this.date = date;
        this.fkid = fkid;
    }

    public int getId() {return id;}

    public String getNotes() {return notes;}

    public int getDrawableid() {return drawableid;}

    public String getDate() {return date;}

    public long getFkid() {return fkid;}

    public void setID(int id) {
        this.id = id;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setDrawableid(int drawableid) {
        this.drawableid = drawableid;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setFkid(long fkid) {
        this.fkid = fkid;
    }

}
