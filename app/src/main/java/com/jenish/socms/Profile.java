package com.jenish.socms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Profile extends AppCompatActivity {
     TextView Name,Wing_ID,Flat_ID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Wing_ID = findViewById(R.id.wing);
        Flat_ID = findViewById(R.id.flat_num);
        Name = findViewById(R.id.profile_name);

       SharedPreferences preferences = getSharedPreferences("loginPrefs",0);
       int index = preferences.getInt("index",0);
//        String  datan = preferences.getString("data","");
//
//        Gson gson = new Gson();
//        DataClass data = gson.fromJson(datan,DataClass.class);
//
//        Name.setText(data.getName());
//        Wing_ID.setText(data.getWing_ID());
//        Flat_ID.setText(data.getFlat_ID());

        Name.setText(Members.datalist.get(index).getName());
        Wing_ID.setText(Members.datalist.get(index).getWing_ID());
        Flat_ID.setText(Members.datalist.get(index).getFlat_ID());
    }

}
