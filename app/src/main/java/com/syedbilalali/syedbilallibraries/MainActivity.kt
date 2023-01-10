package com.syedbilalali.syedbilallibraries

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.syedbilalali.customcalanderview.CalanderIItemClicked

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this@MainActivity, CalanderAct::class.java)
        startActivity(intent)

    }


}