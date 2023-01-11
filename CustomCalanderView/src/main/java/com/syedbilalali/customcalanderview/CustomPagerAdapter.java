package com.syedbilalali.customcalanderview;

import static com.syedbilalali.customcalanderview.CalendarCustomView.allEvents;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CustomPagerAdapter extends PagerAdapter {
    private GridView calendarGridView;
    private Context mContext;
    private GridAdapter mAdapter;
    private Calendar currentDate;
    int[] myIntArray = new int[5];
    private  ArrayList<EventObjects> allEventV1 = new ArrayList<>();
    private String currentDatev1;
    private int viewPosition;
    private TextView currentDatetxt;
    private View view3;
    private  CalanderIItemClickedV2 itemClicked;
    List<Date> mdayValueInCells = new ArrayList<Date>();
    public CustomPagerAdapter(Context context, List<Date> dayValueInCells, Calendar cal, ArrayList<EventObjects> allEvents, String sDate, CalanderIItemClickedV2 itemClickedV2, View v) {
        mContext = context;
        mdayValueInCells = dayValueInCells;
        allEventV1 = allEvents;
        currentDate = cal;
        currentDatev1 = sDate;
        view3 = v;
        itemClicked = itemClickedV2;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        Date modelObject = mdayValueInCells.get(position);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.cells, collection, false);
        collection.addView(layout);
        viewPosition = position;
        calendarGridView = (GridView) layout.findViewById(R.id.calendar_grid);
        currentDatetxt = (TextView)layout.findViewById(R.id.display_current_date);
        mAdapter = new GridAdapter(mContext, mdayValueInCells, currentDate, allEventV1,itemClicked);
        calendarGridView.setAdapter(mAdapter);
        currentDatetxt.setText(currentDatev1);

        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }



    @Override
    public int getCount() {
        return myIntArray.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @SuppressLint("ResourceType")
    @Override
    public CharSequence getPageTitle(int position) {
       // Date customPagerEnum = mdayValueInCells.get(position);
        return mContext.getString(1);
    }

    public void update(ArrayList<EventObjects> allEvents, String firstDate, String seconDate, ArrayList<EventObjects> list, int viewPosition, GridAdapter mAdapter) {
                 if(mAdapter!= null){
                    // mAdapter = (GridAdapter)calendarGridView.getAdapter();
                     mAdapter.update(allEvents,firstDate,seconDate,list);
                     mAdapter.notifyDataSetChanged();
                }

    }
}