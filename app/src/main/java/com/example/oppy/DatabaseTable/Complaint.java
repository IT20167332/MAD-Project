package com.example.oppy.DatabaseTable;

public class Complaint {

    String key,ScheduleId,EmId,description,Priority,STitle;

    public Complaint(String scheduleId, String emId, String description, String priority,String STitle) {
        this.STitle = STitle;
        this.ScheduleId = scheduleId;
        this.EmId = emId;
        this.description = description;
        this.Priority = priority;
    }

    public Complaint() {
    }

    public String getSTitle() {
        return STitle;
    }

    public void setSTitle(String STitle) {
        this.STitle = STitle;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getScheduleId() {
        return ScheduleId;
    }

    public void setScheduleId(String scheduleId) {
        ScheduleId = scheduleId;
    }

    public String getEmId() {
        return EmId;
    }

    public void setEmId(String emId) {
        EmId = emId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return Priority;
    }

    public void setPriority(String priority) {
        Priority = priority;
    }
}
