package com.example.oppy.DatabaseTable;

public class Warehouse {
    String key,item,date,EId;
    int qty;

    public Warehouse(String item, String date, String EId, int qty) {
        this.item = item;
        this.date = date;
        this.EId = EId;
        this.qty = qty;
    }

    public Warehouse() {
    }

    public Warehouse(String key, String item, String date, String EId, int qty) {
        this.key = key;
        this.item = item;
        this.date = date;
        this.EId = EId;
        this.qty = qty;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEId() {
        return EId;
    }

    public void setEId(String EId) {
        this.EId = EId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
