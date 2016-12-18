package com.shirel.earthquake;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shirel on 12/17/2016.
 */
public class Result {

    //Highest Number
    private String globalNameHighestNumberOfEarthquakes = null;
    private int globalCountHighestNumberOfEarthquakes =0;

    //Highest Magnitude
    private String globalNameHighestMagnitude = null ;
    private double globalCountHighestMagnitude;

    //averageOfEarthQuakes calculate all the EarthQuakes on the world / number of countries
    private int globalNumberOfEarthquakes;
    private int globalNumberOfCounties;
    private double averageOfEarthQuakes;

    //Closest Point
    private String globalTiltleClosest = null ;
    private String globalUrlClosest = null ;
    private double globalClosestX2;
    private double globalClosestY2;


    public String getGlobalTiltleClosest() {
        return globalTiltleClosest;
    }

    public void setGlobalTiltleClosest(String globalTiltleClosest) {
        this.globalTiltleClosest = globalTiltleClosest;
    }

    public String getGlobalUrlClosest() {
        return globalUrlClosest;
    }

    public void setGlobalUrlClosest(String globalUrlClosest) {
        this.globalUrlClosest = globalUrlClosest;
    }

    public double getGlobalClosestX2() {
        return globalClosestX2;
    }

    public void setGlobalClosestX2(double globalClosestX2) {
        this.globalClosestX2 = globalClosestX2;
    }

    public double getGlobalClosestY2() {
        return globalClosestY2;
    }

    public void setGlobalClosestY2(double globalClosestY2) {
        this.globalClosestY2 = globalClosestY2;
    }


    private Map<String, CountryDetails> countryNameToCountryDetails = new HashMap<>();

    public String getGlobalNameHighestNumberOfEarthquakes() {
        return globalNameHighestNumberOfEarthquakes;
    }

    public void setGlobalNameHighestNumberOfEarthquakes(String globalNameHighestNumberOfEarthquakes) {
        this.globalNameHighestNumberOfEarthquakes = globalNameHighestNumberOfEarthquakes;
    }

    public int getGlobalCountHighestNumberOfEarthquakes() {
        return globalCountHighestNumberOfEarthquakes;
    }

    public void setGlobalCountHighestNumberOfEarthquakes(int globalCountHighestNumberOfEarthquakes) {
        this.globalCountHighestNumberOfEarthquakes = globalCountHighestNumberOfEarthquakes;
    }

    public String getGlobalNameHighestMagnitude() {
        return globalNameHighestMagnitude;
    }

    public void setGlobalNameHighestMagnitude(String globalNameHighestMagnitude) {
        this.globalNameHighestMagnitude = globalNameHighestMagnitude;
    }

    public double getGlobalCountHighestMagnitude() {
        return globalCountHighestMagnitude;
    }

    public void setGlobalCountHighestMagnitude(double globalCountHighestMagnitude) {
        this.globalCountHighestMagnitude = globalCountHighestMagnitude;
    }

    public int getGlobalNumberOfEarthquakes() {
        return globalNumberOfEarthquakes;
    }

    public void setGlobalNumberOfEarthquakes(int globalNumberOfEarthquakes) {
        this.globalNumberOfEarthquakes = globalNumberOfEarthquakes;
    }

    public int getGlobalNumberOfCounties() {
        return globalNumberOfCounties;
    }

    public void setGlobalNumberOfCounties(int globalNumberOfCounties) {
        this.globalNumberOfCounties = globalNumberOfCounties;
    }

    public double getAverageOfEarthQuakes() {
        return averageOfEarthQuakes;
    }

    public void setAverageOfEarthQuakes(double averageOfEarthQuakes) {
        this.averageOfEarthQuakes = averageOfEarthQuakes;
    }

    public Map<String, CountryDetails> getCountryNameToCountryDetails() {
        return countryNameToCountryDetails;
    }

    public void setCountryNameToCountryDetails(Map<String, CountryDetails> countryNameToCountryDetails) {
        this.countryNameToCountryDetails = countryNameToCountryDetails;
    }
}
