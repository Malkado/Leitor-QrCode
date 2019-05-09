/*package com.example.scanqr;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class scanqr extends MainActivity implements ZXingScannerView.ResultHandler{

    private static final int CODE_PERMISSION_CAMERA = 1;
    private ZXingScannerView mScannerView;
    String resultado;
    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView= new ZXingScannerView(this);
        setContentView(mScannerView);
    }
    private void checkPermission() {
        // Verifica necessidade de verificacao de permissao
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                Toast.makeText(this, "Não há permissão para utilizar a camera!", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA},
                        CODE_PERMISSION_CAMERA);
            } else {
                // Solicita permissao
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA},
                        CODE_PERMISSION_CAMERA);
            }
        }
    }
    @Override
    public void onStart() {
        super.onStart();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }
    @Override
    public void onResume(){
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }
    @Override
    public void onPause(){
        super.onPause();
        mScannerView.stopCamera();
    }
    @Override
    public void handleResult(Result result) {
        resultado= String.valueOf(result.getText());
        Toast.makeText(this,resultado,Toast.LENGTH_LONG).show();


    }
}*/
