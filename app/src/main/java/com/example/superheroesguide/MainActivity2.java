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
    TextView textView,textView2,textView4,textView5,textView6,textView7,textView8,textView9;
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
        textView4=findViewById(R.id.textView4);
        textView5=findViewById(R.id.textView5);
        textView6=findViewById(R.id.textView6);
        textView7=findViewById(R.id.textView7);
        textView8=findViewById(R.id.textView8);
        textView9=findViewById(R.id.textView9);

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
        textView4.setText("⭕️Power: "+power);
        textView5.setText("⭕️Intelligence: "+intelligence);
        textView6.setText("⭕️Strength: "+strength);
        textView7.setText("⭕️Combat: "+combat);
        textView8.setText("⭕️Speed:"+speed);
        textView9.setText("⭕️Durability: "+durability);

        textView2.setText("📌Gender: "+gender+"   📌Race: "+race+"   📌Height(feet): "+height+"   📌Weight(kgs): "+weight+"   📌Eyecolor: "+eyecolor+"   📌Haircolor: "+haircolor+"   📌Fullname: "+fullname+"    📌First_Appearance: "+first_appearance+"   📌Publisher: "+publisher+"   📌Birth_Place: "+birth_place+"   📌Occupation: "+occupation);
        Glide.with(context1).load(url).into(imageView1);

    }

}