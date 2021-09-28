package com.yml;

public class Ride {
    int userID;
    int time;
    int distance;

    Ride(int userID, int distance, int time) {
        this.userID = userID;
        this.time = time;
        this.distance = distance;
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
