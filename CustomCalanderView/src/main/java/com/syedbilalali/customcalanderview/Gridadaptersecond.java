package com.syedbilalali.customcalanderview;





import static com.syedbilalali.customcalanderview.CalendarCustomView.allEvents;
import static com.syedbilalali.customcalanderview.CalendarCustomView.selectDate;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class Gridadaptersecond extends PagerAdapter {

    private Context mContext;
    private static final String TAG = GridAdapter.class.getSimpleName();
    private LayoutInflater mInflater;
    public static List<Date> monthlyDates;
    private SimpleDateFormat formatter = new SimpleDateFormat("dd", Locale.ENGLISH);
    private Calendar currentDate;
    private  ArrayList<EventObjects> allEventV1 = new ArrayList<>();
    private ArrayList<EventObjects> eventsFirstLast = new ArrayList<EventObjects>();
    public static int df;
    public static int finallist;
    public static boolean nm;
    int das;
    private int previousposition= 0;
    String updatemonth,updateyear,currentda;
    String sDate;
    String checkdate;
    private  boolean countValueStatus = false;

    private String firstRate;
    private String secondRate;
    private Date oneWayTripDate;
    int monthcur = 0;
    private Date firstDateView;
    private Date secondDateView;
    int daa,ye,mnth;
    public Gridadaptersecond(Context context, List<Date> monthlyDates, Calendar currentDate, ArrayList<EventObjects> allEvent) {
        mContext = context;
        this.monthlyDates = monthlyDates;
        this.currentDate = currentDate;
        this.allEventV1 = allEvent;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        Date mDate = monthlyDates.get(position);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.single_cell_layout, collection, false);
        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return monthlyDates.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @SuppressLint("ResourceType")
    @Override
    public CharSequence getPageTitle(int position) {
        Date customPagerEnum = monthlyDates.get(position);
        //val customPagerEnum = feedsModels[position]
        return mContext.getString(1);
    }


    public void update(ArrayList<EventObjects> list, String firstdate, String seconddate, ArrayList arrayList) {
        countValueStatus = false;

        eventsFirstLast = list;
        if(eventsFirstLast.size() > 0){
            this.firstRate =  eventsFirstLast.get(0).getMessage();
            this.secondRate = eventsFirstLast.get(eventsFirstLast.size() - 1).getMessage();
            firstDateView = eventsFirstLast.get(0).getDate();
            secondDateView = eventsFirstLast.get(eventsFirstLast.size() - 1).getDate();}
        if(eventsFirstLast.size() > 2){
            countValueStatus = true;
            eventsFirstLast.remove(0); // removes the first item
            eventsFirstLast.remove(eventsFirstLast.size() - 1);
        }

        notifyDataSetChanged();
    }

}