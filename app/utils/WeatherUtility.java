package utils;

import play.Logger;
import models.Reading;
import models.Station;

public class WeatherUtility {
    public static double celsiusToFahrenheit(double celsiusInput) {
        double fahrenheit = (9.0/5.0) * celsiusInput + 32;
        return fahrenheit;
    }

    public static String weatherCodeToString(int weatherCode) {
        String weatherCodeToString;
        if (weatherCode == 100) {
            weatherCodeToString = "<span class='icon is-large'><i class='fas fa-2x fa-sun'></i></span><br>Clear";
        } else if (weatherCode == 200) {
            weatherCodeToString = "<span class='icon is-large'><i class='fas fa-2x fa-cloud-sun'></i></span><br>Partial Clouds";
        } else if (weatherCode == 300) {
            weatherCodeToString = "<span class='icon is-large'><i class='fas fa-2x fa-cloud'></i></span><br>Cloudy";
        } else if (weatherCode == 400) {
            weatherCodeToString = "<span class='icon is-large'><i class='fas fa-2x fa-cloud-sun-rain'></i></span><br>Light Showers";
        } else if (weatherCode == 500) {
            weatherCodeToString = "<span class='icon is-large'><i class='fas fa-2x fa-cloud-showers-heavy'></i></span><br>Heavy Showers";
        } else if (weatherCode == 600) {
            weatherCodeToString = "<span class='icon is-large'><i class='fas fa-2x fa-cloud-rain'></i></span><br>Rain";
        } else if (weatherCode == 700) {
            weatherCodeToString = "<span class='icon is-large'><i class='fas fa-2x fa-snowflake'></i></span><br>Snow";
        } else if (weatherCode == 800) {
            weatherCodeToString = "<span class='icon is-large'><i class='fas fa-2x fa-bolt'></i></span><br>Thunder";
        } else {
            weatherCodeToString = "<span class='icon is-large'><i class='fas fa-2x fa-poo-storm'></i></span><br>Unknown";
        }
        return weatherCodeToString;
    }

    public static double feelsLike(double temperature, double windSpeed) {
        double feelsLike = Math.round((13.12 + 0.6215 * temperature - 11.37 * Math.pow(windSpeed, 0.16)
        + 0.3965 * temperature * Math.pow(windSpeed, 0.16)) * 10.0) / 10.0;
        return feelsLike;
    }

    public static String windSpeedToBft(double windSpeed) {
        String windSpeedToBft;
        if (windSpeed <= 1) {
            windSpeedToBft = "0 bft";
        } else if (windSpeed > 1 && windSpeed <= 5) {
            windSpeedToBft = "1 bft";
        } else if (windSpeed > 5 && windSpeed <= 11) {
            windSpeedToBft = "2 bft";
        } else if (windSpeed > 11 && windSpeed <= 19) {
            windSpeedToBft = "3 bft";
        } else if (windSpeed > 19 && windSpeed <= 28) {
            windSpeedToBft = "4 bft";
        } else if (windSpeed > 28 && windSpeed <= 28) {
            windSpeedToBft = "5 bft";
        } else if (windSpeed > 38 && windSpeed <= 49) {
            windSpeedToBft = "6 bft";
        } else if (windSpeed > 49 && windSpeed <= 61) {
            windSpeedToBft = "7 bft";
        } else if (windSpeed > 61 && windSpeed <= 74) {
            windSpeedToBft = "8 bft";
        } else if (windSpeed > 74 && windSpeed <= 88) {
            windSpeedToBft = "9 bft";
        } else if (windSpeed > 88 && windSpeed <= 102) {
            windSpeedToBft = "10 bft";
        } else if (windSpeed > 102 && windSpeed <= 117) {
            windSpeedToBft = "11 bft";
        } else {
            windSpeedToBft = "Unknown";
        }
        return windSpeedToBft;
    }

    public static String windDirectionToText(double windDirection) {
        String windDirectionToText;
        if ((windDirection >= 348.75) && (windDirection <= 360) ||
        (windDirection >= 0) && (windDirection < 11.25)) {
            windDirectionToText = "North";
        } else if ((windDirection >= 11.25) && (windDirection < 33.75)) {
            windDirectionToText = "North North East";
        } else if ((windDirection >= 33.75) && (windDirection < 56.25)) {
            windDirectionToText = "North East";
        } else if ((windDirection >= 56.25) && (windDirection < 78.75)) {
            windDirectionToText = "East North East";
        } else if ((windDirection >= 78.75) && (windDirection < 101.25)) {
            windDirectionToText = "East";
        } else if ((windDirection >= 101.25) && (windDirection < 123.75)) {
            windDirectionToText = "East South East";
        } else if ((windDirection >= 123.75) && (windDirection < 146.25)) {
            windDirectionToText = "South East";
        } else if ((windDirection >= 146.25) && (windDirection < 168.75)) {
            windDirectionToText = "South South East";
        } else if ((windDirection >= 168.75) && (windDirection < 191.25)) {
            windDirectionToText = "South";
        } else if ((windDirection >= 191.25) && (windDirection < 213.75)) {
            windDirectionToText = "South South West";
        } else if ((windDirection >= 213.75) && (windDirection < 236.25)) {
            windDirectionToText = "South West";
        } else if ((windDirection >= 236.25) && (windDirection < 258.75)) {
            windDirectionToText = "West South West";
        } else if ((windDirection >= 258.75) && (windDirection < 281.25)) {
            windDirectionToText = "West";
        } else if ((windDirection >= 281.25) && (windDirection < 303.75)) {
            windDirectionToText = "West North West";
        } else if ((windDirection >= 303.75) && (windDirection < 326.25)) {
            windDirectionToText = "North West";
        } else if ((windDirection >= 326.25) && (windDirection < 348.75)) {
            windDirectionToText = "North North West";
        } else {
            windDirectionToText = "Unknown";
        }
        return windDirectionToText;
    }

    public static void updateWeather(Station station) {
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
      }
}
