package com.riding.app;

import java.util.concurrent.atomic.AtomicInteger;

public class Trip {
    private Rider rider;
    private Driver driver;
    private Location srcLoc;
    private Location dstLoc;
    private TRIP_STATUS status;
    private int tripId;
    private double price;
    private PricingStrategy pricingStrategy;
    private DriverMatchingStrategy driverMatchingStrategy;
    private static final AtomicInteger nextTripId = new AtomicInteger(1);

    public Trip(Rider pRider, Driver pDriver, Location pSrcLoc, Location pDstLoc, double pPrice,
                PricingStrategy pPricingStrategy, DriverMatchingStrategy pDriverMatchingStrategy) {
        rider = pRider;
        driver = pDriver;
        srcLoc = pSrcLoc;
        dstLoc = pDstLoc;
        price = pPrice;
        pricingStrategy = pPricingStrategy;
        driverMatchingStrategy = pDriverMatchingStrategy;
        status = TRIP_STATUS.DRIVER_ON_THE_WAY;
        tripId = nextTripId.getAndIncrement();
    }

    public int getTripId() {
        return tripId;
    }

    public void displayTripDetails() {
        System.out.println();
        System.out.println("Trip id - " + tripId);
        System.out.println("Rider - " + rider.getRiderName());
        System.out.println("Driver - " + driver.getDriverName());
        System.out.println("Price - " + price);
        System.out.println("Locations - " + srcLoc.getLatitude() + "," + srcLoc.getLongitude() + " and "
                + dstLoc.getLatitude() + "," + dstLoc.getLongitude());
    }
}
