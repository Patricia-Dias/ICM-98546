package com.example.dialer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SpeedDialerActivity extends AppCompatActivity {
    EditText number, name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speed_dialer_activity);

        number =findViewById(R.id.textPhone);
        name =findViewById(R.id.personName);
    }

    public void addContact(View view){
        String inp_num = number.getText().toString().trim();
        String inp_name = name.getText().toString().trim();
        System.out.println("name and number: "+inp_name+"\t"+inp_num);
        if (inp_name.length()==0 && inp_num.length()<=3){
            Toast.makeText(this, "Please Enter a Valid Name or Phone Number", Toast.LENGTH_SHORT).show();
        }else {
            Intent goToMain = new Intent();
            goToMain.putExtra("number", inp_num);
            goToMain.putExtra("name", inp_name);
            setResult(RESULT_OK, goToMain);
            finish();
        }
    }
}
