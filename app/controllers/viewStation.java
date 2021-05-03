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
        if (station.readings.size() > 0) {
            Reading lastReading = station.readings.get(station.readings.size() - 1);
            station.temperatureInFahrenheit = WeatherUtility.celsiusToFahrenheit(lastReading.temperature);
            station.weatherCodeToString = WeatherUtility.weatherCodeToString(lastReading.code);
            station.feelsLike = WeatherUtility.feelsLike(lastReading.temperature, lastReading.windSpeed);
            station.windSpeedToBft = WeatherUtility.windSpeedToBft(lastReading.windSpeed);
            station.windDirectionToText = WeatherUtility.windDirectionToText(lastReading.windDirection);
            
            double minWindSpeed = 999999999999.0;
            double maxWindSpeed = 0.0;
            for (Reading reading : station.readings) {
                if (reading.windSpeed < minWindSpeed) {
                    minWindSpeed = reading.windSpeed;
                }
                if (reading.windSpeed > maxWindSpeed) {
                    maxWindSpeed = reading.windSpeed;
                }
            }
            station.minWindSpeed = minWindSpeed;
            station.maxWindSpeed = maxWindSpeed;

            int minPressure = 2147483647;
            int maxPressure = 0;
            for (Reading reading : station.readings) {
                if (reading.pressure < minPressure) {
                    minPressure = reading.pressure;
                }
                if (reading.pressure > maxPressure) {
                    maxPressure = reading.pressure;
                }
            }
            station.minPressure = minPressure;
            station.maxPressure = maxPressure;
        }
        Logger.info("min wind speed = " + station.minWindSpeed + ", max wind speed = " + station.maxWindSpeed);
        Logger.info("min pressure = " + station.minPressure + ", max pressure = " + station.maxPressure);
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