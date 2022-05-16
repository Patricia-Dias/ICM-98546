package com.example.dialer;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btn_star,btn_hash, btn_call;
    Button[] contactsBtns = new Button[3];
    ImageButton backspace;
    EditText input;

    private int btnLongClicked=-1;
    private Map<Integer, String[]> contacts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactsBtns[0] = findViewById(R.id.contact_0);;
        contactsBtns[1] = findViewById(R.id.contact_1);
        contactsBtns[2] = findViewById(R.id.contact_2);

        contactsBtns[0].setOnLongClickListener(
                new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        btnLongClicked=0;
                        goToSpeedDialer();
                        return true;
                    }
                }
        );

        contactsBtns[1].setOnLongClickListener(
                new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        btnLongClicked=1;
                        goToSpeedDialer();
                        return true;
                    }
                }
        );

        contactsBtns[2].setOnLongClickListener(
                new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        btnLongClicked=2;
                        goToSpeedDialer();
                        return true;
                    }
                }
        );

        input =findViewById(R.id.num);
        backspace = findViewById(R.id.btn_backspace);

        backspace.setOnLongClickListener(
                new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        input.setText("");
                        return true;
                    }
                }
        );


        btn1 =findViewById(R.id.btn_1);
        btn2 =findViewById(R.id.btn_2);
        btn3 =findViewById(R.id.btn_3);
        btn4 =findViewById(R.id.btn_4);
        btn5 =findViewById(R.id.btn_5);
        btn6 =findViewById(R.id.btn_6);
        btn7 =findViewById(R.id.btn_7);
        btn8 =findViewById(R.id.btn_8);
        btn9 =findViewById(R.id.btn_9);
        btn0 =findViewById(R.id.btn_0);
        btn_star =findViewById(R.id.btn_star);
        btn_hash =findViewById(R.id.btn_hash);
        btn_call =findViewById(R.id.btn_call);

        contacts = new HashMap<>();
    }

    public void delete(View v){
        String cache = input.getText().toString();
        if (cache.length()>0)
            input.setText(cache.substring(0,cache.length()-1));
    }

    public void getContactNumber0(View view){
        String[] result = contacts.get(0);
        if (result!=null){
            input.setText(result[1]);
        }
    }
    public void getContactNumber1(View view){
        String[] result = contacts.get(1);
        if (result!=null){
            input.setText(result[1]);
        }
    }
    public void getContactNumber2(View view){
        String[] result = contacts.get(2);
        if (result!=null){
            input.setText(result[1]);
        }
    }

    public void one(View v){
        onButtonClick(btn1, input, "1");
    }

    public void two(View v){
        onButtonClick(btn2, input, "2");
    }
    public void three(View v){
        onButtonClick(btn3, input, "3");
    }
    public void four(View v){
        onButtonClick(btn4, input, "4");
    }
    public void five(View v){
        onButtonClick(btn5, input, "5");
    }
    public void six(View v){
        onButtonClick(btn6, input, "6");
    }
    public void seven(View v){
        onButtonClick(btn7, input, "7");
    }
    public void eight(View v){
        onButtonClick(btn8, input, "8");
    }
    public void nine(View v){
        onButtonClick(btn9, input, "9");
    }
    public void star(View v){
        onButtonClick(btn_star, input, "*");
    }
    public void zero(View v){
        onButtonClick(btn0, input, "0");
    }
    public void hash(View v){
        onButtonClick(btn_hash, input, "#");
    }
    public void call(View v){
        String num = input.getText().toString();
        if (num.length()<=3){
            Toast.makeText(this, "Please Enter a Valid Phone Number", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(Intent.ACTION_DIAL);
            if (num.contains("#")){
                num = num.replace("#", "%23");
            }
            intent.setData(Uri.parse("tel:"+num));
            startActivity(intent);
        }
    }

    public void onButtonClick(Button btn, EditText inp, String number){
        String cache = input.getText().toString();
        input.setText(cache+number);
    }

    private void goToSpeedDialer(){
        Intent switchActivityIntent = new Intent(this, SpeedDialerActivity.class);
        startActivityForResult(switchActivityIntent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK && data!=null) {
            retrieveContact(data);
        }
    }

    private void retrieveContact(Intent data){
        String number = data.getStringExtra("number");
        String name = data.getStringExtra("name");
        String[] contactInfo = new String[2];
        contactInfo[0] = name;
        contactInfo[1] = number;

        if (btnLongClicked>=0 && btnLongClicked<=2) {
            contactsBtns[btnLongClicked].setText(name);
            contacts.put(btnLongClicked, contactInfo);
        }
    }

}