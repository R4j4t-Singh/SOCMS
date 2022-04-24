package com.jenish.socms;

public class DataClass {
    String Member_ID,Name,PASSWORD,Flat_ID,Wing_ID,D_O_B;

    public DataClass(String member_ID, String name, String PASSWORD, String flat_ID, String wing_ID, String d_O_B) {
        Member_ID = member_ID;
        Name = name;
        this.PASSWORD = PASSWORD;
        Flat_ID = flat_ID;
        Wing_ID = wing_ID;
        D_O_B = d_O_B;
    }

    public String getMember_ID() {
        return Member_ID;
    }

    public String getName() {
        return Name;
    }

    public String getFlat_ID() {
        return Flat_ID;
    }

    public String getWing_ID() {
        return Wing_ID;
    }

    public String getD_O_B() {
        return D_O_B;
    }

    public DataClass(String name, String flat_ID,String wing_ID) {
        Name = name;
        Flat_ID = flat_ID;
        Wing_ID = wing_ID;
    }
}
