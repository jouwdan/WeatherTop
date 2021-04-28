package controllers;

import play.Logger;import play.mvc.Controller;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

public class viewStation extends Controller {
    public static void index(long id) {
        Station station = Station.findById(id);
        Logger.info("Station id = " + id);
        render ("station.html", station);
    }

    public static void addReading(Long id, int code, double temperature, double windSpeed, double windDirection, int pressure) {
        Reading reading = new Reading(code, temperature, windSpeed, windDirection, pressure);
        Station station = Station.findById(id);
        station.readings.add(reading);
        station.save();
        redirect("/station/" + id);
    }
}