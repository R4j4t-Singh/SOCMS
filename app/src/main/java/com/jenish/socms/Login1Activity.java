package com.jenish.socms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Login1Activity extends AppCompatActivity {
 SharedPreferences preferences,loginPreferences;
 SharedPreferences.Editor editor,loginPrefsEditor;
 static String username="",password="";
 public static int get_index;
 EditText user,pass;
 TextView error_box;
  private static final String connurl = "http://192.168.233.241/login.php?";
  CardView button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        Members.fetchdata();
        Event.fetchdata();
        user = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        button = findViewById(R.id.log_in);
        error_box = findViewById(R.id.error_box);

        loginPreferences = getSharedPreferences("loginPrefs", 0);

        if (!loginPreferences.getString("username", "").matches(username)) {
            startActivity(new Intent(Login1Activity.this,MainActivity.class) );
            finish();
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                fetchdata();
                username = user.getText().toString();
                password = pass.getText().toString();

                error_box.setText(username);
                if (findAccount(username)) {

                    loginPrefsEditor = loginPreferences.edit();
                    loginPrefsEditor.putString("username", username);
                    loginPrefsEditor.putString("password", password);
                    loginPrefsEditor.commit();

                    Intent intent = new Intent(Login1Activity.this,MainActivity.class);
                    startActivity(intent);

                       finish();
                } else {
//                  error_box.setText(username+"fuck"+Members.datalist.size());
                }
            }
        });
    }

    public  void  fetchdata(){
        class db extends AsyncTask<String,Void,String>{

            protected void onPostExecute(String data){
                preferences = getSharedPreferences("Start",0);
                Log.d("fg", data);
                editor = preferences.edit();
                editor.putString("data",data);
                editor.apply();


            }
            @Override
            protected String doInBackground(String... strings) {
                URL url = null;
                try{
                    url = new URL(strings[0]);
                }catch (MalformedURLException e){
                    e.printStackTrace();
                }
                HttpURLConnection conn = null;

                try {
                    conn = (HttpURLConnection)url.openConnection();
                }catch (IOException e){
                    return  e.getMessage();
                }

                try{

                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String data = br.readLine();
                     return  data;
                }catch (IOException e){
                    return  e.getMessage();
                }

            }
        }
        db D = new db();
        D.execute(connurl+"username="+username+"&password="+password);
    }

    public  Boolean findAccount(String username){

       for(int i=0;i<Members.datalist.size();i++){

           if(Members.datalist.get(i).getName().matches(username)){
               get_index = i;
               return  true;
           }
       }
       return  false;
    }
}