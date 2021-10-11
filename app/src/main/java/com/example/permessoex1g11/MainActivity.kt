package com.example.permessoex1g11

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {
    lateinit var bottone:Button
    val REQUEST_CAMERA_CODE = 4
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bottone = findViewById(R.id.btn_cameragps)
        bottone.setOnClickListener{
            requestCameraPermission()

        }
    }


    private fun requestCameraPermission() {
        var permission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
        if (permission==PackageManager.PERMISSION_GRANTED){
            //startCamera()
            Toast.makeText(this, "Placeholder, ma ci siamo arrivati",Toast.LENGTH_LONG).show()
        }else{
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)){
                showADialog()
            }else{
                requestPermissions(arrayOf(Manifest.permission.CAMERA), REQUEST_CAMERA_CODE)
            }
        }
    }

    private fun showADialog() {
        MaterialAlertDialogBuilder(this)
            .setTitle("E no!")
            .setMessage("Consenti a tutto o ti spezzo le gambe")
            .setPositiveButton("Consenti!", {dialog, which->
                requestCameraPermission()
                dialog.dismiss()})
            .setNegativeButton("No,ti sfido.", {dialog, which -> dialog.dismiss()})
            .show()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            REQUEST_CAMERA_CODE -> {
                if (grantResults.isNotEmpty() && grantResults.first() == PackageManager.PERMISSION_GRANTED){
                    //startCamera()
                }
            }
            else -> {}
        }
    }
}