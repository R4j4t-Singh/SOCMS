package com.jenish.socms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Profile extends AppCompatActivity {
     TextView wingno,flat_number;
    String hiduke ="";
    String errmsg="";
    String price="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        wingno = findViewById(R.id.wing);
        flat_number = findViewById(R.id.flat_num);





    }

}
