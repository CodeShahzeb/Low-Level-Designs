package com.riding.app;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

// Singleton class
public class RiderMgr {
    private static RiderMgr riderMgrInstance;
    private static ReentrantLock mtx = new ReentrantLock();
    private Map<String, Rider> ridersMap = new HashMap<>();

    private RiderMgr() {}

    public static RiderMgr getRiderMgr() {
        if (riderMgrInstance == null) {
            mtx.lock();
            try {
                if (riderMgrInstance == null) {
                    riderMgrInstance = new RiderMgr();
                }
            } finally {
                mtx.unlock();
            }
        }
        return riderMgrInstance;
    }

    public void addRider(String pRiderName, Rider pRider) {
        ridersMap.put(pRiderName, pRider);
    }

    public Rider getRider(String pRiderName) {
        return ridersMap.get(pRiderName);
    }
}




