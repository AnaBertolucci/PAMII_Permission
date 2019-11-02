package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class MainActivity extends AppCompatActivity {


    private final int ALL_PERMISSIONS_RESULT = 101;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean ANTES_PermACCESS_COARSE_LOCATION = this.checkPermissionIsGranted(this, ACCESS_COARSE_LOCATION);
        Toast.makeText(this,"ANTES_PermACCESS_COARSE_LOCATION : "+ANTES_PermACCESS_COARSE_LOCATION,Toast.LENGTH_SHORT).show();

        boolean ANTES_PermACCESS_FINE_LOCATION = this.checkPermissionIsGranted(this, ACCESS_FINE_LOCATION);
        Toast.makeText(this,"ANTES_PermACCESS_FINE_LOCATION : "+ANTES_PermACCESS_FINE_LOCATION,Toast.LENGTH_SHORT).show();


        askUserForPermission(ACCESS_COARSE_LOCATION);
        askUserForPermission(ACCESS_FINE_LOCATION);

        boolean Depois_ANTES_PermACCESS_COARSE_LOCATION = this.checkPermissionIsGranted(this, ACCESS_COARSE_LOCATION);
        Toast.makeText(this,"Depois_ANTES_PermACCESS_COARSE_LOCATION : "+Depois_ANTES_PermACCESS_COARSE_LOCATION,Toast.LENGTH_SHORT).show();

        boolean Depois_ANTES_PermACCESS_FINE_LOCATION = this.checkPermissionIsGranted(this, ACCESS_FINE_LOCATION);
        Toast.makeText(this,"Depois_ANTES_PermACCESS_FINE_LOCATION : "+Depois_ANTES_PermACCESS_FINE_LOCATION,Toast.LENGTH_SHORT).show();

    }
    private static boolean platformIsAboveLollipop() {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }



    public boolean checkPermissionIsGranted(MainActivity mainActivity, String perm) {

        if (platformIsAboveLollipop()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                return (
                        ContextCompat.checkSelfPermission(this,
                                perm) == PackageManager.PERMISSION_GRANTED);
            }
        }
        return true;
    }private void askUserForPermission(String perm){

        if (!this.checkPermissionIsGranted(this, perm)) {


            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    perm)) {

            } else {

                ActivityCompat.requestPermissions(this,
                        new String[]{
                                perm},
                        ALL_PERMISSIONS_RESULT);
            }

        } else {

            Toast.makeText(this, "Permission ACCESS_COARSE_LOCATION has already been granted" , Toast.LENGTH_LONG).show();
        }
    }
}

