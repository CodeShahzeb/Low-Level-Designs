package com.riding.app;

public class Driver {
    private String name;
    private boolean avail;
    private RATING rating;

    public Driver(String name, RATING rating) {
        this.name = name;
        this.rating = rating;
        this.avail = false;
    }

    public void updateAvail(boolean avail) {
        this.avail = avail;
    }

    public String getDriverName() {
        return this.name;
    }

    public RATING getRating() {
        return this.rating;
    }
}

