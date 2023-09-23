package hw2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * This is the test class for locker class.
 */
public class LockerTest {
  
  /**
   * This is a test to test if the constructor pass in the constraints.
   */
  @Test
  public void testConstructorConstraints() {
    try {
      new Locker(0,6,7);
    } catch (IllegalArgumentException e) {
      assertEquals("max value should be larger or equal to 1.", e.getMessage());
    }
    
    try {
      new Locker(3,0,7);
    } catch (IllegalArgumentException e) {
      assertEquals("max value should be larger or equal to 1.", e.getMessage());
    }
  
    try {
      new Locker(3,7,0);
    } catch (IllegalArgumentException e) {
      assertEquals("max value should be larger or equal to 1.", e.getMessage());
    }
  }
  
  /**
   * This is a test for testing if adding mail successfully.
   * Retrieve value of mail by passing in pickupMail method since it returns mail at the end.
   */
  @Test
  public void testAddMail() {
    Locker lockerTest = new Locker(7,8,7);
    MailItem mailTest = new MailItem(3,2,1,
            new Recipient("Tom", "Brown", "tb@qq.com"));
    lockerTest.addMail(mailTest);
    assertEquals(false, lockerTest.isAvailability());
  }
  
  /**
   * This is a test for pickupMail.
   * Test both valid and invalid cases.
   */
  @Test
  public void pickupMail() {
    Recipient recipientTest = new Recipient("Chris",
            "Paul", "cp3@nba.edu");
    Locker lockerTest = new Locker(9,9,9);
    MailItem mailTest = new MailItem(7,7,7, recipientTest);
    lockerTest.addMail(mailTest);
    lockerTest.pickupMail(recipientTest);
    assertNull(lockerTest.pickupMail(recipientTest));
    assertEquals(false, lockerTest.isAvailability());
    Locker lockerTest2 = new Locker(10,10,10);
    Recipient recipientTest2 = new Recipient("Chris",
            "Bieber", "cp3@nba.edu");
    lockerTest2.addMail(mailTest);
    MailItem mailPickWrong = lockerTest2.pickupMail(recipientTest2);
    assertNull(mailPickWrong);
  }
}