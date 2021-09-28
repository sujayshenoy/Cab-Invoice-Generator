package com.yml;

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
       
}
