package com.syedbilalali.customcalanderview;



import static com.syedbilalali.customcalanderview.CalendarCustomView.allEvents;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class GridAdapter extends ArrayAdapter {
    private static final String TAG = GridAdapter.class.getSimpleName();
    private LayoutInflater mInflater;
    public static List<Date> monthlyDates;
    private SimpleDateFormat formatter = new SimpleDateFormat("dd", Locale.ENGLISH);
    private Calendar currentDate;
    public static  ArrayList<EventObjects> allEventV1;

    public  static int df;
    public static int finallist;
    public static boolean nm;
    int das;
    private int previousposition= 0;
    String updatemonth,updateyear,currentda;
    String sDate;
    String checkdate;
    private Date oneWayTripDate;


    int monthcur = 0;
    int daa,ye,mnth;
    public GridAdapter(Context context, List<Date> monthlyDates, Calendar currentDate, ArrayList<EventObjects> allEvent) {
        super(context, R.layout.single_cell_layout);
        this.monthlyDates = monthlyDates;
        this.currentDate = currentDate;
        this.allEventV1 = allEvent;
         mInflater = LayoutInflater.from(context);

        ///

      /*  Calendar calNow = Calendar.getInstance();
        Calendar calSet = (Calendar) calNow.clone();
           calSet.get(Calendar.HOUR_OF_DAY);
        calSet.get(Calendar.MINUTE);
        calSet.get(Calendar.SECOND);
        calSet.get(Calendar.MILLISECOND);
        das  = calSet.get(Calendar.DAY_OF_MONTH);
        calSet.get(Calendar.DAY_OF_WEEK);*/
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Date mDate = monthlyDates.get(position);
        final TextView cellNumber;
        final LinearLayout lv;
        final View eventIndicator,eventIndicatorday;
        Calendar dateCal = Calendar.getInstance();
        dateCal.setTime(mDate);
        sDate = formatter.format(mDate.getTime());
        ///String mnth = formatter.format(mDate.getTime().g);
        Log.d(TAG, "Number of date " + sDate);


        // int dayss = sDate.get(Calendar.DAY_OF_MONTH);


        final int dayValue = dateCal.get(Calendar.DAY_OF_MONTH);
        final int displayMonth = dateCal.get(Calendar.MONTH) + 1;
        final int displayYear = dateCal.get(Calendar.YEAR);
        final int currentMonth = currentDate.get(Calendar.MONTH) + 1;
        final int currentdas = currentDate.get(Calendar.DAY_OF_MONTH);
        final  int yea = currentDate.get(Calendar.YEAR);


//        if(!CalanderFragment.setmonth){
//            CalanderFragment.setmonth = true;
//            monthcur = currentMonth;
//        }


        int currentYear = currentDate.get(Calendar.YEAR);
        final double hour = dateCal.HOUR;
        final double mint = dateCal.MINUTE;

        if(currentMonth < 9){
            updatemonth = "0"+String.valueOf(currentMonth);
        }else {
            updatemonth = String.valueOf(currentMonth);
        }

        if(currentMonth < 9){
            currentda = "0"+String.valueOf(currentdas);
        }else {
            currentda = String.valueOf(currentdas);
        }

        updateyear =  String.valueOf(yea);
        View view = convertView;
        try {
            if (view == null) {
                view = mInflater.inflate(R.layout.single_cell_layout, parent, false);
            }
            eventIndicator = (View) view.findViewById(R.id.cscs);
            eventIndicatorday = (View) view.findViewById(R.id.csday);

            cellNumber = (TextView) view.findViewById(R.id.calendar_date_id);
            cellNumber.setText(String.valueOf(dayValue));

             lv = (LinearLayout)view.findViewById(R.id.event_wrapper);
            lv.setBackgroundResource(0);
            if (displayMonth == currentMonth && displayYear == currentYear) {
                cellNumber.setTextColor(Color.BLACK);

                callrecycler(lv,dayValue,eventIndicator,sDate,displayMonth);
            } else {
                cellNumber.setTextColor(ContextCompat.getColor(getContext(), R.color.lightgrey));

            }











//            cellNumber.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                        previousposition = position;
//                        notifyDataSetChanged();
//                        eventIndicatorday.setVisibility(View.VISIBLE);
//                        eventIndicatorday.setBackgroundColor(getContext().getResources().getColor(R.color.green_color));
//                       // cellNumber.setBackgroundResource(R.drawable.greencircle);
//
//                        Date mDate = monthlyDates.get(position);
//                        Log.i(TAG, "onItemClick: "+mDate.getTime());
//                        String d = String.valueOf(mDate.getTime());
//                        String dates = getDate(d);
//                        Toast.makeText(getContext(), "Clicked " + dates, Toast.LENGTH_LONG).show();
//
//                        allEvents.clear();
////                        if(CalanderFragment.not_detail != null){
////                            CalanderFragment.not_detail.calldata(dates);
////                        }
//                    //mAdapter.setview(position);
//
//                }
//            });

            if(previousposition != 0)
            if(previousposition == position){
                eventIndicatorday.setBackgroundColor(getContext().getResources().getColor(R.color.green_color));
               // cellNumber.setBackgroundResource(Color.parseColor("#567845"));
               // holder.tv1.setTextColor(Color.parseColor("#ffffff"));
            }
            else
            {
                eventIndicatorday.setVisibility(View.GONE);
                cellNumber.setBackgroundResource(R.drawable.blankcircel);
            }



            if(displayMonth == monthcur) {
                if (dayValue == currentdas) {
                    cellNumber.setBackgroundResource(R.drawable.greencircle);
                     cellNumber.setTextColor(Color.GREEN);

                    // cellNumber.setTextColor(Color.parseColor("#000"));
                    // cellNumber.setBackgroundColor(R.color.black);
                    //cellNumber.setBackgroundColor(Color.parseColor("#000"));
                }
            }


        }catch(NullPointerException e){
            System.out.println("In catch");
        }
        return view;
    }
    public void update(ArrayList<EventObjects> list) {
        allEvents.addAll(list);
        notifyDataSetChanged();
    }
    private void callrecycler(LinearLayout lv, int dayValue, View eventIndicator, String date, int displayMonth) {
        for (int k =0 ; k < allEvents.size(); k++){
          String  day = formatter.format(allEvents.get(k).getDate().getTime());

            Calendar dateCalv1 = Calendar.getInstance();
            dateCalv1.setTime(allEvents.get(k).getDate());
            final int displayMonthv1 = dateCalv1.get(Calendar.MONTH) + 1;
            //   if(day.equals(date)){
                if (day.equals(date) && displayMonthv1 == displayMonth) {
                   // eventIndicator.setVisibility(View.VISIBLE);
                    lv.setBackgroundResource(R.drawable.greencircle);

                    break;
            }

        }

    }

    private String getDate2(String d) {
        try {
            //.DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
            // displayYear+"-"+"0"+currentMonth+"-"+dateno;
            // DateFormat sdf = new SimpleDateFormat("EEE.dd-MMM-yyyy");
            DateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
            Date netDate = (new Date(Long.parseLong(d)));
            return sdf.format(netDate);
        } catch (Exception ignored) {
            return "xx";
        }
    }

    private String gettimesec(String jobtime) {
        try {
            // DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date netDate = sdf.parse(jobtime);

            daa = netDate.getDay();
            mnth = netDate.getMonth();
            ye = netDate.getYear();

            return netDate.getDay() + " hours " + netDate.getMonth() + " minutes " + netDate.getYear() + " seconds";

            //return sdf.format(netDate);

        } catch (Exception ignored) {
            return "xx";
        }

    }

    @Override
    public int getCount() {
        return monthlyDates.size();
    }
    @Nullable
    @Override
    public Object getItem(int position) {
        return monthlyDates.get(position);
    }
    @Override
    public int getPosition(Object item) {
        return monthlyDates.indexOf(item);
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


    public void setview(int position) {
        previousposition = position;
        notifyDataSetChanged();
      //  cellNumber.setBackgroundResource(R.drawable.greencircle);

    }
}
