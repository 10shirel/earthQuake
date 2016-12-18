package com.shirel.earthquake;

/**
 * Created by shirel on 12/17/2016.
 */
public class Output {


    /**
     * The country with the highest number of earthquakes
     */
    private String highNumCntr;
    private int highNumCntrNumber;


    /**
     * The country with highest magnitude earthquake
     */
    private String highMagCntr;
    private double highMagCntrNumber;

    /**
     * The average number of earthquakes occurred in a country
     */
    private double avgEarthquakes;

    /**
     * The median number of earthquakes occurred in a country
     */
    private double medEarthquakes;

    /**
     *  The closest earthquake between specific point
     */
    String closestTitle;
    String closestUrl;

    public String getHighNumCntr() {
        return highNumCntr;
    }

    public int getHighNumCntrNumber() {
        return highNumCntrNumber;
    }

    public void setHighNumCntrNumber(int highNumCntrNumber) {
        this.highNumCntrNumber = highNumCntrNumber;
    }

    public void setHighNumCntr(String highNumCntr) {
        this.highNumCntr = highNumCntr;
    }

    public String getHighMagCntr() {
        return highMagCntr;
    }

    public void setHighMagCntr(String highMagCntr) {
        this.highMagCntr = highMagCntr;
    }

    public double getHighMagCntrNumber() {
        return highMagCntrNumber;
    }

    public void setHighMagCntrNumber(double highMagCntrNumber) {
        this.highMagCntrNumber = highMagCntrNumber;
    }

    public double getAvgEarthquakes() {
        return avgEarthquakes;
    }

    public void setAvgEarthquakes(double avgEarthquakes) {
        this.avgEarthquakes = avgEarthquakes;
    }

    public double getMedEarthquakes() {
        return medEarthquakes;
    }

    public void setMedEarthquakes(double medEarthquakes) {
        this.medEarthquakes = medEarthquakes;
    }

    public String getClosestTitle() {
        return closestTitle;
    }

    public void setClosestTitle(String closestTitle) {
        this.closestTitle = closestTitle;
    }

    public String getClosestUrl() {
        return closestUrl;
    }

    public void setClosestUrl(String closestUrl) {
        this.closestUrl = closestUrl;
    }
}
