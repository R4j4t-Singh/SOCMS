package com.jenish.socms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class Members extends AppCompatActivity {
   public static RecyclerView recycle_view1;
   CardView winga,wingb,wingc,wingd,winge;
    private static final String connurl ="http://192.168.195.241/member.php";
    public static List<DataClass> datalist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        datalist.add(new DataClass("JENISH DESAI","101"));
//        datalist.add(new DataClass("JIGYASHU GUPTA ","101"));
//        datalist.add(new DataClass("CHINAMY BHALODIYA","101"));
//        datalist.add(new DataClass("RAJAT SINGH","401"));
//        datalist.add(new DataClass("VIVEK BOROLE","501"));

        setContentView(R.layout.activity_members);
        recycle_view1 = findViewById(R.id.member_recycle_view);

        winga = findViewById(R.id.Wing_A);
        wingb  = findViewById(R.id.Wing_B);
        wingc  = findViewById(R.id.Wing_C);
        wingd  = findViewById(R.id.Wing_D);
        winge  = findViewById(R.id.Wing_E);
        winga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchdata();
                ArrayList<DataClass> arrayList_sort = new ArrayList<>();
                for (int i = 0; i < datalist.size(); i++) {
                    if (datalist.get(i).getWing_ID().equals("S001A")) {
                        arrayList_sort.add(datalist.get(i));
                    }
                }
                recycle_view1.setLayoutManager(new GridLayoutManager(Members.this,2));
                recycle_view1.setAdapter(new Recycle_view(Members.this,  arrayList_sort));
                datalist.clear();
            }
        });

        wingb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchdata();
                ArrayList<DataClass> arrayList_sort = new ArrayList<>();
                for (int i = 0; i < datalist.size(); i++) {
                    if (datalist.get(i).getWing_ID().equals("S001B")) {
                        arrayList_sort.add(datalist.get(i));
                    }
                }
                recycle_view1.setLayoutManager(new GridLayoutManager(Members.this,2));
                recycle_view1.setAdapter(new Recycle_view(Members.this,arrayList_sort));
                datalist.clear();
            }
        });

        wingc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchdata();
                ArrayList<DataClass> arrayList_sort = new ArrayList<>();
                for (int i = 0; i < datalist.size(); i++) {
                    if (datalist.get(i).getWing_ID().equals("S001C")) {
                        arrayList_sort.add(datalist.get(i));
                    }
                }
                recycle_view1.setLayoutManager(new GridLayoutManager(Members.this,2));
                recycle_view1.setAdapter(new Recycle_view(Members.this,arrayList_sort));
                datalist.clear();
            }
        });

        wingd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchdata();
                ArrayList<DataClass> arrayList_sort = new ArrayList<>();
                for (int i = 0; i < datalist.size(); i++) {
                    if (datalist.get(i).getWing_ID().equals("S001D")) {
                        arrayList_sort.add(datalist.get(i));
                    }
                }
                recycle_view1.setLayoutManager(new GridLayoutManager(Members.this,2));
                recycle_view1.setAdapter(new Recycle_view(Members.this,arrayList_sort));
                datalist.clear();
            }
        });

        winge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchdata();
                ArrayList<DataClass> arrayList_sort = new ArrayList<>();
                for (int i = 0; i < datalist.size(); i++) {
                    if (datalist.get(i).getWing_ID().equals("S001E")) {
                        arrayList_sort.add(datalist.get(i));
                    }
                }
                recycle_view1.setLayoutManager(new GridLayoutManager(Members.this,2));
                recycle_view1.setAdapter(new Recycle_view(Members.this,arrayList_sort));
                datalist.clear();
            }
        });

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
                        DataClass data = gson.fromJson(line, DataClass.class);
                        datalist.add(new DataClass(data.getName(), data.getFlat_ID(),data.getWing_ID()));
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
    public ArrayList<DataClass> filter(String wing_ID) {
        ArrayList<DataClass> arrayList_sort = new ArrayList<>();
        for (int i = 0; i < datalist.size(); i++) {
            if (datalist.get(i).getWing_ID() == wing_ID) {
                arrayList_sort.add(datalist.get(i));
            }
        }

        return arrayList_sort;
    }
}