package com.yml;

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

    public double generateMultipleFare(List<Ride> rides) {
        double cost = 0;

        for (Ride ride : rides) {
            cost += generateFare(ride.distance, ride.time);
        }

        return cost;
    }

    public Invoice enhancedInvoice(List<Ride> rides) {
        double cost = 0;
        for (Ride ride : rides) {
            cost += generateFare(ride.distance, ride.time);
        }

        return new Invoice(rides.size(), cost, cost / rides.size());
    }
}
