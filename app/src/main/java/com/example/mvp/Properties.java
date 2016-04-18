package com.example.mvp;

import java.util.Date;

public class Properties {
    private String type;
    private String title;
    private long time;

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public Date getTime() {
        return new Date(time);
    }
}
