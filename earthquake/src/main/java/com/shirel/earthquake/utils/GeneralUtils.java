package com.shirel.earthquake.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.shirel.earthquake.CountryDetails;
import com.shirel.earthquake.Result;

import java.io.IOException;
import java.util.Map;

/**
 * Created by shirel on 12/17/2016.
 */
public class GeneralUtils {
    public static String getCountryName(String place) {
        String[] split = place.split(",");
        String countryName;
        if (split.length == 1) {
            countryName = place.trim().toLowerCase();
        } else {
            countryName = split[split.length - 1].trim().toLowerCase();
        }
        return countryName;
    }

    static void setClosest(Result result, JsonNode properties, JsonNode geometry, double x1, double y1) {
        JsonNode coordinates = geometry.get("coordinates");
        double longitudeCurrentX2 = coordinates.get(0).asDouble();
        double latitudeCurrentY2 = coordinates.get(1).asDouble();

        double beforeClosest = CalculateFunctions.calculateEuclideanDistance(x1, y1, result.getGlobalClosestX2(), result.getGlobalClosestY2());
        double currentClosest = CalculateFunctions.calculateEuclideanDistance(x1, y1, longitudeCurrentX2, latitudeCurrentY2);

        //in case of equals we use the old, we dont change anything
        if (currentClosest < beforeClosest){
            result.setGlobalTiltleClosest(properties.get("title").asText());
            result.setGlobalUrlClosest(properties.get("url").asText());
            result.setGlobalClosestX2(longitudeCurrentX2);
            result.setGlobalClosestY2(latitudeCurrentY2);

        }


    }

    static void prepareForCalculateAvg(Result result, CountryDetails currentCountryDetails) {
        result.setGlobalNumberOfEarthquakes(result.getGlobalNumberOfEarthquakes() + 1);
        if (currentCountryDetails == null) { //incremental count of countries in case this is the first one
            result.setGlobalNumberOfCounties(result.getGlobalNumberOfCounties() + 1);
        }
    }

    static CountryDetails updateCountriesMap(CountryDetails currentCountryDetails, String countryName, Result result) {
        //CountryDetails currentCountryDetails = result.getCountryNameToCountryDetails().get(countryName);
        if (currentCountryDetails == null) {// add country - this is the first time
            currentCountryDetails = new CountryDetails();
            currentCountryDetails.setCountOfEarthQuakes(1);
        } else {
            currentCountryDetails.setCountOfEarthQuakes(currentCountryDetails.getCountOfEarthQuakes() + 1);
        }
        //populate the map
        result.getCountryNameToCountryDetails().put(countryName, currentCountryDetails);
        return currentCountryDetails;
    }

    static void setHighestNumber(Result result, String countryName, CountryDetails countryDetails) {
        int currnetHighestNumber = result.getGlobalCountHighestNumberOfEarthquakes();
        //in case of equals we use the last country as the highest
        if (currnetHighestNumber < countryDetails.getCountOfEarthQuakes()) {
            result.setGlobalNameHighestNumberOfEarthquakes(countryName);
            result.setGlobalCountHighestNumberOfEarthquakes(countryDetails.getCountOfEarthQuakes());
        }
    }

    static void setHighestMagnitude(Result result, String countryName, Double currentMagnitude, CountryDetails countryDetails) {
        double currnetHighestMagnitude = result.getGlobalCountHighestMagnitude();
        //in case of equals we use the last country as the highest
        if (currnetHighestMagnitude < currentMagnitude) {
            result.setGlobalNameHighestMagnitude(countryName);
            result.setGlobalCountHighestMagnitude(currentMagnitude);
        }
    }

    static int[] prepareArrayForMedian(Result result) {
        int[] numArray = new int[result.getGlobalNumberOfCounties()+1];
        int i=0;
        //go over the map, and build array with the count of the Earthquakes
        Map<String, CountryDetails> map = result.getCountryNameToCountryDetails();
        for (Map.Entry<String, CountryDetails> entry : map.entrySet()) {
            numArray[i++] = entry.getValue().getCountOfEarthQuakes();
        }
        return numArray;
    }

    static double[] calculateInputPoint(JsonParser jsonParserInput) throws IOException {
        double[] point = new double[2];
        JsonNode node2 = jsonParserInput.readValueAsTree();
        JsonNode coordinates = node2.get("coordinates");
        //for X1
        point[0] = coordinates.get(0).asDouble();
        //for Y1
        point[1] = coordinates.get(1).asDouble();

        return point;
    }
}
