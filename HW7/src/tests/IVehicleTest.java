package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import registration.Automobile;
import registration.Boat;
import registration.Motorcycles;

/**
 * Test class for IVehicle.
 */
public class IVehicleTest {
  private Automobile auto;
  private Boat boat;
  private Motorcycles motorcycle;
  
  /**
   * Setting up.
   */
  @Before
  public void setUp() {
    auto = new Automobile("Infiniti", 2013, 10000.00);
    boat = new Boat("Yamaha", 2015, 20000.00);
    motorcycle = new Motorcycles("Honda", 2015, 20000.00);
  }
  
  /**
   * Test creation.
   */
  @Test
  public void testAutoCreate() {
    assertEquals("Infiniti", auto.getMake());
    assertEquals(2013, auto.getProductionYear());
    assertEquals(10000.00, auto.getPrice(), 0.01);
    assertEquals(5, auto.getMaxPassengers());
  }
  
  /**
   * Test creation.
   */
  @Test
  public void testBoatCreate() {
    assertEquals("Yamaha", boat.getMake());
    assertEquals(2015, boat.getProductionYear());
    assertEquals(20000.00, boat.getPrice(), 0.01);
    assertEquals(10, boat.getMaxPassengers());
  }
  
  /**
   * Test creation.
   */
  @Test
  public void testMotorcycleCreate() {
    assertEquals("Honda", motorcycle.getMake());
    assertEquals(2015, motorcycle.getProductionYear());
    assertEquals(20000.00, motorcycle.getPrice(), 0.01);
    assertEquals(2, motorcycle.getMaxPassengers());
  }
  
  /**
   * Test getter methods.
   */
  @Test
  public void testGetterMethods() {
    assertEquals("Infiniti", auto.getMake());
    assertEquals(2013, auto.getProductionYear());
    assertEquals(10000.00, auto.getPrice(), 0.01);
    assertEquals(5, auto.getMaxPassengers());
    assertEquals("Yamaha", boat.getMake());
    assertEquals(2015, boat.getProductionYear());
    assertEquals(20000.00, boat.getPrice(), 0.01);
    assertEquals(10, boat.getMaxPassengers());
    assertEquals("Honda", motorcycle.getMake());
    assertEquals(2015, motorcycle.getProductionYear());
    assertEquals(20000.00, motorcycle.getPrice(), 0.01);
    assertEquals(2, motorcycle.getMaxPassengers());
  }
}
