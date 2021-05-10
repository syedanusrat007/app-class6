package com.ccc.mist.classproject2.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.ccc.mist.classproject2.model.AllStudentObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Salahuddin on 1/23/2017.
 */

public class AppConstant {

    public static void showAlertMessage(Context context,String message){


        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

        alertDialog.setMessage(message);
        alertDialog.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        alertDialog.show();


    }


     public static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }


    public static String loadJSONFromAsset(Context context,String fileName) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }


    public static AllStudentObject parseGson(String content){

        GsonBuilder builder = new GsonBuilder();
        Gson g = builder.setPrettyPrinting().create();
        //Type listType = new TypeToken<List<Flower>>() {}.getType();
        //flowerList = g.fromJson(content, listType);
        AllStudentObject allStudent = g.fromJson(new String(content),
                AllStudentObject.class);

        return allStudent;

    }


    public static boolean flag = false;


    public static String BASE_URL = "http://services.hanselandpetal.com/photos/";




}
