package com.example.oppy.DatabaseTable;

public class SpNote {

    String date,Stitle,Emid,Note,key,schId;

    public SpNote(String date, String stitle, String emid, String note, String schId) {
        this.date = date;
        Stitle = stitle;
        Emid = emid;
        Note = note;
        this.schId = schId;
    }
    public SpNote(String date, String stitle, String emid, String note, String schId,String key) {
        this.date = date;
        Stitle = stitle;
        Emid = emid;
        Note = note;
        this.schId = schId;
        this.key = key;
    }

    public String getSchId() {
        return schId;
    }

    public void setSchId(String schId) {
        this.schId = schId;
    }

    public SpNote() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStitle() {
        return Stitle;
    }

    public void setStitle(String stitle) {
        Stitle = stitle;
    }

    public String getEmid() {
        return Emid;
    }

    public void setEmid(String emid) {
        Emid = emid;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
