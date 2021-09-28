package com.yml;

import static org.junit.Assert.assertEquals;
import java.util.*;
import java.util.stream.Collectors;

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

        RideRepository rideRepository = new RideRepository();
        rideRepository.addRide(new Ride(1,10, 60));
        rideRepository.addRide(new Ride(1,20, 30));

        double aggregateFare = cabInvoiceGenerator.generateMultipleFare(rideRepository.getAllRides());
        double expectedAggregatedFare = 390;

        assertEquals(expectedAggregatedFare, aggregateFare, 0);
    }
    
    @Test
    public void calculateTotalRidesTotalFareAverageFareMatchExpected() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();

        RideRepository rideRepository = new RideRepository();
        rideRepository.addRide(new Ride(1,10, 60));
        rideRepository.addRide(new Ride(1,20, 30));
        Invoice invoice = cabInvoiceGenerator.enhancedInvoice(rideRepository.getAllRides());
        int expectedTotalRides = 2;
        double expectedTotalFare = 390;
        double expectedAverageFare = 195;

        assertEquals(expectedTotalRides, invoice.getTotalRides(), 0);
        assertEquals(expectedTotalFare, invoice.getTotalFare(), 0);
        assertEquals(expectedAverageFare, invoice.getAverageFare(), 0);
    }
    
    @Test
    public void calculateInvoiceOfMultipleUsersMatchExpected() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        RideRepository rideRepository = new RideRepository();

        rideRepository.addRide(new Ride(1, 10, 60));
        rideRepository.addRide(new Ride(2, 50, 30));
        rideRepository.addRide(new Ride(1, 20, 50));
        rideRepository.addRide(new Ride(2, 60, 40));
        rideRepository.addRide(new Ride(1, 30, 40));
        rideRepository.addRide(new Ride(2, 70, 50));
        rideRepository.addRide(new Ride(1, 40, 30));
        rideRepository.addRide(new Ride(2, 80, 60));

        //rides of user 1
        Invoice invoice = cabInvoiceGenerator.enhancedInvoice(rideRepository.getAllRides().stream()
                .filter( ride -> ride.getUserID() == 1).collect(Collectors.toList()));
        int expectedTotalRides = 4;
        double expectedTotalFare = 1180;
        double expectedAverageFare = 295;

        assertEquals(expectedTotalRides, invoice.getTotalRides(), 0);
        assertEquals(expectedTotalFare, invoice.getTotalFare(), 0);
        assertEquals(expectedAverageFare, invoice.getAverageFare(), 0);

        //rides of user 2
        invoice = cabInvoiceGenerator.enhancedInvoice(rideRepository.getAllRides().stream()
                .filter( ride -> ride.getUserID() == 2).collect(Collectors.toList()));
        expectedTotalRides = 4;
        expectedTotalFare = 2780;
        expectedAverageFare = 695;

        assertEquals(expectedTotalRides, invoice.getTotalRides(), 0);
        assertEquals(expectedTotalFare, invoice.getTotalFare(), 0);
        assertEquals(expectedAverageFare, invoice.getAverageFare(), 0);

    }
}
