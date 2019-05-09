package com.example.scanqr;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;



import static android.content.Intent.ACTION_CALL;
import static android.content.Intent.ACTION_VIEW;


public class MainActivity extends AppCompatActivity {



    private static final int MY_CAMERA_REQUEST_CODE = 1;

    @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.layout);
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.CAMERA}, MY_CAMERA_REQUEST_CODE);

        }

    }

    public void openCamera(View v){

        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        // QR_CODE_MODE: QRCODE , ONE_D_MODE: Codigo de barras
        intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
        startActivityForResult(intent, 0);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == Activity.RESULT_OK) {
                String contents = intent.getStringExtra("SCAN_RESULT");
                Toast.makeText(getApplicationContext(), contents, Toast.LENGTH_LONG).show();
                Log.i("CONTENT SCAN ", contents);
                Uri uri = Uri.parse( contents );
                if(contents.contains( ".com" )){
                Intent it= new Intent( ACTION_VIEW,uri);
                startActivity( it );}
                /*else if (contents.contains( "tell:" )){
                    Intent it= new Intent( ACTION_CALL, uri );
                    startActivity( it );

                }*/

            } else if (resultCode == Activity.RESULT_CANCELED) {
                // Handle cancel
            }
        }
    }
}
