package com.example.conorkiernan.regisys;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static android.R.attr.start;
import static android.os.SystemClock.sleep;

public class Permissions extends AppCompatActivity {

    private LocationManager locationManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        startMainActivity();


    }

    private void startMainActivity()
    {
        Intent intent = new Intent(Permissions.this,MainActivity.class);
        startActivity(intent);
    }


}

