package utils;

import play.Logger;

public class WeatherUtility {
    public static double celsiusToFahrenheit(double celsiusInput) {
        double fahrenheit = (9.0/5.0) * celsiusInput + 32;
        return fahrenheit;
    }

    public static String weatherCodeToString(int weatherCode) {
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
}
