//package com.syedbilalali.customcalanderview;
//
//
//
//import static com.syedbilalali.customcalanderview.CalendarCustomView.selectDate;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.graphics.Color;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.LinearLayout;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.core.content.ContextCompat;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.Locale;
//
//
//public class GridAdapter extends ArrayAdapter  {
//    private static final String TAG = GridAdapter.class.getSimpleName();
//    private LayoutInflater mInflater;
//    public static ArrayList<EventObjectsSecond> monthlyDates;
//    private SimpleDateFormat formatter = new SimpleDateFormat("dd", Locale.ENGLISH);
//    private Calendar currentDate;
//    private  ArrayList<EventObjects> allEventV1 = new ArrayList<>();
//    private ArrayList<EventObjects> eventsFirstLast = new ArrayList<EventObjects>();
//    public static int df;
//    public static int finallist;
//    public static boolean nm;
//    int das;
//    public static boolean dateTypev = false;
//    private int previousposition= 0;
//    public static String firstDate,seconDate;
//    private ArrayList<EventObjectsTime> listDaysRate = new ArrayList();
//    String updatemonth,updateyear,currentda;
//    String sDate;
//    String checkdate;
//    private  boolean countValueStatus = false;
//    private String firstRate = "";
//    private String secondRate = "";
//    private Date oneWayTripDate;
//    int monthcur = 0;
//    private Date firstDateView;
//    private Date secondDateView;
//    int daa,ye,mnth;
//
//
//    public GridAdapter(Context context, ArrayList<EventObjectsSecond> monthlyDates, Calendar currentDate, ArrayList<EventObjects> allEvent) {
//        super(context, R.layout.single_cell_layout);
//        this.monthlyDates = monthlyDates;
//        this.currentDate = currentDate;
//        this.allEventV1 = allEvent;
//
//        mInflater = LayoutInflater.from(context);
//        ///
//
//      /*  Calendar calNow = Calendar.getInstance();
//        Calendar calSet = (Calendar) calNow.clone();
//           calSet.get(Calendar.HOUR_OF_DAY);
//        calSet.get(Calendar.MINUTE);
//        calSet.get(Calendar.SECOND);
//        calSet.get(Calendar.MILLISECOND);
//        das  = calSet.get(Calendar.DAY_OF_MONTH);
//        calSet.get(Calendar.DAY_OF_WEEK);*/
//    }
//
//    @NonNull
//    @Override
//    public View getView(final int position, View convertView, ViewGroup parent) {
//        EventObjectsSecond mDate = monthlyDates.get(position);
//        final TextView cellNumber,calanderrate;
//        // final LinearLayout lv1,lv2;
//        final RelativeLayout lv;
//        final LinearLayout maincell;
//        final View eventIndicator,eventIndicatorday;
//        Calendar dateCal = Calendar.getInstance();
//        dateCal.setTime(mDate.getDate());
//        sDate = formatter.format(mDate.getDate().getTime());
//        ///String mnth = formatter.format(mDate.getTime().g);
//        Log.d(TAG, "Number of date " + sDate);
//
//
//
//        // int dayss = sDate.get(Calendar.DAY_OF_MONTH);
//
//
//        final int dayValue = dateCal.get(Calendar.DAY_OF_MONTH);
//        final int displayMonth = dateCal.get(Calendar.MONTH) + 1;
//        final int displayYear = dateCal.get(Calendar.YEAR);
//        final int currentMonth = currentDate.get(Calendar.MONTH) + 1;
//        final int currentdas = currentDate.get(Calendar.DAY_OF_MONTH);
//        final  int yea = currentDate.get(Calendar.YEAR);
//
//
////        if(!CalanderFragment.setmonth){
////            CalanderFragment.setmonth = true;
////            monthcur = currentMonth;
////        }
//
//
//        int currentYear = currentDate.get(Calendar.YEAR);
//        final double hour = dateCal.HOUR;
//        final double mint = dateCal.MINUTE;
//
//        if(currentMonth < 9){
//            updatemonth = "0"+String.valueOf(currentMonth);
//        }else {
//            updatemonth = String.valueOf(currentMonth);
//        }
//
//        if(currentMonth < 9){
//            currentda = "0"+String.valueOf(currentdas);
//        }else {
//            currentda = String.valueOf(currentdas);
//        }
//
//        updateyear =  String.valueOf(yea);
//        View view = convertView;
//        try {
//            if (view == null) {
//                view = mInflater.inflate(R.layout.single_cell_layout, parent, false);
//            }
////            eventIndicator = (View) view.findViewById(R.id.cscs);
////            eventIndicatorday = (View) view.findViewById(R.id.csday);
//
//            cellNumber = (TextView) view.findViewById(R.id.calendar_date_id);
//
//            calanderrate = (TextView) view.findViewById(R.id.calander_rate);
//
//            cellNumber.setText(String.valueOf(dayValue));
//
//            lv = (RelativeLayout)view.findViewById(R.id.event_wrapper);
//            maincell = (LinearLayout)view.findViewById(R.id.lir);
//
////            lv1.setVisibility(View.GONE);
////            lv2.setVisibility(View.GONE);
//            lv.setBackgroundResource(0);
//            maincell.setBackgroundResource(0);
//            cellNumber.setTextColor(Color.BLACK);
//            calanderrate.setTextColor(ContextCompat.getColor(getContext(), R.color.colorfeedtextdes));
//            maincell.setBackgroundColor(Color.WHITE);
//            calanderrate.setVisibility(View.GONE);
////            lv1.setBackgroundColor(Color.WHITE);
////            lv2.setBackgroundColor(Color.WHITE);
////            lv1.setVisibility(View.GONE);
////            lv2.setVisibility(View.GONE);
//
//            Calendar cal = Calendar.getInstance();
//            final int currentMonthcal = cal.get(Calendar.MONTH) + 1;
//            final int currentdascal = cal.get(Calendar.DAY_OF_MONTH);
//            final int currentyearv1 = cal.get(Calendar.YEAR);
//
//
//
//            if (displayMonth == currentMonth && displayYear == currentyearv1) {
//                if(displayMonth >= currentMonthcal) {
//                    if (dayValue >= currentdascal || displayMonth > currentMonthcal) {
//
//
//                        if (dayValue == currentdascal && displayMonth == currentMonthcal && displayYear == currentyearv1) {
//                            cellNumber.setTextColor(ContextCompat.getColor(getContext(), R.color.colorOrange));
//
//                        } else {
//                            cellNumber.setTextColor(Color.BLACK);
//
//                        }
//
//                        if (eventsFirstLast.size() > 0) {
//                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//                            Date netDate = null;
//                            try {
//
//
//                                Calendar firstDateCal = Calendar.getInstance();
//                                firstDateCal.setTime(firstDateView);
//                                String day = formatter.format(firstDateCal.getTime());
//                                final int month = firstDateCal.get(Calendar.MONTH) + 1;
//
//                                if (day.equals(sDate) && month == displayMonth) {
//                                    lv.setBackgroundResource(R.drawable.greencircle);
//                                    cellNumber.setTextColor(Color.WHITE);
////                                 lv1.setBackgroundColor(Color.GRAY);
////                                 lv1.setVisibility(View.VISIBLE);
//                                    if (!firstRate.equals("")) {
//                                        calanderrate.setVisibility(View.VISIBLE);
//                                        calanderrate.setText(firstRate);
//                                        calanderrate.setTextColor(Color.WHITE);
//                                    }
//
//                                    if (selectDate) {
//                                        //   if(eventsFirstLast.size() != 1)
//                                        calanderrate.setTextColor(Color.WHITE);
//                                        maincell.setBackgroundResource(R.drawable.cellleftv1);
//
//                                    }
////                                    if (eventsFirstLast.size() > 2) {
////                                    //maincell.setBackgroundResource(R.drawable.cellleft);
////                                }
//                                }
//
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//
//
//                            try {
//
//                                Calendar secondDateCal = Calendar.getInstance();
//                                secondDateCal.setTime(secondDateView);
//                                String day = formatter.format(secondDateCal.getTime());
//                                final int month = secondDateCal.get(Calendar.MONTH) + 1;
//
//
//                                if (day.equals(sDate) && month == displayMonth) {
//
//
//                                    if (selectDate) {
//                                        lv.setBackgroundResource(R.drawable.darkcirlceboder);
//                                        cellNumber.setTextColor(Color.BLACK);
//                                    }
////                             lv2.setBackgroundColor(Color.GRAY);
////                             lv2.setVisibility(View.VISIBLE);
//                                    if (!secondRate.equals("")) {
//                                        calanderrate.setVisibility(View.VISIBLE);
//                                        calanderrate.setText(secondRate);
//
//                                    }
//                                    if (selectDate) {
//                                        //  if(eventsFirstLast.size() != 1)
//                                        maincell.setBackgroundResource(R.drawable.cellrightv1);
//
//
//                                    }
//
//
////                                if (eventsFirstLast.size() > 2) {
////                                    maincell.setBackgroundResource(R.drawable.cellrightv1);
////                                }
//                                }
//
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                            if (!mDate.getMessage().equals("")) {
//                                calanderrate.setVisibility(View.VISIBLE);
//                                if (mDate.getDescount() < 0) {
//                                    calanderrate.setTextColor(ContextCompat.getColor(getContext(), R.color.lightgreen));
//                                }
//                                calanderrate.setText(mDate.getMessage());
//                            }
//
//                            if (countValueStatus) {
//                                callrecycler(null, null, eventsFirstLast, lv, cellNumber, dayValue, null, sDate, displayMonth, maincell, calanderrate);
//                            }
//                        }
//
//                    } else {
//                        cellNumber.setTextColor(ContextCompat.getColor(getContext(), R.color.lightgrey));
//                    }
//                }else {
//                    cellNumber.setTextColor(ContextCompat.getColor(getContext(), R.color.lightgrey));
//
//                }
//            } else {
//                cellNumber.setTextColor(ContextCompat.getColor(getContext(), R.color.lightgrey));
//
//            }
//
//            if(previousposition != 0)
//                if(previousposition == position){
//                    ///  eventIndicatorday.setBackgroundColor(getContext().getResources().getColor(R.color.green_color));
//                    // cellNumber.setBackgroundResource(Color.parseColor("#567845"));
//                    // holder.tv1.setTextColor(Color.parseColor("#ffffff"));
//                }
//                else
//                {
//                    // eventIndicatorday.setVisibility(View.GONE);
//                    cellNumber.setBackgroundResource(R.drawable.blankcircel);
//                }
//
//
//
//            if(displayMonth == monthcur) {
//                if (dayValue == currentdas) {
//                    cellNumber.setBackgroundResource(R.drawable.greencircle);
//                    cellNumber.setTextColor(Color.GREEN);
//
//                    // cellNumber.setTextColor(Color.parseColor("#000"));
//                    // cellNumber.setBackgroundColor(R.color.black);
//                    //cellNumber.setBackgroundColor(Color.parseColor("#000"));
//                }
//            }
//
//
//        }catch(NullPointerException e){
//            System.out.println("In catch");
//        }
//        return view;
//    }
//    public void update(ArrayList<EventObjects> list, String firstdate, String seconddate, ArrayList<EventObjects> eventObjects, ArrayList<EventObjectsTime> listDaysRatev, ArrayList<EventObjectsSecond> dayValueDatav1) {
//        countValueStatus = false;
//        monthlyDates = dayValueDatav1;
//        eventsFirstLast.clear();
//        eventsFirstLast.addAll(list);
//        listDaysRate.addAll(listDaysRatev);
//
//        if(eventsFirstLast.size() > 0){
//            //  this.firstRate = eventsFirstLast.get(0).getMessage();
//            //   this.secondRate =  eventsFirstLast.get(eventsFirstLast.size() - 1).getMessage();
//            firstDateView = eventsFirstLast.get(0).getDate();
//            secondDateView = eventsFirstLast.get(eventsFirstLast.size() - 1).getDate();}
//        if (eventsFirstLast.size() > 2) {
//            countValueStatus = true;
//            eventsFirstLast.remove(0); // removes the first item
//            eventsFirstLast.remove(eventsFirstLast.size() - 1);
//        }
//
//        notifyDataSetChanged();
//    }
//    @SuppressLint("ResourceType")
//    private void callrecycler(LinearLayout lv1, LinearLayout lv2, ArrayList<EventObjects> eventsFirstLast, RelativeLayout lv, TextView cellNumber, int dayValue, View eventIndicator, String date, int displayMonth, LinearLayout maincell, TextView calanderrate) {
//        for (int k =0 ; k < eventsFirstLast.size(); k++){
//            String  day = formatter.format(eventsFirstLast.get(k).getDate().getTime());
//
//            Calendar dateCalv1 = Calendar.getInstance();
//            dateCalv1.setTime(eventsFirstLast.get(k).getDate());
//            final int displayMonthv1 = dateCalv1.get(Calendar.MONTH) + 1;
//            //   if(day.equals(date)){
//            if (day.equals(date) && displayMonthv1 == displayMonth) {
//                // eventIndicator.setVisibility(View.VISIBLE);
//                maincell.setBackgroundColor(Color.parseColor("#E6E6E6"));
//                if(!eventsFirstLast.get(k).getMessage().equals("")){
//                    //calanderrate.setVisibility(View.VISIBLE);
//                    //calanderrate.setText(eventsFirstLast.get(k).getMessage());
//                }
//
//                break;
//            }
//
//        }
//
//    }
//
//    private String getDate2(String d) {
//        try {
//            //.DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
//            // displayYear+"-"+"0"+currentMonth+"-"+dateno;
//            // DateFormat sdf = new SimpleDateFormat("EEE.dd-MMM-yyyy");
//            DateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
//            Date netDate = (new Date(Long.parseLong(d)));
//            return sdf.format(netDate);
//        } catch (Exception ignored) {
//            return "xx";
//        }
//    }
//
//    private String gettimesec(String jobtime) {
//        try {
//            // DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            Date netDate = sdf.parse(jobtime);
//
//            daa = netDate.getDay();
//            mnth = netDate.getMonth();
//            ye = netDate.getYear();
//
//            return netDate.getDay() + " hours " + netDate.getMonth() + " minutes " + netDate.getYear() + " seconds";
//
//            //return sdf.format(netDate);
//
//        } catch (Exception ignored) {
//            return "xx";
//        }
//
//    }
//
//    @Override
//    public int getCount() {
//        return monthlyDates.size();
//    }
//    @Nullable
//    @Override
//    public Object getItem(int position) {
//        return monthlyDates.get(position);
//    }
//    @Override
//    public int getPosition(Object item) {
//        return monthlyDates.indexOf(item);
//    }
//
//
//    private String getDate(String date) {
//        try {
//            //.DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
//            // displayYear+"-"+"0"+currentMonth+"-"+dateno;
//            // DateFormat sdf = new SimpleDateFormat("EEE.dd-MMM-yyyy");
//            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            Date netDate = (new Date(Long.parseLong(date)));
//            return sdf.format(netDate);
//        } catch (Exception ignored) {
//            return "xx";
//        }
//    }
//
//
//    public void setview(int position) {
//        previousposition = position;
//        notifyDataSetChanged();
//        //  cellNumber.setBackgroundResource(R.drawable.greencircle);
//
//    }
//}
