package utils;

import play.Logger;

public class WeatherUtility {
    public static double celsiusToFahrenheit(double celsiusInput) {
        Logger.info("celsiusInput = " + celsiusInput);
        double fahrenheit = (9.0/5.0) * celsiusInput + 32;
        return fahrenheit;
    }

    public static String weatherCodeToString(int weatherCode) {
        Logger.info("weatherCode = " + weatherCode);
        String weatherCodeToString;
        if (weatherCode == 100) {
            weatherCodeToString = "Clear";
        } else if (weatherCode == 200) {
            weatherCodeToString = "Partial Clouds";
        } else if (weatherCode == 300) {
            weatherCodeToString = "Cloudy";
        } else if (weatherCode == 400) {
            weatherCodeToString = "Light Showers";
        } else if (weatherCode == 500) {
            weatherCodeToString = "Heavy Showers";
        } else if (weatherCode == 600) {
            weatherCodeToString = "Rain";
        } else if (weatherCode == 700) {
            weatherCodeToString = "Snow";
        } else if (weatherCode == 800) {
            weatherCodeToString = "Thunder";
        } else {
            weatherCodeToString = "Unknown";
        }
        return weatherCodeToString;
    }
}
