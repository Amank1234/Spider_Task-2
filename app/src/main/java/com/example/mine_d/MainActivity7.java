package com.example.mine_d;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity7 extends AppCompatActivity {
    private TextView textView6;
    private TextView textView2;
    private TextView textView3;
    private Button button3;
    private Button button4;
    private Button button9;
    private int STORAGE_PERMISSION_CODE =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        textView6 = findViewById(R.id.textView6);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button9 = findViewById(R.id.button9);
        Intent k = getIntent();
        String p1 = k.getStringExtra("msg");
        String p2 = k.getStringExtra("tame");
        textView2.setText(p1);
        textView6.setText(p2);
        requestStoragePermission();
    }
    public void Caltech(View v)
    {
        Intent intent = new Intent(getApplicationContext(),MainActivity4.class);
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
