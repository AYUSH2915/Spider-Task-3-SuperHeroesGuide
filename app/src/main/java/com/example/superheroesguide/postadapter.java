package com.example.superheroesguide;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class postadapter extends RecyclerView.Adapter<postadapter.PostHolder> {

    Context context;
    List<items>postList;

    public postadapter(Context context, List<items> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(context).inflate(R.layout.each_post, parent, false);
        return new PostHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {

        items items = postList.get(position);
        holder.setImageView(items.getImageurl());
        holder.setname(items.getId());
        String url= items.getImageurl();
        String name=items.getId();
        int intelligence= items.getIntelligence();
        int strength=items.getStrength();
        int power=items.getPower();
        int speed= items.getSpeed();
        int durability=items.getDurability();
        int combat= items.getCombat();
        String gender=items.getGender();
        String race= items.getRace();
        String height=items.getHeight();
        String weight= items.getWeight();
        String eyecolor=items.getEyecolor();
        String haircolor= items.getHaircolor();
        String fullname=items.getFullname();
        String firstappearance= items.getFirst_appearance();
        String publisher=items.getPublisher();
        String birthplace= items.getBirth_place();
        String occupation=items.getOccupation();

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,MainActivity2.class);
                intent.putExtra("url",url);
                intent.putExtra("name",name);
                intent.putExtra("intelligence",intelligence);
                intent.putExtra("strength",strength);
                intent.putExtra("speed",speed);
                intent.putExtra("power",power);
                intent.putExtra("durability",durability);
                intent.putExtra("combat",combat);
                intent.putExtra("gender",gender);
                intent.putExtra("race",race);
                intent.putExtra("height",height);
                intent.putExtra("weight",weight);
                intent.putExtra("eyecolor",eyecolor);
                intent.putExtra("haircolor",haircolor);
                intent.putExtra("fullname",fullname);
                intent.putExtra("firstappearance",firstappearance);
                intent.putExtra("publisher",publisher);
                intent.putExtra("birthplace",birthplace);
                intent.putExtra("occupation",occupation);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class PostHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name;
        View view;
        ConstraintLayout mainLayout;

        public PostHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            mainLayout=itemView.findViewById(R.id.mainLayout);

        }

        public void setImageView(String url) {
            imageView = view.findViewById(R.id.imageview);
            Glide.with(context).load(url).into(imageView);
        }

        public void setname(String name1) {
            name = view.findViewById(R.id.name);
            name.setText(name1);
        }

    }
}
