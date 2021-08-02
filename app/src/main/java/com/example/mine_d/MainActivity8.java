package com.example.mine_d;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.graphics.Color;
import android.os.Bundle;

public class MainActivity8 extends AppCompatActivity {
    Minede minede;
    private int STORAGE_PERMISSION_CODE =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestStoragePermission();


        minede = new Minede(this,getApplicationContext());
        minede.setBackgroundColor(Color.WHITE);
        minede.setNumColumns(8);
        minede.setNumRows(8);
        setContentView(minede);
    }
    private void requestStoragePermission()
    {

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},STORAGE_PERMISSION_CODE);
    }
}