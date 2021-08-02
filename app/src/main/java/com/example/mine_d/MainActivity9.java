package com.example.mine_d;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity9 extends AppCompatActivity {
    private TextView textView;
    private TextView textView5;
    private TextView textView4;
    private Button button;
    private Button button2;
    private Button button9;
    private int STORAGE_PERMISSION_CODE =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.textView);
        textView5 = findViewById(R.id.textView5);
        textView4 = findViewById(R.id.textView4);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button9 = findViewById(R.id.button9);
        Intent k = getIntent();
        String p1 = k.getStringExtra("msg");
        String p2 = k.getStringExtra("score");
        textView.setText(p1);
        textView5.setText(p2);
        requestStoragePermission();
    }
    public void Caltech(View v)
    {
        Intent intent = new Intent(getApplicationContext(),MainActivity8.class);
        startActivity(intent);
    }
    public void caltalk(View v)
    {
        finishAffinity();
        System.exit(0);
    }
    public void home(View v)
    {
        Intent intent = new Intent(getApplicationContext(),MainActivity5.class);
        startActivity(intent);
    }
    private void requestStoragePermission()
    {
//        if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_EXTERNAL_STORAGE))
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},STORAGE_PERMISSION_CODE);
    }
}