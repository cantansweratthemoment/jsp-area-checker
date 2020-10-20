package models;

import java.util.Date;

public class Clock {
    private String date;
    private double start;
    private double end;

    public Clock() {
        this.date = new Date().toString();
    }

    public void start() {
        this.start = (double) System.currentTimeMillis()*100000;
    }

    public void stop() {
        this.end = (double) System.currentTimeMillis()*100000 - this.start;
    }

    public String getDate() {
        return date;
    }

    public double getStart() {
        return start;
    }

    public double getEnd() {
        return end;
    }
}
