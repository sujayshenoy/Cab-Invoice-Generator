package com.yml;

import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CabInvoiceGeneratorTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void calculatedFareShouldMatchExpected()
    {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();

        int distance = 10; // in kms
        int time = 60; // in minutes
        double calculatedFare = cabInvoiceGenerator.generateFare(distance, time);
        double expectedFare = 160;

        assertEquals(expectedFare, calculatedFare, 0);
    }
    
    @Test
    public void calculatedAggregatedFareShouldMatchExpected() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();

        Ride[] rides = { new Ride(10, 60), new Ride(20, 30) };

        double aggregateFare = cabInvoiceGenerator.generateMultipleFare(rides);
        double expectedAggregatedFare = 390;

        assertEquals(expectedAggregatedFare, aggregateFare, 0);
    }
    
    @Test
    public void calculateTotalRidesTotalFareAverageFareMatchExpected() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();

        Ride[] rides = { new Ride(10, 60), new Ride(20, 30) };
        List<Double> result = cabInvoiceGenerator.enhancedInvoice(rides);
        int expectedTotalRides = 2;
        double expectedTotalFare = 390;
        double expectedAverageFare = 195;

        assertEquals(expectedTotalRides, result.get(0),0);
        assertEquals(expectedTotalFare, result.get(1),0);
        assertEquals(expectedAverageFare, result.get(2),0);
    }
}
