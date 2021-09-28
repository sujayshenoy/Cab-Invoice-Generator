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

    public double generateMultipleFare(List<Ride> rides) {
        double cost = 0;

        for (Ride ride : rides) {
            cost += generateFare(ride.distance, ride.time);
        }

        return cost;
    }

<<<<<<< HEAD
    public List<Double> enhancedInvoice(List<Ride> rides) {
        List<Double> result = new ArrayList<Double>();
=======
    public Invoice enhancedInvoice(Ride[] rides) {
>>>>>>> step3
        double cost = 0;
        for (Ride ride : rides) {
            cost += generateFare(ride.distance, ride.time);
        }

<<<<<<< HEAD
        result.add(Double.valueOf(rides.size()));
        result.add(cost);
        result.add(cost / rides.size());
        
        return result;
=======
        return new Invoice(rides.length, cost, cost / rides.length);
>>>>>>> step3
    }
       
}
