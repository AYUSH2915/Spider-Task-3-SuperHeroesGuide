package com.example.superheroesguide;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MainActivity2 extends AppCompatActivity {
    ImageView imageView1;
    TextView textView,textView2;
    String url,name;
    int intelligence,strength,speed,durability,power,combat;
    String gender,race,height,weight,eyecolor,haircolor,fullname,first_appearance,publisher,birth_place,occupation;
    Context context1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context1=MainActivity2.this;

        setContentView(R.layout.activity_main2);
        imageView1=findViewById(R.id.imageView);
        textView=findViewById(R.id.textView);
        textView2=findViewById(R.id.textView2);
        getData();
        setData();

    }
    private void getData() {
        if (getIntent().hasExtra("url") && getIntent().hasExtra("name")) {
            url = getIntent().getStringExtra("url");
            name = getIntent().getStringExtra("name");
            intelligence=getIntent().getIntExtra("intelligence",0);
            strength=getIntent().getIntExtra("strength",0);
            speed=getIntent().getIntExtra("speed",0);
            power=getIntent().getIntExtra("power",0);
            durability=getIntent().getIntExtra("durability",0);
            combat=getIntent().getIntExtra("combat",0);
            gender=getIntent().getStringExtra("gender");
            race=getIntent().getStringExtra("race");
            height=getIntent().getStringExtra("height");
            weight=getIntent().getStringExtra("weight");
            eyecolor=getIntent().getStringExtra("eyecolor");
            haircolor=getIntent().getStringExtra("haircolor");
            fullname=getIntent().getStringExtra("fullname");
            first_appearance=getIntent().getStringExtra("firstappearance");
            publisher=getIntent().getStringExtra("publisher");
            birth_place=getIntent().getStringExtra("birthplace");
            occupation=getIntent().getStringExtra("occupation");









        } else {
            Toast.makeText(this, "Error Occured", Toast.LENGTH_SHORT).show();
        }
    }
    private void setData(){
        textView.setText(name);
        textView2.setText("📌Intelligence: "+intelligence+"   📌Strength: "+strength+"   📌Speed: "+speed+"   📌Durability: "+durability+"   📌Power: "+power+"   📌Combat: "+combat+"   📌Gender: "+gender+"   📌Race: "+race+"   📌Height(feet): "+height+"   📌Weight(kgs): "+weight+"   📌Eyecolor: "+eyecolor+"   📌Haircolor: "+haircolor+"   📌Fullname: "+fullname+"    📌First_Appearance: "+first_appearance+"   📌Publisher: "+publisher+"   📌Birth_Place: "+birth_place+"   📌Occupation: "+occupation);
        Glide.with(context1).load(url).into(imageView1);

    }

}