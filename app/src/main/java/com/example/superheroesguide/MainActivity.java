package com.example.superheroesguide;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RequestQueue requestQueue;

    private List<items> mList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue = VolleySingleton.getmInstance(this).getRequestQueue();

        mList = new ArrayList<>();
        fetchData();
    }

    private void fetchData() {

        String url = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/all.json";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {



                    for(int i = 0 ; i<response.length() ; i++){


                        JSONObject jsonObject = response.getJSONObject(i);
                        String image = jsonObject.getString("slug");
                        JSONObject powerstats= jsonObject.getJSONObject("powerstats");
                        JSONObject appearance= jsonObject.getJSONObject("appearance");
                        JSONObject biography= jsonObject.getJSONObject("biography");
                        JSONObject work= jsonObject.getJSONObject("work");
                        JSONArray height1=appearance.getJSONArray("height");
                        JSONArray weight1=appearance.getJSONArray("weight");
                        int intelligence,strength,speed,durability,power,combat;
                        String gender,race,height,weight,eyecolor,haircolor,fullname,first_appearance,publisher,birth_place,occupation;
                        intelligence=powerstats.getInt("intelligence");
                        strength=powerstats.getInt("strength");
                        speed=powerstats.getInt("speed");
                        durability=powerstats.getInt("durability");
                        power=powerstats.getInt("power");
                        combat=powerstats.getInt("combat");
                        gender=appearance.getString("gender");
                        race=appearance.getString("race");
                        height=height1.getString(0);
                        weight=weight1.getString(1);
                        eyecolor=appearance.getString("eyeColor");
                        haircolor=appearance.getString("hairColor");
                        fullname=biography.getString("fullName");
                        first_appearance=biography.getString("firstAppearance");
                        publisher=biography.getString("publisher");
                        birth_place=biography.getString("placeOfBirth");
                        occupation=work.getString("occupation");
                        String imageUrl="https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/md/"+image+".jpg";
                        String name = jsonObject.getString("name");



                        items post = new items(imageUrl,name,intelligence,strength,speed,durability,power,combat,gender,race,height,weight,eyecolor,haircolor,fullname,first_appearance,publisher,birth_place,occupation);
                        mList.add(post);

                    }

                    postadapter adapter = new postadapter(MainActivity.this , mList);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } ,new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonArrayRequest);
    }


}

