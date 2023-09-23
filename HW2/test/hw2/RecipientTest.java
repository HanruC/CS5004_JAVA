package hw2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * This is a test class to test recipient name and email.
 */
public class RecipientTest {
  private Recipient person1;
  private Recipient person2;
  
  /**
   * set up twp examples.
   */
  @Before
  public void setUp() {
    person1 = new Recipient("Luke", "Chen", "hchen1@fandm.edu");
    person2 = new Recipient("Vicky", "Wang", "ywang652@ucsc.edu");
  }
  
  /**
   * Test getter method in order to check if the constructor goes well.
   */
  @Test
  public void testRecipientConstructor() {
    assertEquals("Luke", person1.getFirstName());
    assertEquals("Chen", person1.getLastName());
    assertEquals("hchen1@fandm.edu", person1.getEmail());
  }
  
  /**
   * Test toString method.
   */
  @Test
  public void testToString() {
    assertEquals("Vicky Wang Email:ywang652@ucsc.edu", person2.toString());
  
  }
}