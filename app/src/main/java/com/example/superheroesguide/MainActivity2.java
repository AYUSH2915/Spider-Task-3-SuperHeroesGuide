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
    String url,name,height1,weight1,temperament1,country1,breed_type1,bred_for1,lifespan1;
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









        } else {
            Toast.makeText(this, "Error Occured", Toast.LENGTH_SHORT).show();
        }
    }
    private void setData(){
        textView.setText(name);


        Glide.with(context1).load(url).into(imageView1);

    }

}