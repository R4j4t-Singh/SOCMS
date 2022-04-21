package com.jenish.socms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Login1Activity extends AppCompatActivity {

 static String usernmae="",password="";
 EditText user,pass;
  String connurl;
  Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        user = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        button = findViewById(R.id.log_in);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                usernmae = user.getText().toString();
                password = pass.getText().toString();

                connurl= "https://10.0.2.2/login.php?username="+usernmae+"&password="+password;
                fetchdata();
            }
        });




    }

    public  void  fetchdata(){
        class db extends AsyncTask<String,Void,String>{

            protected void onPostExecute(String data){
                Log.d("lll", "iddddddddddddddddddddd"+data);
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
        D.execute(connurl);
    }
}