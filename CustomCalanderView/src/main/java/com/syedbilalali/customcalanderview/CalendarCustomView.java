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

import androidx.viewpager.widget.ViewPager;

import java.text.DateFormat;
import java.text.ParseException;
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
    private ViewPager viewPager;
    private GridView calendarGridView;
    public static String dateset;
    private Button addEventButton;
    public static boolean selectDate = false;
    public static ArrayList<EventObjects> allEvents=new ArrayList<>();
    //testcommit
    //  var allEvents = java.util.ArrayList<EventObjects>()
    List<Date> dayValueInCells = new ArrayList<Date>();
    // ArrayList<jobdatasave> sy = new ArrayList<jobdatasave>();
    // private List<jobdatasave> jobarr;
    private static final int MAX_CALENDAR_COLUMN = 42;
    private int viewPosition= 0;
    private int viewPagerCount = 0;
    private int month, year;
    private SimpleDateFormat formatter = new SimpleDateFormat("MMMM yyyy", Locale.ENGLISH);
    private Calendar cal = Calendar.getInstance(Locale.ENGLISH);
    private Context context;
    private  CalanderIItemClicked itemClicked;

    private ArrayList<String> listDaysRate = new ArrayList();

    private GridAdapter mAdapter;
    private boolean dateType = false;
    private String firstDate,seconDate;

    private CustomPagerAdapter customPagerAdapter;
    private View view2;
    public CalendarCustomView(Context context) {
        super(context);
    }

    public CalendarCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initializeUILayout();
        setUpCalendarAdapter(0);
        setPreviousButtonClickEvent();
       // setNextButtonClickEvent();
        setGridCellClickEvents(listDaysRate,itemClicked);
        setallevent(allEvents);
        openRangePicker("","", false);

        Log.d(TAG, "I need to call this method");
    }

    public void setallevent(ArrayList<EventObjects> list) {

        this.allEvents = list;
//        if(mAdapter != null){
//            mAdapter.update(allEvents,firstDate,seconDate,list);
//           mAdapter.notifyDataSetChanged();}


        if(customPagerAdapter != null){
            customPagerAdapter.update(allEvents,firstDate,seconDate,list,viewPosition,mAdapter);
            customPagerAdapter.notifyDataSetChanged();}


    }

    public CalendarCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private CalanderIItemClickedV2 itemClickedV2 = new CalanderIItemClickedV2 () {
        @Override
        public void calanderIItemClicked(String firstDate, String secondDate, boolean b) {
            Log.d(TAG, "calanderIItemClicked: ");
            view2 = viewPager.getChildAt(viewPager.getCurrentItem()).getRootView();
            viewPagerCount = viewPager.getCurrentItem();
            GridView gridview = (GridView) view2.findViewById(R.id.calendar_grid);
            mAdapter = (GridAdapter) gridview.getAdapter();



            if(b) {
                dateType =false;
                seconDate = secondDate;
                selectDate = true;
                openRangePicker(firstDate,seconDate,true);
               // itemClicked.calanderIItemClicked(firstDate,seconDate,true);
            } else {
                allEvents.clear();
                dateType = true;
                firstDate = firstDate;
                setallevent(allEvents);
                selectDate =false;
                openRangePicker(firstDate,firstDate,false);
             //   itemClicked.calanderIItemClicked(firstDate,firstDate,false);

            }
        }
    };
    private void initializeUILayout(){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.calendar_layout, this);
        previousButton = (ImageView)view.findViewById(R.id.previous_month);
        nextButton = (ImageView)view.findViewById(R.id.next_month);
        currentDate = (TextView)view.findViewById(R.id.display_current_date);
        addEventButton = (Button)view.findViewById(R.id.add_calendar_event);
        calendarGridView = (GridView)view.findViewById(R.id.calendar_grid);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
       // viewPager.setPageTransformer(false, new CarouselMembership(context));
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                if(position==0) {
                    Log.d(TAG, "onPageSelected: "+position);
                }else  {
                    Log.d(TAG, "onPageSelected: "+position);
                }
                if(position < viewPager.getAdapter().getCount()-1 ) {
                    Log.d(TAG, "onPageSelected: "+position);
                }else  {
                    Log.d(TAG, "onPageSelected: "+position);
                }

                viewPosition = position;
                viewPagerCount = viewPager.getCurrentItem();
                cal.add(Calendar.MONTH, 1);
                setUpCalendarAdapter(position);
                Log.d(TAG, "onPageSelected: "+position);
                //setNextButtonClickEvent();
                // Page changed
            }
        });





