package com.syedbilalali.syedbilallibraries

import android.net.ParseException
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.syedbilalali.customcalanderview.CalendarCustomView
import com.syedbilalali.customcalanderview.EventObjects
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


class CalanderAct : AppCompatActivity() {
    var allEvents = java.util.ArrayList<EventObjects>()
    var mView : CalendarCustomView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_calander)
        mView  = findViewById(R.id.custom_calendar_view) as CalendarCustomView
        var btn  = findViewById(R.id.btnview) as Button
        btn.setOnClickListener {
            openRangePicker("15/01/2023","23/02/2023")

        }



    }


    private fun openRangePicker(firstdate: String, seconddate: String) {
        val dates = getDates(firstdate!!, seconddate!!)
        if(dates != null){
            mView?.setallevent(allEvents)

        }
    }


        private fun getDates(dateString1: String, dateString2: String): EventObjects? {
        val dates = ArrayList<Date>()
            var jdb: EventObjects? = null
            val df1: DateFormat = SimpleDateFormat("dd/MM/yyyy")
        var date1: Date? = null
        var date2: Date? = null
        try {
            date1 = df1.parse(dateString1)
            date2 = df1.parse(dateString2)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        val cal1 = Calendar.getInstance()
        cal1.time = date1
        val cal2 = Calendar.getInstance()
        cal2.time = date2
        while (!cal1.after(cal2)) {
            dates.add(cal1.time)
            cal1.add(Calendar.DATE, 1)
            val dayOfWeek: Int = cal1.get(Calendar.DAY_OF_WEEK)
            jdb = EventObjects(dayOfWeek,"test",cal1.time)
            allEvents.add(jdb!!)

        }

        return jdb
    }
}