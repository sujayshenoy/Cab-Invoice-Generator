package com.yml;

public class Ride {
    int time;
    int distance;

    Ride(int distance,int time) {
        this.time = time;
        this.distance = distance;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    
}
