package com.example.oppy.DatabaseTable;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.database.Exclude;

public class Sehedules implements Parcelable {

    @Exclude
    private String key;
    private String title,item,type,qty;
    private String date,time,vehicleNo,destination,maxTime;
    private boolean status,isWarehouseCheck,isGateCheck;

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

    public Sehedules(String title, String item, String type,
                     String qty, String date, String time,
                     String vehicleNo, String destination,
                     String maxTime, boolean status, boolean isWarehouseCheck, boolean isGateCheck) {

        this.title = title;
        this.item = item;
        this.type = type;
        this.qty = qty;
        this.date = date;
        this.time = time;
        this.vehicleNo = vehicleNo;
        this.destination = destination;
        this.maxTime = maxTime;
        this.status = status;
        this.isWarehouseCheck = isWarehouseCheck;
        this.isGateCheck = isGateCheck;
    }



    //setters and getters

    protected Sehedules(Parcel in) {
        key = in.readString();
        title = in.readString();
        item = in.readString();
        type = in.readString();
        qty = in.readString();
        date = in.readString();
        time = in.readString();
        vehicleNo = in.readString();
        destination = in.readString();
        maxTime = in.readString();
        status = in.readByte() != 0;
        isWarehouseCheck = in.readByte() != 0;
        isGateCheck = in.readByte() != 0;
    }

    public static final Creator<Sehedules> CREATOR = new Creator<Sehedules>() {
        @Override
        public Sehedules createFromParcel(Parcel in) {
            return new Sehedules(in);
        }

        @Override
        public Sehedules[] newArray(int size) {
            return new Sehedules[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(key);
        dest.writeString(title);
        dest.writeString(item);
        dest.writeString(type);
        dest.writeString(qty);
        dest.writeString(date);
        dest.writeString(time);
        dest.writeString(vehicleNo);
        dest.writeString(destination);
        dest.writeString(maxTime);
        dest.writeByte((byte) (status ? 1 : 0));
        dest.writeByte((byte) (isWarehouseCheck ? 1 : 0));
        dest.writeByte((byte) (isGateCheck ? 1 : 0));
    }
    //Key is here


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isWarehouseCheck() {
        return isWarehouseCheck;
    }

    public void setWarehouseCheck(boolean warehouseCheck) {
        isWarehouseCheck = warehouseCheck;
    }

    public boolean isGateCheck() {
        return isGateCheck;
    }

    public void setGateCheck(boolean gateCheck) {
        isGateCheck = gateCheck;
    }


}
