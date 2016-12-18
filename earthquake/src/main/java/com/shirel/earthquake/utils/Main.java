package com.shirel.earthquake.utils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.shirel.earthquake.CountryDetails;
import com.shirel.earthquake.Output;
import com.shirel.earthquake.Result;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import static com.shirel.earthquake.utils.GeneralUtils.setClosest;

/**
 * Created by shirel on 12/17/2016.
 */
public class Main {
    public static final String DATA_FILE = "data.json";
    public static final String INPUT_FILE = "input.json";
    public static final String OUTPUT_FILE = "output.json";
    static double[] point;
    static double x1;
    static double y1;

    public static void main(String[] args) throws IOException {
        JsonParser jsonParserData = getJsonParser(DATA_FILE);
        JsonParser jsonParserInput = getJsonParser(INPUT_FILE);

        point = GeneralUtils.calculateInputPoint(jsonParserInput);
        x1 = point[0];
        y1 = point[1];

        Result result = parseData(jsonParserData, jsonParserInput);
        Output output = createOutput(result);
        writeResult(output);
    }


    private static Output createOutput(Result result) {
        Output output = new Output();

        //The country with highest magnitude earthquake
        output.setHighNumCntr(result.getGlobalNameHighestNumberOfEarthquakes());
        output.setHighNumCntrNumber(result.getGlobalCountHighestNumberOfEarthquakes());

        //The country with highest magnitude earthquake
        output.setHighMagCntr(result.getGlobalNameHighestMagnitude());
        output.setHighMagCntrNumber(result.getGlobalCountHighestMagnitude());

        /**
         * The average number of earthquakes occurred in a country
         */
        output.setAvgEarthquakes(CalculateFunctions.calculateAverage(result.getGlobalNumberOfEarthquakes(), result.getGlobalNumberOfCounties()));

        /**
         * The median number of earthquakes occurred in a country
         */
        output.setMedEarthquakes(CalculateFunctions.calculateMedian(GeneralUtils.prepareArrayForMedian(result)));

        /**
         *  The closest earthquake between specific point
         */
        output.setClosestTitle(result.getGlobalTiltleClosest());
        output.setClosestUrl(result.getGlobalUrlClosest());

        return output;
    }

    private static Result parseData(JsonParser jsonParserData, JsonParser jsonParserInput) throws IOException {
        Result result = new Result();



        JsonToken current;
        current = jsonParserData.nextToken();
        if (current != JsonToken.START_OBJECT) {
            throw new RuntimeException("Error: root should be object: quiting.");
        }

        while (jsonParserData.nextToken() != JsonToken.END_OBJECT) {
            String fieldName = jsonParserData.getCurrentName();
            current = jsonParserData.nextToken();
            if (fieldName.equals("features")) {
                if (current == JsonToken.START_ARRAY) {
                    while (jsonParserData.nextToken() != JsonToken.END_ARRAY) {
                        JsonNode node = jsonParserData.readValueAsTree();
                        JsonNode properties = node.get("properties");
                        JsonNode geometry = node.get("geometry");
                        if (Objects.equals(properties.get("type").asText(), "earthquake")) {
                            processPropertiesNode(properties, geometry, result);
                        }
                    }
                } else {
                    jsonParserData.skipChildren();
                }
            } else {
                jsonParserData.skipChildren();
            }
        }
        return result;
    }

    private static JsonParser getJsonParser(String data_file) throws IOException {
        JsonFactory jsonFactory = new MappingJsonFactory();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = loader.getResourceAsStream(data_file); // TODO close stream

        return jsonFactory.createParser(inputStream);
    }

    private static void processPropertiesNode(JsonNode properties, JsonNode geometry, Result result) {
        String countryName = GeneralUtils.getCountryName(properties.get("place").asText());
        Double currentMagnitude = properties.get("mag").asDouble();
        System.out.println(countryName);
        CountryDetails currentCountryDetails = result.getCountryNameToCountryDetails().get(countryName);

        //Update details of specific country
        CountryDetails countryDetails = GeneralUtils.updateCountriesMap(currentCountryDetails, countryName, result);


        //Update details of global countries
        //Average
        GeneralUtils.prepareForCalculateAvg(result, currentCountryDetails);

        //Highest Number
        GeneralUtils.setHighestNumber(result, countryName, countryDetails);

        //Highest Magnitude
        GeneralUtils.setHighestMagnitude(result, countryName, currentMagnitude, countryDetails);

        //Closest
        setClosest(result, properties, geometry, x1, y1);


    }


    /**
     * Saves output to file
     *
     * @param output
     * @throws IOException
     */
    private static void writeResult(Output output) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.writeValue(new File(OUTPUT_FILE), output);
    }
}
