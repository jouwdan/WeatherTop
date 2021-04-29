package utils;

import play.Logger;

public class WeatherUtility {
    public static double celsiusToFahrenheit(double celsiusInput) {
        Logger.info("celsiusInput = " + celsiusInput);
        double fahrenheit = (9.0/5.0) * celsiusInput + 32;
        return fahrenheit;
    }
}
