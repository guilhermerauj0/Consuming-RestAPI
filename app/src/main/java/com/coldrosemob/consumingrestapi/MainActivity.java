package com.coldrosemob.consumingrestapi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    Button main_btn_getCityId, main_btn_getWeatherByCityId, main_btn_getWeatherByCityName;
    EditText main_editText_cityName;
    ListView main_listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_btn_getCityId = findViewById(R.id.main_btn_getCityId);
        main_btn_getWeatherByCityId = findViewById(R.id.main_btn_getWeatherByCityId);
        main_btn_getWeatherByCityName = findViewById(R.id.main_btn_getWeatherByCityName);

        main_editText_cityName = findViewById(R.id.main_editText_cityName);
        main_listview = findViewById(R.id.main_listview);

        // CLICK LISTENERS
        main_btn_getCityId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // VOLLEY REQUEST
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                String url = "https://www.metaweather.com/api/location/search/?query=london";

                // Request a string response from url
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // display result
                                Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // display result for any error
                        Toast.makeText(MainActivity.this, "Error ocured", Toast.LENGTH_LONG);
                    }
                });

                // Add the request to the RequestQueue
                queue.add(stringRequest);
            }
        });

        main_btn_getWeatherByCityId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        main_btn_getWeatherByCityName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}