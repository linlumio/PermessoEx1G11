package com.example.permessoex1g11

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    lateinit var bottone:Button
    var REQUEST_CAMERA_CODE = 4
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bottone = findViewById(R.id.btn_cameragps)
        bottone.setOnClickListener{
            requestCameraPermission()
            requestPositionPermission()
        }
    }

    private fun requestPositionPermission() {
        TODO("Not yet implemented")
    }

    private fun requestCameraPermission() {
        var permission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
        if (permission==PackageManager.PERMISSION_GRANTED){
            startCamera()
        }else{
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)){
                showADialog()
            }else{
                requestPermissions(arrayOf(Manifest.permission.CAMERA), REQUEST_CAMERA_CODE)
            }
        }
    }
}