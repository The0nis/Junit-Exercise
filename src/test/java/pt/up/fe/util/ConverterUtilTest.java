package pt.up.fe.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.CsvSource;

public class ConverterUtilTest {

  static double[][] data() {
    return new double[][] { {0.0, -17.8}, {5.0, -15.0}, {-10.0, -23.3} };
  }

  @ParameterizedTest
  @MethodSource(value =  "data")
  public void testConvertFahrenheitToCelsius(double[] data) {
    double input = data[0];
    double expected = data[1];
    double result = ConverterUtil.convertFahrenheitToCelsius(input);
    assertEquals(expected, result, 0.1);
  }

  @ParameterizedTest
  @CsvSource({"0.0,32.0", "5.0,41.0", "-10.1,13.82"})
  public void testConvertCelsiusToFahrenheit(double input, double expected) {
    double result = ConverterUtil.convertCelsiusToFahrenheit(input);
    assertEquals(expected, result, 0.1);
  }
}
