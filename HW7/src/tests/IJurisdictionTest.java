package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import registration.Automobile;
import registration.BlueJurisdiction;
import registration.Boat;
import registration.GreenJurisdiction;
import registration.IVehicle;
import registration.RedJurisdiction;

/**
 * Test class for IJurisdiction.
 */
public class IJurisdictionTest {
  private IVehicle auto;
  private IVehicle auto2;
  private IVehicle auto3;
  private IVehicle boat1;
  
  /**
   * Setting up.
   */
  @Before
  public void setUp() {
    auto = new Automobile("Infiniti", 2013, 10000.00);
    auto2 = new Automobile("Honda", 2013, 10000.00);
    auto3 = new Automobile("Bently", 2013, 10000.00);
    boat1 = new Boat("Yamaha", 2015, 20000.00);
  }
  
  /**
   * Test Blue Jurisdiction.
   */
  @Test
  public void testBlueJurisdiction() {
    BlueJurisdiction blue = new BlueJurisdiction();
    double tax = blue.exciseTax(auto);
    assertEquals(300.00, tax, 0.01);
  }
  
  /**
   * Test Blue Jurisdiction. Edge case.
   */
  @Test
  public void testBlueJurisdictionEdge() {
    BlueJurisdiction blue = new BlueJurisdiction();
    IVehicle autoEdge = new Automobile("Honda", 1998, 10000.00);
    double tax = blue.exciseTax(autoEdge);
    assertEquals(399.00, tax, 0.01);
  }
  
  /**
   * Test Red Jurisdiction.
   */
  @Test
  public void testRedJurisdiction() {
    RedJurisdiction red = new RedJurisdiction();
    double tax = red.exciseTax(auto2);
    assertEquals(500.0, tax, 0.01);
  }
  
  /**
   * Test Green Jurisdiction.
   */
  @Test
  public void testGreenJurisdiction() {
    GreenJurisdiction green = new GreenJurisdiction();
    double tax = green.exciseTax(auto3);
    assertEquals(900.0, tax, 0.01);
    double tax2 = green.exciseTax(boat1);
    assertEquals(1800.0, tax2, 0.01);
  }
  
  /**
   * Test toString.
   */
  @Test
  public void testToString() {
    BlueJurisdiction blue = new BlueJurisdiction();
    assertEquals("Blue Jurisdiction", blue.toString());
    RedJurisdiction red = new RedJurisdiction();
    assertEquals("Red Jurisdiction", red.toString());
    GreenJurisdiction green = new GreenJurisdiction();
    assertEquals("Green Jurisdiction", green.toString());
  }
}
