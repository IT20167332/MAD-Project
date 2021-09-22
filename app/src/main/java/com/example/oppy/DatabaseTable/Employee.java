package com.example.oppy.DatabaseTable;

public class Employee {

    private String userName;
    private String password;
    private String email;
    private int phone;
    private String position;

    public Employee() {
    }

    public Employee(String userName, String password, String email, int phone,String position) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }


}
