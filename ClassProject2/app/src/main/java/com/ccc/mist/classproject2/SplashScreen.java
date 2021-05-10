package com.ccc.mist.classproject2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ccc.mist.classproject2.utils.AppConstant;

public class SplashScreen extends AppCompatActivity {
    private Context context;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_screen);
        context =this;
        intUi();
    }

    private void intUi() {

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences pref = context.getSharedPreferences("MyPref", MODE_PRIVATE);

                if(pref.getBoolean("isLogin", false)){
                    Intent intent = new Intent(context,Main2Activity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Intent intent = new Intent(context,MainActivity.class);
                    startActivity(intent);
                    finish();
                }


            }
        },3000);
    }
}
