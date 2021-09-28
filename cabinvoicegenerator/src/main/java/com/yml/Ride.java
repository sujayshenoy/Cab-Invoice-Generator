package com.yml;

import com.yml.CabInvoiceGenerator.RideType;

public class Ride {
    int userID;
    int time;
    int distance;
    RideType type;

    Ride(int userID, int distance, int time, RideType type) {
        this.userID = userID;
        this.time = time;
        this.distance = distance;
        this.type = type;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    
}
