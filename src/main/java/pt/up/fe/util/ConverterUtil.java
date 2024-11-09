package pt.up.fe.util;

public class ConverterUtil {

  // Converts fahrenheit to celsius
  public static double convertFahrenheitToCelsius(double fahrenheit) {
    return ((fahrenheit - 32.0) * 5.0 / 9.0);
  }

  // Converts celsius to fahrenheit
  public static double convertCelsiusToFahrenheit(double celsius) {
    return ((celsius * 9.0) / 5.0) + 32.0;
  }
}
