package com.jenish.socms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SignInActivity extends AppCompatActivity {
EditText username,password,member_id,flat_id,wing_id,dob,mobile;
String user_sign,pass_sign,mem_id_sign,flat_id_sign,wing_id_sign,dob_sign,mobile_no;
TextView test;
CardView sign_button;
private static final String connurl = "https://socms.000webhostapp.com/signup.php?";
    @Override
    //*NfpzSf^MYV$Ll^gsrLc
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        username = findViewById(R.id.username_sign_up);
        password = findViewById(R.id.password_sign_up);
        sign_button = findViewById(R.id.SIGN_UP);
        flat_id = findViewById(R.id.flat_id_SIGN_UP);
        wing_id = findViewById(R.id.wing_id_sign_up);
        dob = findViewById(R.id.DOB_SIGN_UP);
        test = findViewById(R.id.testid);
        mobile = findViewById(R.id.mobile_SIGN_UP);
       sign_button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {


               user_sign = username.getText().toString();
               pass_sign = password.getText().toString();

               flat_id_sign = flat_id.getText().toString();
               wing_id_sign = wing_id.getText().toString();
               dob_sign = dob.getText().toString();
               mobile_no = mobile.getText().toString();

               if(user_sign.isEmpty()||pass_sign.isEmpty()||flat_id_sign.isEmpty()||wing_id_sign.isEmpty()||dob_sign.isEmpty()||mobile_no.isEmpty()){
                   Toast.makeText(SignInActivity.this, "Fill All Fields", Toast.LENGTH_SHORT).show();
               }else{
                   fetchdata();
               }

           }
       });
    }

    public  void  fetchdata(){
        class db extends AsyncTask<String,Void,String> {

            protected void onPostExecute(String data){
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
                    return  "Successfull";
                }catch (IOException e){
                    return  e.getMessage();
                }
            }
        }
        db D = new db();
        D.execute(connurl+"username="+user_sign+"&password="+pass_sign+"&flatID="+flat_id_sign+"&wingID="+wing_id_sign+"&dob="+dob_sign+"&mobileno="+mobile_no);
    }
}