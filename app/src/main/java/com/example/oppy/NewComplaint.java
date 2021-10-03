package com.example.oppy;

public class NewComplaint {
    private String Complaint;
    private String Date;
    private String Userid;
    public NewComplaint(){}
    public NewComplaint(String complaint, String date, String userid) {
        Complaint = complaint;
        Date = date;
        Userid = userid;
    }

    public String getComplaint() {
        return Complaint;
    }

    public void setComplaint(String complaint) {
        Complaint = complaint;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getUserid() {
        return Userid;
    }

    public void setUserid(String userid) {
        Userid = userid;
    }
}
