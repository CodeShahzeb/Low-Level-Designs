package com.riding.app;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        //---------------Creating Riders and Drivers--------------------------------
        Rider keertiRider = new Rider("Keerti", RATING.FIVE_STARS);
        Rider gauravRider = new Rider("Gaurav", RATING.FIVE_STARS);
        RiderMgr riderMgr = RiderMgr.getRiderMgr();
        riderMgr.addRider("keerti", keertiRider);
        riderMgr.addRider("gaurav", gauravRider);

        Driver yogitaDriver = new Driver("Yogita", RATING.THREE_STARS);
        Driver riddhiDriver = new Driver("Riddhi", RATING.FOUR_STARS);
        DriverMgr driverMgr = DriverMgr.getDriverMgr();
        driverMgr.addDriver("yogita", yogitaDriver);
        driverMgr.addDriver("riddhi", riddhiDriver);

        //These details in turn will be stored in database
        //-------------------------------------------------------------------------

        TripMgr tripMgr = TripMgr.getTripMgr();

        System.out.println("\nCreating Trip for Keerti from location (10,10) to (30,30)");
        Location keertiStartLoc = new Location(10, 10);
        Location keertiEndLoc = new Location(30, 30);
        tripMgr.CreateTrip(keertiRider,  keertiStartLoc, keertiEndLoc);
       // tripMgr.CreateTrip(keertiRider, keertiStartLoc, keertiEndLoc);

        System.out.println("\nCreating Trip for Gaurav from location (200,200) to (500,500)");
        Location gauravStartLoc = new Location(200, 200);
        Location gauravEndLoc = new Location(500, 500);
        tripMgr.CreateTrip(gauravRider, new Location(200, 200), new Location(500, 500));
       // tripMgr.CreateTrip(gauravRider, gauravStartLoc, gauravEndLoc);

        //-------------------Display all the trips created--------------------------
        HashMap<Integer, Trip> tripsMap = (HashMap<Integer, Trip>) tripMgr.getTripsMap();
        for (Trip trip : tripsMap.values()) {
            trip.displayTripDetails();
        }
    }
}
