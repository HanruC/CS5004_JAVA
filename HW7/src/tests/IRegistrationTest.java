package tests;

import static org.junit.Assert.assertEquals;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import registration.Automobile;
import registration.BlueJurisdiction;
import registration.GreenJurisdiction;
import registration.IJurisdiction;
import registration.IRegistration;
import registration.Person;
import registration.RedJurisdiction;
import registration.Registration;




/**
 * The IRegistrationTest class tests the IRegistration interface.
 */
public class IRegistrationTest {
  private IRegistration registration1;
  private IRegistration registration2;
  private IRegistration registration3;
  private Person owner;
  
  /**
   * Set up the test.
   */
  @Before
  public void setUp() {
    owner = new Person("Luke", "Baltimore");
    IJurisdiction jurisdiction1 = new BlueJurisdiction();
    IJurisdiction jurisdiction2 = new GreenJurisdiction();
    IJurisdiction jurisdiction3 = new RedJurisdiction();
    Automobile auto = new Automobile("Infiniti", 2013, 10000.00);
    Automobile auto2 = new Automobile("Honda", 2013, 10000.00);
    Automobile auto3 = new Automobile("Bently", 2013, 10000.00);
    registration1 = new Registration(2019, auto, jurisdiction1,
                                    Collections.singletonList(owner));
    registration2 = new Registration(2019, auto2, jurisdiction2,
            Collections.singletonList(owner));
    registration3 = new Registration(2019, auto3, jurisdiction3,
            Collections.singletonList(owner));
  }
  
  /**
   * Test the getters.
   */
  @Test
  public void testGetters() {
    assertEquals(2019, registration1.getRegistrationYear());
    assertEquals(2013, registration1.getProductionYear());
    assertEquals(new BlueJurisdiction().toString(), registration1.getJurisdiction().toString());
    assertEquals(Collections.singletonList(owner), registration1.getOwners());
    assertEquals(5, registration1.getMaxPassengers());
  }
  
  /**
   * Test the calculateExciseTax method.
   */
  @Test
  public void testCalculateExciseTax() {
    assertEquals(300.00, registration1.calculateExciseTax(), 0.01);
    assertEquals(900.00, registration2.calculateExciseTax(), 0.01);
    assertEquals(500.00, registration3.calculateExciseTax(), 0.01);
  }
  
  /**
   * Test the toString method.
   */
  @Test
  public void testToString() {
    String expectedString1 = "Registration:\nAUTOMOBILE: Infiniti Year(2013)  Price = $10000.00\n"
            + "Owned By: Luke, Baltimore\nYear: 2019\nExcise Tax: $300.00";
    String expectedString2 = "Registration:\nAUTOMOBILE: Honda Year(2013)  Price = $10000.00\n"
            + "Owned By: Luke, Baltimore\nYear: 2019\nExcise Tax: $900.00";
    String expectedString3 = "Registration:\nAUTOMOBILE: Bently Year(2013)  Price = $10000.00\n"
            + "Owned By: Luke, Baltimore\nYear: 2019\nExcise Tax: $500.00";
    
    assertEquals(expectedString1, registration1.toString());
    assertEquals(expectedString2, registration2.toString());
    assertEquals(expectedString3, registration3.toString());
  }
}
