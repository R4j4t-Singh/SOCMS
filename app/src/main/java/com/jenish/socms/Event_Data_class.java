package com.jenish.socms;

public class Event_Data_class {
    String Event_Type,Event_ID,Event_Date,Society_ID;

    public Event_Data_class(String Event_ID, String Event_Type, String Event_Date, String Society_ID) {
        this.Event_Type = Event_Type;
        this.Event_ID = Event_ID;
        this.Event_Date = Event_Date;
        this.Society_ID = Society_ID;
    }

    public String getEvent_Type() {
        return Event_Type;
    }

    public String getEvent_ID() {
        return Event_ID;
    }

    public String getEvent_Date() {
        return Event_Date;
    }

    public String getSociety_ID() {
        return Society_ID;
    }
}
