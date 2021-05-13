package controllers;

import play.Logger;
import play.mvc.Controller;

import models.Station;
import models.Reading;
import models.Member;
import utils.WeatherUtility;
import play.Logger;
import play.mvc.Controller;

import java.util.Date;

public class viewStation extends Controller {
  public static void index(long id) {
    Station station = Station.findById(id);
    WeatherUtility.updateWeather(station);
    Logger.info("min wind speed = " + station.minWindSpeed + ", max wind speed = " + station.maxWindSpeed);
    Logger.info("min pressure = " + station.minPressure + ", max pressure = " + station.maxPressure);
    Logger.info("Station id = " + id);
    render("station.html", station);
  }

  public static void addReading(Long id, int code, double temperature, double windSpeed, double windDirection, int pressure) {
    Date date = new Date();
    Reading reading = new Reading(date, code, temperature, windSpeed, windDirection, pressure);
    Station station = Station.findById(id);
    station.readings.add(reading);
    station.save();
    redirect("/station/" + id);
  }
}