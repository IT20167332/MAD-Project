package com.example.oppy.DatabaseTable;

public class Sehedules {


    private String title,item,type,qty;
    private String date,time,vehicleNo,destination,maxTime;

    public Sehedules() {
    }

    public Sehedules(String title, String item,
                     String type, String qty,
                     String date, String time,
                     String vehicleNo, String destination, String maxTime) {
        this.title = title;
        this.item = item;
        this.type = type;
        this.qty = qty;
        this.date = date;
        this.time = time;
        this.vehicleNo = vehicleNo;
        this.destination = destination;
        this.maxTime = maxTime;
    }

    //setters and getters


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(String maxTime) {
        this.maxTime = maxTime;
    }
}
