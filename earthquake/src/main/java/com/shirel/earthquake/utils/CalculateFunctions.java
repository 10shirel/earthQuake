package com.shirel.earthquake.utils;


import java.util.Arrays;

/**
 * Created by shirel on 12/17/2016.
 */
public class CalculateFunctions {

    public static double calculateMedian(int[] numArray) {
        Arrays.sort(numArray);
        double median;
        if (numArray.length % 2 == 0)
            median = ((double) numArray[numArray.length / 2] + (double) numArray[numArray.length / 2 - 1]) / 2;
        else
            median = (double) numArray[numArray.length / 2];
        return median;
    }

    public static double calculateEuclideanDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }


    public static double calculateAverage(int a, int b) {
        return (double) a / b;
    }

}
