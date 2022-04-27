package com.jenish.socms;

public class DataClass {
    String Member_ID,Name,Flat_ID,Wing_ID,D_O_B,Contact;

    public DataClass(String Member_ID, String Name, String Flat_ID, String Wing_ID, String D_O_B,String Contact) {
        this.Member_ID = Member_ID;
        this.Name = Name;
        this.Flat_ID = Flat_ID;
        this.Wing_ID = Wing_ID;
        this.D_O_B = D_O_B;
        this.Contact = Contact;
    }

    public String getContact() { return Contact; }

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
