package com.example.mine_d;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity5 extends AppCompatActivity {
private RadioButton radioButton4;
    private RadioButton radioButton5;
    private RadioButton radioButton6;
    private RadioGroup radioGroup2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        radioGroup2 = findViewById(R.id.radioGroup2);
        radioButton4 = findViewById(R.id.radioButton4);
        radioButton5 = findViewById(R.id.radioButton5);
        radioButton6 = findViewById(R.id.radioButton6);
    }
    public void next(View v)
    {
        int selectid = radioGroup2.getCheckedRadioButtonId();
        radioButton4 = (RadioButton) findViewById(selectid);
        String temp = radioButton4.getText().toString();
        if(temp.equalsIgnoreCase("EASY"))
        {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        else if(temp.equalsIgnoreCase("MEDIUM"))
        {
            Intent intent = new Intent(this,MainActivity4.class);
            startActivity(intent);
        }
        else if(temp.equalsIgnoreCase("HARD"))
        {
            Intent intent = new Intent(this,MainActivity8.class);
            startActivity(intent);
        }
    }
    public void end(View v)
    {
        finishAffinity();
        System.exit(0);
    }
}