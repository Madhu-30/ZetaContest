package com.example.zetacontest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.textclassifier.ConversationActions;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView tname,tcategory,tlabel,tdes;
    private RecyclerView recyclerView;
    List<RecipeClass> menus;

    private static String jsonURL = "https://s3-ap-southeast-1.amazonaws.com/he-public-data/reciped9d7b8c.json";
    Adapter adapter;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        menus = new ArrayList<>();

        extract();


//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }

    private void extract(){

        requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, jsonURL, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        try {
                            for(int i= 0; i<response.length() ; i++){
                                JSONObject jsonObject = response.getJSONObject(i);

                                RecipeClass recipeClass = new RecipeClass();

                                recipeClass.setCategory(jsonObject.getString("category"));
                                recipeClass.setDescription(jsonObject.getString("description"));
                                recipeClass.setLabel(jsonObject.getString("label"));
                                recipeClass.setId(jsonObject.getInt("id"));
                                recipeClass.setName(jsonObject.getString("name"));
                                recipeClass.setPrice(jsonObject.getString("price"));
                                recipeClass.setImage(jsonObject.getString("image"));

                                menus.add(recipeClass);
                            }
//                            textView.setText(response.getString(0).ge);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


//                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                        final LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setItemViewCacheSize(5);

                        adapter = new Adapter(MainActivity.this , menus);
                        recyclerView.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("myapp" , "Something went worng");
            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}