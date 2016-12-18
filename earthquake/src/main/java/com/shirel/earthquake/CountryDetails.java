package com.shirel.earthquake;

/**
 * Created by shirel on 12/17/2016.
 */
public class CountryDetails {

    private int countOfEarthQuakes;


    public int getCountOfEarthQuakes() {
        return countOfEarthQuakes;
    }

    public void setCountOfEarthQuakes(int countOfEarthQuakes) {
        this.countOfEarthQuakes = countOfEarthQuakes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountryDetails that = (CountryDetails) o;

        return countOfEarthQuakes == that.countOfEarthQuakes;

    }

    @Override
    public int hashCode() {
        return countOfEarthQuakes;
    }

    @Override
    public String toString() {
        return "CountryDetails{" +
                "countOfEarthQuakes=" + countOfEarthQuakes +
                '}';
    }
}
