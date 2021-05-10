package com.ccc.mist.classproject2;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.ccc.mist.classproject2.adapter.StudentAdapter;
import com.ccc.mist.classproject2.model.AllStudentObject;
import com.ccc.mist.classproject2.model.HoldObject;
import com.ccc.mist.classproject2.model.Person;
import com.ccc.mist.classproject2.utils.AppConstant;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private Context context;
    private RecyclerView stdRecycler;
    private StudentAdapter studentAdapter;
    private RecyclerView.LayoutManager layoutManager;
    //private ProgressDialog pd = new ProgressDialog(context);
    private TextView tvLogOutBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        context = this;
        intUi();



    }

    private void intUi() {

        tvLogOutBtn = (TextView) findViewById(R.id.tvLogOutBtn);

        stdRecycler = (RecyclerView) findViewById(R.id.stdRecycler);

        stdRecycler.setHasFixedSize(true);
        stdRecycler.setItemAnimator(new DefaultItemAnimator());
        layoutManager = new LinearLayoutManager(context);
        stdRecycler.setLayoutManager(layoutManager);



        String jsonString = AppConstant.loadJSONFromAsset(context,"student.json");

        Log.e("Json string: ",""+jsonString);



        MyAsyncTask task = new MyAsyncTask();
        task.execute(jsonString);

        tvLogOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences pref = context.getSharedPreferences("MyPref", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();

                editor.putBoolean("isLogin", false).commit();

                Intent intent = new Intent(context,MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }


    private class MyAsyncTask extends AsyncTask<String,String,AllStudentObject>{

        @Override
        protected AllStudentObject doInBackground(String... strings) {
            AllStudentObject allStudentObject = AppConstant.parseGson(strings[0]);

            return allStudentObject;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(AllStudentObject result) {
            //pd.dismiss();
            List<HoldObject> listData = new ArrayList<HoldObject>();
            listData.addAll(result.getStudents());

            Log.e("Arry size",""+listData.size());

             studentAdapter= new StudentAdapter(context,listData);
             stdRecycler.setAdapter(studentAdapter);



        }

        @Override
        protected void onPreExecute() {

            //pd.show();
        }
    }




}
