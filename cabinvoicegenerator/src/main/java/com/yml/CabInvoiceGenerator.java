package com.yml;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class CabInvoiceGenerator 
{
    private final int MIN_FARE = 5;

    public double generateFare(int distance, int time) {
        double cost = distance * 10;
        cost += time * 1;

        return cost > MIN_FARE ? cost : MIN_FARE;
    }

    public double generateMultipleFare(Ride[] rides) {
        double cost = 0;
        for (int i = 0; i < rides.length; i++) {
            cost += generateFare(rides[i].distance, rides[i].time);
        }

        return cost;
    }
       
}
