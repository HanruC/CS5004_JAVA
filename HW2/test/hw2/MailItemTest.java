package hw2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * This is a test class for Mail item.
 */

public class MailItemTest {
  private MailItem mail1;
  private MailItem mail2;
  
  /**
   * Set up the examples.
   */
  @Before
  public void setUp() {
    mail1 = new MailItem(10,20, 40, new Recipient("Luke",
            "Chen", "hchen1@fandm.edu"));
    mail2 = new MailItem(20,30,90, new Recipient("Vicky",
            "Wang", "ywang652@ucsc.edu"));
  }
  
  /**
   * Test to see if getter method will get width.
   */
  @Test
  public void getWidth() {
    assertEquals(10, mail1.getWidth());
    assertEquals(20, mail2.getWidth());
    try {
      new MailItem(0,10,20,
              new Recipient("k", "w", "cc@qq.com"));
    } catch (IllegalArgumentException e) {
      assertEquals("Should be larger than 1.", e.getMessage());
    }
  }
  
  /**
   * Test to see if the getter height method will get height.
   */
  @Test
  public void getHeight() {
    assertEquals(20, mail1.getHeight());
    assertEquals(30, mail2.getHeight());
    try {
      new MailItem(10,0,20,
              new Recipient("k", "w", "cc@qq.com"));
    } catch (IllegalArgumentException e) {
      assertEquals("Should be larger than 1.", e.getMessage());
    }
  }
  
  /**
   * Test to see if the getter method will get depth.
   */
  @Test
  public void getDepth() {
    assertEquals(40, mail1.getDepth());
    assertEquals(90, mail2.getDepth());
    try {
      new MailItem(10,20,0,
              new Recipient("k", "w", "cc@qq.com"));
    } catch (IllegalArgumentException e) {
      assertEquals("Should be larger than 1.", e.getMessage());
    }
  }
  
  /**
   * Test to see that it is correctly getting recipient name.
   */
  @Test
  public void getRecipient() {
    Recipient recipientTest = new Recipient("Jackie",
            "Chen", "Jchen@neu.edu");
    MailItem mail3 = new MailItem(2,1,2, recipientTest);
    assertEquals(recipientTest, mail3.getRecipient());
  }
}