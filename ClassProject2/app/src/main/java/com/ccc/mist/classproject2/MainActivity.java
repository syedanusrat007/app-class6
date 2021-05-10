package com.ccc.mist.classproject2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ccc.mist.classproject2.adapter.CustomSpinnerAdapter;
import com.ccc.mist.classproject2.utils.AppConstant;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private TextView tvRegBtn,tvApiBtn;
    private EditText etName,etEmail,etPassword;
    private RadioGroup grGender;
    private Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        intUi();
    }

    private void intUi() {





        spinner1 =  (Spinner) findViewById(R.id.spinner1);
        ArrayList<String> type = new ArrayList<String>();
        type.add("Choose a Type");
        type.add("Islam");
        type.add("Science");
        type.add("Arts");
        type.add("Social");
        type.add("Filem");
        type.add("Health");
        type.add("Beauty");
        type.add("Islam11");
        type.add("Science11");
        type.add("Arts11");
        type.add("Social11");
        type.add("Filem11");
        type.add("Health11");
        type.add("Beauty11");
        type.add("Islam22");
        type.add("Science22");
        type.add("Arts22");
        type.add("Social22");
        type.add("Filem22");
        type.add("Health22");
        type.add("Beauty22");


        CustomSpinnerAdapter customSpinnerAdapter=new CustomSpinnerAdapter(context,type);
        spinner1.setAdapter(customSpinnerAdapter);

        tvApiBtn = (TextView) findViewById(R.id.tvApiBtn);
        tvRegBtn = (TextView) findViewById(R.id.tvRegBtn);
        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        grGender = (RadioGroup) findViewById(R.id.grGender);



        tvRegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userDtaCheck();
            }
        });

        tvApiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //API call

                Intent intent = new Intent(context,ApiCallActivity.class);
                startActivity(intent);
            }
        });

    }

    protected void  userDtaCheck(){



        String name= etName.getText().toString().trim();
        String email= etEmail.getText().toString().trim();
        String password= etPassword.getText().toString().trim();


        //String valueGender = ((RadioButton)findViewById(grGender.getCheckedRadioButtonId() )).getText().toString().trim();



        if(TextUtils.isEmpty(name)){

            AppConstant.showAlertMessage(context,getString(R.string.alerNam));
            return;

        }else if(!AppConstant.isValidEmail(email)){

          AppConstant.showAlertMessage(context,getString(R.string.alerEmail));
            return;

        }else if(TextUtils.isEmpty(password)){
          AppConstant.showAlertMessage(context,getString(R.string.alerPasword));
            return;

        }else {

           /* Intent intent = new Intent(context,Main2Activity.class);
            Person person= new Person();
            person.setName(name);
            person.setEmail(email);
            person.setPassword(password);
            intent.putExtra("personData",person);
            etName.setText("");
            etEmail.setText("");
            etPassword.setText("");
            startActivity(intent);
            finish();*/

            SharedPreferences pref = context.getSharedPreferences("MyPref", MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();

            editor.putBoolean("isLogin", true).commit();
           // AppConstant.flag = true;
            Intent intent = new Intent(context,Main2Activity.class);
            startActivity(intent);
            finish();

            //Toast.makeText(context,"Gender: "+valueGender,Toast.LENGTH_SHORT).show();

        }

    }
}
