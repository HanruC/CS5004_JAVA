package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import registration.Automobile;
import registration.BlueJurisdiction;
import registration.Boat;
import registration.GreenJurisdiction;
import registration.IJurisdiction;
import registration.IRegistration;
import registration.IVehicle;
import registration.Motorcycles;
import registration.Person;
import registration.RegistrationSystem;

/**
 * Test class for RegistrationSystem.
 */
public class RegistrationSystemTest {
  private RegistrationSystem registrationSystem;
  private Person owner;
  private IJurisdiction blue;
  private IJurisdiction green;
  
  
  /**
   * Set up the test.
   */
  @Before
  public void setUp() {
    registrationSystem = RegistrationSystem.getInstance();
    owner = new Person("Luke", "Baltimore");
    blue = new BlueJurisdiction();
    green = new GreenJurisdiction();
  }
  
  /**
   * Reboot the system after each test.
   */
  @After
  public void Reboot() {
    registrationSystem.reboot();
  }
  
  /**
   * Test createVehicle() method.
   */
  @Test
  public void testCreateVehicle() {
    IVehicle auto = registrationSystem
            .createVehicle("Auto", "Honda", 2010, 10000.00);
    assertTrue(auto instanceof Automobile);
    assertEquals("Honda", auto.getMake());
    assertEquals(2010, auto.getProductionYear());
    assertEquals(10000.00, auto.getPrice(), 0.01);
    
    IVehicle boat = registrationSystem
            .createVehicle("Boat", "CC", 2005, 20000.00);
    assertTrue(boat instanceof Boat);
    assertEquals("CC", boat.getMake());
    assertEquals(2005, boat.getProductionYear());
    assertEquals(20000.00, boat.getPrice(), 0.01);
    
    IVehicle motorcycle = registrationSystem
            .createVehicle("Motorcycle", "QQ", 2015, 15000.00);
    assertTrue(motorcycle instanceof Motorcycles);
    assertEquals("QQ", motorcycle.getMake());
    assertEquals(2015, motorcycle.getProductionYear());
    assertEquals(15000.00, motorcycle.getPrice(), 0.01);
  }
  
  /**
   * Edge cases. Test createVehicle() method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCreateVehicleEdgeCases() {
    registrationSystem
            .createVehicle("Auto", "", 2010, 10000.00);
    registrationSystem
            .createVehicle("Auto", "Honda", 1800, 10000.00);
    registrationSystem
            .createVehicle("Auto", "Honda", 2010, -1.00);
  }
  
  /**
   * Test register() method.
   */
  @Test
  public void testRegister() {
    IVehicle auto = registrationSystem
            .createVehicle("Auto", "Honda", 2010, 10000.00);
    IVehicle boat = registrationSystem
            .createVehicle("Boat", "Yamaha", 2005, 20000.00);
    registrationSystem.register(auto, blue, 2020,
            Collections.unmodifiableList(Arrays.asList(owner)));
    registrationSystem.register(boat, green, 2020,
            Collections.unmodifiableList(Arrays.asList(owner)));
    registrationSystem.register(auto, blue, 2020,
            Collections.unmodifiableList(Arrays.asList(owner)));
    // Duplicate registration
    
    List<IRegistration> registrations = registrationSystem.getAllRegistrations();
    assertEquals(2, registrations.size());
    
    assertEquals(auto.getProductionYear(), registrations.get(0).getProductionYear());
    assertEquals(auto.getMaxPassengers(), registrations.get(0).getMaxPassengers());
    assertEquals(boat.getProductionYear(), registrations.get(1).getProductionYear());
    assertEquals(boat.getMaxPassengers(), registrations.get(1).getMaxPassengers());
  }
  
  /**
   * Test filteredList() method.
   */
  @Test
  public void testFilteredList() {
    IVehicle auto = registrationSystem
            .createVehicle("Auto", "Honda", 2010, 10000.00);
    IVehicle boat = registrationSystem
            .createVehicle("Boat", "Yamaha", 2005, 20000.00);
    registrationSystem.register(auto, blue,
            2020, Collections.unmodifiableList(Arrays.asList(owner)));
    registrationSystem.register(boat, green,
            2020, Collections.unmodifiableList(Arrays.asList(owner)));
  
    List<IRegistration> filteredList = registrationSystem
            .getFilteredList(reg -> reg.toString().contains("AUTO"));
    assertEquals(1, filteredList.size());
    assertEquals(auto.getProductionYear(), filteredList.get(0).getProductionYear());
    assertEquals(auto.getMaxPassengers(), filteredList.get(0).getMaxPassengers());
  
    filteredList = registrationSystem.getFilteredList(reg -> reg.getJurisdiction().equals(green));
    assertEquals(1, filteredList.size());
    assertEquals(boat.getProductionYear(), filteredList.get(0).getProductionYear());
    assertEquals(boat.getMaxPassengers(), filteredList.get(0).getMaxPassengers());
  }
  
}
