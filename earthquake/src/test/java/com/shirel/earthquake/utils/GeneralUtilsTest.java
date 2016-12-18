package com.shirel.earthquake.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by shirel on 12/18/2016.
 */
public class GeneralUtilsTest {

    @Test
    public void testGetCountryName() throws Exception {
        String countryName = "abc, name1";
        String actual = GeneralUtils.getCountryName(countryName);
        String expected = "name1";
        assertEquals(actual , expected);
    }

    @Test
    public void testGetCountryNameMoreThanOneComma() throws Exception {
        String countryName = "abc, ceg, name3";
        String actual = GeneralUtils.getCountryName(countryName);
        String expected = GeneralUtils.getCountryName(countryName);
        assertEquals(actual , expected);
    }
}
