package com.example.mine_d;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.security.Permission;

import static android.content.pm.PackageManager.*;

public class MainActivity extends AppCompatActivity {
  Mine mine;
  private int STORAGE_PERMISSION_CODE =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


requestStoragePermission();


        mine = new Mine(this,getApplicationContext());
mine.setBackgroundColor(Color.WHITE);
        mine.setNumColumns(8);
        mine.setNumRows(8);
setContentView(mine);

    }

    private void requestStoragePermission()
    {

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},STORAGE_PERMISSION_CODE);
    }


}