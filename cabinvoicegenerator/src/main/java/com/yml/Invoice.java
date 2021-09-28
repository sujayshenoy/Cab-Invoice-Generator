package com.yml;

public class Invoice {
    private int totalRides;
    private double totalFare;
    private double averageFare;

    Invoice(int totalRides, double totalFare, double averageFare) {
        this.totalRides = totalRides;
        this.totalFare = totalFare;
        this.averageFare = averageFare;
    }

    public int getTotalRides() {
        return totalRides;
    }

    public void setTotalRides(int totalRides) {
        this.totalRides = totalRides;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(double totalFare) {
        this.totalFare = totalFare;
    }

    public double getAverageFare() {
        return averageFare;
    }

    public void setAverageFare(double averageFare) {
        this.averageFare = averageFare;
    }

    
}

