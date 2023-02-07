package com.syedbilalali.customcalanderview;

import java.util.Date;

public class EventObjectsSecond {
    public int id;

    public int getDescount() {
        return descount;
    }

    public void setDescount(int descount) {
        this.descount = descount;
    }

    public int descount;

    public void setId(int id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private String message;
    private Date date;

    public int getId() {
        return id;
    }
    public String getMessage() {
        return message;
    }
    public Date getDate() {
        return date;
    }
}
