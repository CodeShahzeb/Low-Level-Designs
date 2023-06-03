package com.riding.app;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DriverMgr {

    private static volatile DriverMgr driverMgrInstance;
    private static final Lock mtx = new ReentrantLock();
    private Map<String, Driver> driversMap = new HashMap<>();

    private DriverMgr() {
        // private constructor to prevent direct instantiation
    }

    public static DriverMgr getDriverMgr() {
        if (driverMgrInstance == null) {
            mtx.lock();
            try {
                if (driverMgrInstance == null) {
                    driverMgrInstance = new DriverMgr();
                }
            } finally {
                mtx.unlock();
            }
        }
        return driverMgrInstance;
    }

    public void addDriver(String driverName, Driver driver) {
        driversMap.put(driverName, driver);
    }

    public Driver getDriver(String driverName) {
        return driversMap.get(driverName);
    }

    public Map<String, Driver> getDriversMap() {
        return driversMap;
    }
}
