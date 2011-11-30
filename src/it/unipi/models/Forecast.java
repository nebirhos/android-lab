package it.unipi.models;

import java.util.*;

/**
 * Store forecasts data
 */
public class Forecast {
    private Date datetime;
    private String description;

    public Forecast( long timestamp, String description ) {
        this.datetime = new Date( timestamp );
        this.description = description;
    }

    public String getTime() {
        return datetime.toString();
    }

    public String getDescription() {
        return description;
    }
}
