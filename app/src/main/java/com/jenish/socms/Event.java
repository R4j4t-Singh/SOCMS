package com.jenish.socms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Event extends AppCompatActivity {
    private static final String connurl ="https://socms.000webhostapp.com/event.php";
    public static List<Event_Data_class> EventList = new ArrayList<>();
    RecyclerView event_recycle;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        fetchdata();
        textView = findViewById(R.id.test);
        event_recycle = findViewById(R.id.Event_recycler);
        event_recycle.setLayoutManager(new GridLayoutManager(Event.this,1));
        event_recycle.setAdapter(new Event_recyler(Event.this,EventList));

    }

    public static  void fetchdata(){
        class db extends AsyncTask<String,Void,String>
        {

            protected void onPostExecute(String info)
            {
                Log.d("Status", info);
            }
            @Override
            protected String doInBackground(String... strings) {
                URL url = null;
                try {
                    url = new URL(strings[0]);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                HttpURLConnection conn = null;
                try {
                    conn = (HttpURLConnection)url.openConnection();
                } catch (IOException e) {
                    return e.getMessage();
                }
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    Gson gson = new Gson();
                    String line = br.readLine();

                    while(line!=null) {
                        Event_Data_class data = gson.fromJson(line, Event_Data_class.class);
                        EventList.add(new Event_Data_class(data.getEvent_ID(), data.getEvent_Type(),data.getEvent_Date(),data.getSociety_ID()));
                        line = br.readLine();
                    }

                    return "Successfull";
                } catch (IOException e) {
                    return e.getMessage();
                }
            }
        }
        db D = new db();
        D.execute(connurl);
    }
}