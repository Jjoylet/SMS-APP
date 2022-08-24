
package com.joylet.smsapp

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestPermissions()
    }
    private fun requestPermissions(){
        val permission = Manifest.permission.RECEIVE_SMS
        val permissionGranted = ContextCompat.checkSelfPermission(this,permission)
        if (permissionGranted != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, arrayOf(permission),1111)
    }
}