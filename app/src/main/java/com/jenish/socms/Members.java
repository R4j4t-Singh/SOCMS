package com.jenish.socms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class Members extends AppCompatActivity {
   public static RecyclerView recycle_view1;
   CardView winga,wingb,wingc,wingd,winge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<DataClass> datalist = new ArrayList<>();
        datalist.add(new DataClass("JENISH DESAI","101"));
        datalist.add(new DataClass("JIGYASHU GUPTA ","201"));
        datalist.add(new DataClass("CHINAMY BHALODIYA","301"));
        datalist.add(new DataClass("RAJAT SINGH","401"));
        datalist.add(new DataClass("VIVEK BOROLE","501"));

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
                recycle_view1.setLayoutManager(new GridLayoutManager(Members.this,2));
                recycle_view1.setAdapter(new Recycle_view(Members.this,datalist,0));
            }
        });

        wingb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recycle_view1.setLayoutManager(new GridLayoutManager(Members.this,2));
                recycle_view1.setAdapter(new Recycle_view(Members.this,datalist,1));
            }
        });

        wingc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recycle_view1.setLayoutManager(new GridLayoutManager(Members.this,2));
                recycle_view1.setAdapter(new Recycle_view(Members.this,datalist,2));
            }
        });

        wingd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recycle_view1.setLayoutManager(new GridLayoutManager(Members.this,2));
                recycle_view1.setAdapter(new Recycle_view(Members.this,datalist,3));
            }
        });

        winge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recycle_view1.setLayoutManager(new GridLayoutManager(Members.this,2));
                recycle_view1.setAdapter(new Recycle_view(Members.this,datalist,4));
            }
        });




    }
}