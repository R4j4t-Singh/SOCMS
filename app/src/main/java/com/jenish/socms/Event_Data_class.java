package com.jenish.socms;

public class Event_Data_class {
    String Event_type,Event_ID,Event_date,Event_SOC;

    public Event_Data_class(String event_ID, String event_type, String event_date, String event_SOC) {
        Event_type = event_type;
        Event_ID = event_ID;
        Event_date = event_date;
        Event_SOC = event_SOC;
    }

    public String getEvent_type() {
        return Event_type;
    }

    public String getEvent_ID() {
        return Event_ID;
    }

    public String getEvent_date() {
        return Event_date;
    }

    public String getEvent_SOC() {
        return Event_SOC;
    }
}
