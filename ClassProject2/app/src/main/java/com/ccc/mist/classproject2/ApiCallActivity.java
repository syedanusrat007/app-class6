package com.ccc.mist.classproject2;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ccc.mist.classproject2.adapter.FlowerAdapter;
import com.ccc.mist.classproject2.model.Flower;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiCallActivity extends AppCompatActivity {
    private Context context;
    private RecyclerView reyFlower;
    private RecyclerView.LayoutManager layoutManager;
    private FlowerAdapter fAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_call);
        context = this;
        intUi();
    }

    private void intUi() {

        reyFlower = (RecyclerView) findViewById(R.id.reyFlower);
        reyFlower.setHasFixedSize(true);
        reyFlower.setItemAnimator(new DefaultItemAnimator());
        layoutManager = new LinearLayoutManager(context);
        reyFlower.setLayoutManager(layoutManager);

        loadFlower();


    }

    private void loadFlower() {

        String url = "http://services.hanselandpetal.com/feeds/flowers.json";

       final ProgressDialog pDialog = new ProgressDialog(context);
        pDialog.setMessage("Loading ....");
        pDialog.show();


        StringRequest strRequet = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        pDialog.hide();

                        Type flowerType = new TypeToken<ArrayList<Flower>>() {}.getType();
                        List<Flower> fList = new Gson().fromJson(response, flowerType);

                       // Log.e("Flower list size",""+fList.size());
                        fAdapter = new FlowerAdapter(context,fList);
                        reyFlower.setAdapter(fAdapter);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pDialog.hide();
                        Log.e("Error",""+error.getMessage());





                    }
                })
   /*     {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String, String>();

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return super.getHeaders();
            }
        }*/

                ;

        RequestQueue rQue = Volley.newRequestQueue(context);
        rQue.add(strRequet);


    }
}
