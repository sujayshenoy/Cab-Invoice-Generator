package com.yml;

import java.util.List;

/**
 * Hello world!
 *
 */
public class CabInvoiceGenerator 
{
    enum RideType {
        NORMAL, PREMIUM
    };

    private final int NORMAL_MIN_FARE = 5;
    private final int PREMIUM_MIN_FARE = 20;
    private final int NORMAL_FARE_PER_KM = 10;
    private final int PREMIUM_FARE_PER_KM = 15;
    private final int NORMAL_FARE_PER_MIN = 1;
    private final int PREMIUM_FARE_PER_MIN = 2;


    public double generateFare(RideType typeOfRide, int distance, int time) {
        if (typeOfRide == RideType.NORMAL) {
            double cost = distance * NORMAL_FARE_PER_KM;
            cost += time * NORMAL_FARE_PER_MIN;
            return cost > NORMAL_MIN_FARE ? cost : NORMAL_MIN_FARE;
        }
        else {
            double cost = distance * PREMIUM_FARE_PER_KM;
            cost += time * PREMIUM_FARE_PER_MIN;
            return cost > PREMIUM_MIN_FARE ? cost : PREMIUM_MIN_FARE;
        }
    }

    public double generateMultipleFare(List<Ride> rides) {
        double cost = 0;

        for (Ride ride : rides) {
            cost += generateFare(ride.type, ride.distance, ride.time);
        }

        return cost;
    }

    public Invoice enhancedInvoice(List<Ride> rides) {
        double cost = 0;
        for (Ride ride : rides) {
            cost += generateFare(ride.type, ride.distance, ride.time);
        }

        return new Invoice(rides.size(), cost, cost / rides.size());
    }
}
