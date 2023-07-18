package com.syedbilalali.syedbilallibraries

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.syedbilalali.customcalanderview.CalanderIItemClicked
import com.syedbilalali.customcalanderview.CalendarCustomView

class MainActivity : AppCompatActivity(){
    var mView: CalendarCustomView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mView = findViewById(R.id.custom_calendar_view) as CalendarCustomView
        CalendarCustomView.langaugeCode = "en"
        mView!!.loadLangauge("en")

        val intent = Intent(this@MainActivity, CalanderAct::class.java)
        startActivity(intent)

    }


}