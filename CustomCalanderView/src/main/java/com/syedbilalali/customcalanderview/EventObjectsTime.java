package com.syedbilalali.customcalanderview;

import java.util.Date;

public class EventObjectsTime {
    private String dayname;
    private String Rates;
    private int id = 0;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Date date = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getDayname() {
        return dayname;
    }

    public void setDayname(String dayname) {
        this.dayname = dayname;
    }

    public String getRates() {
        return Rates;
    }

    public void setRates(String rates) {
        Rates = rates;
    }


}
