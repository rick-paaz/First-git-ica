package tests;

/**
 * A unit test for two static methods that convert Celcius and Fahrenheit 
 * temperatures. Note: all returns are rounded to one decimal place.
 * 
 * @author Rick Mercer
 */

import static org.junit.Assert.*;
import model.TemperatureConverter;

import org.junit.Test;
 
public class TemperatureConverterTests {

  @Test
  public void testF2C() {
    assertEquals(100.0, TemperatureConverter.FtoC(212.0), 0.1);
    assertEquals(0.0, TemperatureConverter.FtoC(32.0), 0.1);
    assertEquals(37.0, TemperatureConverter.FtoC(98.6), 0.1);
  }

  @Test
  public void testF2CWhenNegativeOr0() {
    assertEquals(-8.89, TemperatureConverter.FtoC(16.0), 0.1);
    assertEquals(-40.0, TemperatureConverter.FtoC(-40.0), 0.1);
    assertEquals(-17.8, TemperatureConverter.FtoC(0.0), 0.1);
  }

  @Test
  public void testC2F() {
    assertEquals(212.0, TemperatureConverter.CtoF(100.0), 0.1);
    assertEquals(98.6, TemperatureConverter.CtoF(37.0), 0.1);
    assertEquals(32.0, TemperatureConverter.CtoF(0.0), 0.1);
  }

  @Test
  public void testC2FWhenNegativeOr0() {
    assertEquals(-40.0, TemperatureConverter.CtoF(-40.0), 0.1);
    assertEquals(30.2, TemperatureConverter.CtoF(-1.0), 0.1);
    assertEquals(32.0, TemperatureConverter.CtoF(0.0), 0.1);
  }

}