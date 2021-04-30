package controllers;

import play.Logger;import play.mvc.Controller;

import models.Station;
import models.Reading;
import utils.WeatherUtility;
import play.Logger;
import play.mvc.Controller;

public class viewStation extends Controller {
    public static void index(long id) {
        Station station = Station.findById(id);
        Reading lastReading = station.readings.get(station.readings.size() - 1);
        station.temperatureInFahrenheit = WeatherUtility.celsiusToFahrenheit(lastReading.temperature);
        station.weatherCodeToString = WeatherUtility.weatherCodeToString(lastReading.code);
        station.feelsLike = WeatherUtility.feelsLike(lastReading.temperature, lastReading.windSpeed);
        station.windSpeedToBft = WeatherUtility.windSpeedToBft(lastReading.windSpeed);
        station.windDirectionToText = WeatherUtility.windDirectionToText(lastReading.windDirection);
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