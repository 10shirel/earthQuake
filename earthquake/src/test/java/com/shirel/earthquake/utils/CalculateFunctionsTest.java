package com.shirel.earthquake.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by shirel on 12/17/2016.
 */
public class CalculateFunctionsTest {

    @Test
    public void testCalculateMedian() throws Exception {
        //Case 1
        int[] numArray = new int[]{3, 2, 3, 7, 5, 10};
        Double actual = CalculateFunctions.calculateMedian(numArray);
        Double expected = new Double(4.0);
        assertEquals(actual, expected);

        //Case 2
        numArray = new int[]{1,3,3,7,6,9,8};
        expected = CalculateFunctions.calculateMedian(numArray);
        assertEquals(expected , new Double(6.0));
    }

    @Test
    public void calculateAverage() throws Exception {
        int a = 5;
        int b = 2;
        Double actual = CalculateFunctions.calculateAverage(a, b);
        Double expected =  new Double(2.5);
        assertEquals(actual, expected);
    }
}