package com.example.oppy.DatabaseTable;

public class Vehicles {

    String number,type,key,driverId;

    public Vehicles(String number, String type, String key, String driverId) {
        this.number = number;
        this.type = type;
        this.key = key;
        this.driverId = driverId;
    }

    public Vehicles() {


    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }
}
