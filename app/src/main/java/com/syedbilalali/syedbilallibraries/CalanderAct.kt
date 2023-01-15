package com.syedbilalali.syedbilallibraries

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.syedbilalali.customcalanderview.CalanderIItemClicked
import com.syedbilalali.customcalanderview.CalendarCustomView
import com.syedbilalali.customcalanderview.EventObjects
import com.syedbilalali.customcalanderview.EventObjectsTime

import java.util.*


class CalanderAct : AppCompatActivity() {
    var allEvents = java.util.ArrayList<EventObjects>()
    var mView: CalendarCustomView? = null
    private val listDaysRate: ArrayList<EventObjectsTime?> = ArrayList<EventObjectsTime?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_calander)
        mView = findViewById(R.id.custom_calendar_view) as CalendarCustomView
        var btn  = findViewById(R.id.btn) as Button
        btn.setOnClickListener {

            //openRangePicker("15/01/2023","23/02/2023")
        }


        mView!!.setGridCellClickEvents(listDaysRate, itemClicked);


        //custom indicator text
//        val percent_indicator: IndicatorSeekBar =
//            findViewById<IndicatorSeekBar>(R.id.percent_indicator)
//        percent_indicator.setIndicatorTextFormat("\${PROGRESS} %",Color.parseColor("#000000"))
//        percent_indicator.setOnSeekChangeListener(object : OnSeekChangeListener {
//            override fun onSeeking(seekParams: SeekParams) {
//
//                percent_indicator.setmIndicatorColor(Color.parseColor("#000000"))
//            }
//
//            override fun onStartTrackingTouch(seekBar: IndicatorSeekBar) {
//
//            }
//
//            override fun onStopTrackingTouch(seekBar: IndicatorSeekBar) {
//
//            }
//        })


    }

    private var itemClicked: CalanderIItemClicked =
        object : CalanderIItemClicked {
            override fun calanderIItemClicked(firstDate: String?, secondDate: String?, b: Boolean) {
                Log.d("TAG", "calanderIItemClicked: "+firstDate +secondDate + b)
                if(b){
                    var dayName = EventObjectsTime()
                    dayName.dayname = "Saturday"
                    dayName.rates = "1452"
                    listDaysRate.add(dayName)

                    var dayName1 = EventObjectsTime()
                    dayName1.dayname = "Wednesday"
                    dayName1.rates = "1466"
                    listDaysRate.add(dayName1)

                    mView!!.setArrayDataValue(listDaysRate,firstDate,secondDate)

                }

            }


        }


}




//    private fun openRangePicker(firstdate: String, seconddate: String) {
//        val dates = getDates(firstdate!!, seconddate!!)
//        if(dates != null){
//            mView?.setallevent(allEvents)
//
//        }
//    }
//
//
//        private fun getDates(dateString1: String, dateString2: String): EventObjects? {
//        val dates = ArrayList<Date>()
//            var jdb: EventObjects? = null
//            val df1: DateFormat = SimpleDateFormat("dd/MM/yyyy")
//        var date1: Date? = null
//        var date2: Date? = null
//        try {
//            date1 = df1.parse(dateString1)
//            date2 = df1.parse(dateString2)
//        } catch (e: ParseException) {
//            e.printStackTrace()
//        }
//        val cal1 = Calendar.getInstance()
//        cal1.time = date1
//        val cal2 = Calendar.getInstance()
//        cal2.time = date2
//        while (!cal1.after(cal2)) {
//            dates.add(cal1.time)
//            cal1.add(Calendar.DATE, 1)
//            val dayOfWeek: Int = cal1.get(Calendar.DAY_OF_WEEK)
//            jdb = EventObjects(dayOfWeek,"test",cal1.time)
//            allEvents.add(jdb!!)
//
//        }
//
//        return jdb
//    }
