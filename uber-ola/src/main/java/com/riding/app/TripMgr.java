package com.riding.app;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TripMgr {
    private static TripMgr tripMgrInstance = null;
    private static Lock mtx = new ReentrantLock();
    private RiderMgr riderMgr;
    private DriverMgr driverMgr;
    private Map<Integer, TripMetaData> tripsMetaDataInfo;
    private Map<Integer, Trip> tripsInfo;

    private TripMgr() {
        riderMgr = RiderMgr.getRiderMgr();
        driverMgr = DriverMgr.getDriverMgr();
        tripsMetaDataInfo = new HashMap<>();
        tripsInfo = new HashMap<>();
    }

    public static TripMgr getTripMgr() {
        if (tripMgrInstance == null) {
            mtx.lock();
            try {
                if (tripMgrInstance == null) {
                    tripMgrInstance = new TripMgr();
                }
            } finally {
                mtx.unlock();
            }
        }
        return tripMgrInstance;
    }



    public Map<Integer, Trip> getTripsMap() {
        return tripsInfo;
    }

    public void CreateTrip(Rider rider, Location srcLoc, Location dstLoc) {
        TripMetaData metaData = new TripMetaData(srcLoc, dstLoc, rider.getRating());
        StrategyMgr strategyMgr = StrategyMgr.getStrategyMgr();
        PricingStrategy pricingStrategy = strategyMgr.determinePricingStrategy(metaData);
        DriverMatchingStrategy driverMatchingStrategy = strategyMgr.determineMatchingStrategy(metaData);

        Driver driver = driverMatchingStrategy.matchDriver(metaData);
        double tripPrice = pricingStrategy.calculatePrice(metaData);

        Trip trip = new Trip(rider, driver, srcLoc, dstLoc, tripPrice, pricingStrategy, driverMatchingStrategy);
        int tripId = trip.getTripId();
        tripsInfo.put(tripId, trip);
        tripsMetaDataInfo.put(tripId, metaData);
    }

}