//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//
//
//                viewPosition = position;
//                viewPagerCount = viewPager.getCurrentItem();
//                cal.add(Calendar.MONTH, 1);
//                setUpCalendarAdapter(position);
//                Log.d(TAG, "onPageSelected: "+position);
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//
//            }
//        });

     //   viewPager.setClipChildren(false);
     //   viewPager.setOffscreenPageLimit(12);
     //   viewPager.setPageTransformer(false, new CarouselMembership(context));
    }

    private void setPreviousButtonClickEvent(){
        previousButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPagerCount = viewPager.getCurrentItem();
                cal.add(Calendar.MONTH, -1);
                setUpCalendarAdapter(viewPosition);

            }
        });
    }

    public void setNextButtonClickEvent(){
        nextButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                cal.add(Calendar.MONTH, 1);
              //  setUpCalendarAdapter(position);
            }
        });
    }

    public void setGridCellClickEvents(ArrayList<String> listDaysRateV1, CalanderIItemClicked itemClicked){
        calendarGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listDaysRate = listDaysRateV1;

                // String current = displayYear+"-"+"0"+currentMonth+"-"+dateno;
//                Date mDate = monthlyDates.get(position);
//                Log.i(TAG, "onItemClick: "+mDate.getTime());
//                String d = String.valueOf(mDate.getTime());
//                String dates = getDate(d);
                SimpleDateFormat formatterdate = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Calendar cal1 = Calendar.getInstance();
                cal1.setTime(dayValueInCells.get(position));
                String dates = formatterdate.format(cal1.getTime());
                if(dateType) {
                    dateType =false;
                    seconDate = dates;
                    selectDate = true;
                    openRangePicker(firstDate,seconDate,true);
                    itemClicked.calanderIItemClicked(firstDate,seconDate,true);
                } else {
                    allEvents.clear();
                    dateType = true;
                    firstDate = dates;
                    setallevent(allEvents);
                    selectDate =false;
                    openRangePicker(firstDate,firstDate,false);
                    itemClicked.calanderIItemClicked(firstDate,firstDate,false);

                }


                // openRangePicker("","");

                //mAdapter.setview(position);
            }
        });
    }

    public void setUpCalendarAdapter(int position){
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



        dateset = String.valueOf(sDate);
        customPagerAdapter = new CustomPagerAdapter(context, dayValueInCells, cal, allEvents,sDate,itemClickedV2,view2);
        //  calendarGridView.setAdapter(mAdapter);
        viewPager.setAdapter(customPagerAdapter);


        if(allEvents.size() > 2){
            if(customPagerAdapter != null){
                view2 = viewPager.getChildAt(viewPager.getCurrentItem()).getRootView();
                viewPagerCount = viewPager.getCurrentItem();
                GridView gridview = (GridView) view2.findViewById(R.id.calendar_grid);
                mAdapter = (GridAdapter) gridview.getAdapter();
                customPagerAdapter.update(allEvents,firstDate,seconDate,null,viewPosition,mAdapter);
                customPagerAdapter.notifyDataSetChanged();}
           // mAdapter.update(allEvents,firstDate,seconDate,allEvents);
        }
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


    private void openRangePicker(String firstdate, String seconddate, boolean b) {
        if(firstdate != "" && seconddate != "") {
            allEvents.clear();
            ArrayList dates = getDatediff(firstdate, seconddate);
            if (dates != null) {
                setallevent(allEvents);
            }
        }
    }


    private ArrayList getDatediff (String dateString1, String dateString2){

        try {
            allEvents.clear();
            ArrayList<Date> dates = new ArrayList<Date>();
            EventObjects jdb = null;
            Date date1 = null;
            Date date2 = null;

            try {
                DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
                date1 = df1.parse(dateString1);
                date2 = df1.parse(dateString2);

            } catch (ParseException e) {
                e.printStackTrace();
            }

            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date1);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(date2);

            while (!cal1.after(cal2)) {
                dates.add(cal1.getTime());
                int dayOfWeek = cal1.get(Calendar.DAY_OF_WEEK);
                jdb = new EventObjects(dayOfWeek, "", cal1.getTime());
                cal1.add(Calendar.DATE, 1);
                // cal1.setTime(dates);
                allEvents.add(jdb);

            }

             if(allEvents.size() > 6)
             for (int k = 0; k < listDaysRate.size(); k++) {
                 jdb = new EventObjects(allEvents.get(k).id, listDaysRate.get(k), allEvents.get(k).getDate());
                 allEvents.set(k,jdb);
              }

                return allEvents;
        } catch (Exception ignored) {
            return null;
        }

    }

}