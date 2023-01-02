package com.syedbilalali.customcalanderview;


import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;


/**
 * Created by ATDA on 3/13/2018.
 */

public class CalendarCustomView extends LinearLayout {
    private static final String TAG = CalendarCustomView.class.getSimpleName();
    private ImageView previousButton, nextButton;
    private TextView currentDate;
    private GridView calendarGridView;
    public static String dateset;
    private Button addEventButton;
    private boolean callservices = false;
    public static ArrayList<EventObjects> allEvents=new ArrayList<>();
  //  var allEvents = java.util.ArrayList<EventObjects>()
    List<Date> dayValueInCells = new ArrayList<Date>();
    // ArrayList<jobdatasave> sy = new ArrayList<jobdatasave>();
   // private List<jobdatasave> jobarr;
    private static final int MAX_CALENDAR_COLUMN = 42;
    private int month, year;
    private SimpleDateFormat formatter = new SimpleDateFormat("MMMM yyyy", Locale.ENGLISH);
    private Calendar cal = Calendar.getInstance(Locale.ENGLISH);
    private Context context;
    private GridAdapter mAdapter;

    public CalendarCustomView(Context context) {
        super(context);
    }

    public CalendarCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initializeUILayout();
        setUpCalendarAdapter();
        setPreviousButtonClickEvent();
        setNextButtonClickEvent();
        //setGridCellClickEvents();
        setallevent(allEvents);
        
        Log.d(TAG, "I need to call this method");
    }

    public void setallevent(ArrayList<EventObjects> list) {

          this.allEvents = list;
        if(mAdapter != null)
            mAdapter.update(allEvents);
          mAdapter.notifyDataSetChanged();
    }

    public CalendarCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initializeUILayout(){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.calendar_layout, this);
        previousButton = (ImageView)view.findViewById(R.id.previous_month);
        nextButton = (ImageView)view.findViewById(R.id.next_month);
        currentDate = (TextView)view.findViewById(R.id.display_current_date);
        addEventButton = (Button)view.findViewById(R.id.add_calendar_event);
        calendarGridView = (GridView)view.findViewById(R.id.calendar_grid);
    }

    private void setPreviousButtonClickEvent(){
        previousButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                 callservices = true;
                 cal.add(Calendar.MONTH, -1);
                 setUpCalendarAdapter();

            }
        });
    }

    public void setNextButtonClickEvent(){
        nextButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                callservices = true;
                cal.add(Calendar.MONTH, 1);
                setUpCalendarAdapter();
            }
        });
    }

    public void setGridCellClickEvents(){
        calendarGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               //String current = displayYear+"-"+"0"+currentMonth+"-"+dateno;
//                Date mDate = monthlyDates.get(position);
//                Log.i(TAG, "onItemClick: "+mDate.getTime());
//                String d = String.valueOf(mDate.getTime());
//                String dates = getDate(d);
//                Toast.makeText(context, "Clicked " + dates, Toast.LENGTH_LONG).show();
//                //mAdapter.setview(position);
            }
        });
    }

    public void setUpCalendarAdapter(){
        dayValueInCells = new ArrayList<Date>();
        Calendar mCal = (Calendar)cal.clone();
        mCal.set(Calendar.DAY_OF_MONTH, 1);
        int firstDayOfTheMonth = mCal.get(Calendar.DAY_OF_WEEK) - 1;
        mCal.add(Calendar.DAY_OF_MONTH, -firstDayOfTheMonth);
       // while(dayValueInCells.size() < MAX_CALENDAR_COLUMN){
        dayValueInCells.clear();
        for (int k =0 ; k < MAX_CALENDAR_COLUMN; k++){
            dayValueInCells.add(mCal.getTime());
            mCal.add(Calendar.DAY_OF_MONTH, 1);
            int u = mCal.getTime().getDay();

        }
        Log.d(TAG, "Number of date " + dayValueInCells.size());
        String sDate = formatter.format(cal.getTime());
        currentDate.setText(sDate);


//        if(callservices){
//             SimpleDateFormat formatterdate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
//             String dates = formatterdate.format(cal.getTime());
//             callservices = false;
//             allEvents.clear();
////              if(CalanderFragment.not_detail != null){
////                CalanderFragment.not_detail.callservices(dates);
////            }
//        }
        callservices = false;
        dateset = String.valueOf(sDate);
        mAdapter = new GridAdapter(context, dayValueInCells, cal, allEvents);
        calendarGridView.setAdapter(mAdapter);
    }

    private String getDate(String date) {
        try {
            //.DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
           // displayYear+"-"+"0"+currentMonth+"-"+dateno;
           // DateFormat sdf = new SimpleDateFormat("EEE.dd-MMM-yyyy");
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date netDate = (new Date(Long.parseLong(date)));
            return sdf.format(netDate);
        } catch (Exception ignored) {
            return "xx";
        }
    }

}