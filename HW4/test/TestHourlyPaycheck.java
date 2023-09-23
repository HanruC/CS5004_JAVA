import static org.junit.Assert.assertEquals;

import employee.HourlyPaycheck;
import org.junit.Test;

/**
 * Test for hourly class.
 */
public class TestHourlyPaycheck {
  
  /**
   * Test constructor.
   */
  @Test
  public void TestHourlyPaycheckConstructor() {
    HourlyPaycheck paycheck = new HourlyPaycheck(10,20);
    assertEquals(10, paycheck.getPayRate(), 0.01);
    assertEquals(20, paycheck.getHoursWorked(), 0.01);
  }
  
  /**
   * Test negative constraints.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testNegative() {
    new HourlyPaycheck(-10, 30);
  }
  
  /**
   * Test negative constraint.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testNegative2() {
    new HourlyPaycheck(10,-30);
  }
  
  /**
   * Test total pay, add method, and reset method.
   */
  @Test
  public void testGetTotalPay() {
    HourlyPaycheck paycheck = new HourlyPaycheck(30, 40);
    assertEquals(1200, paycheck.getTotalPay(), 0.01);
    
    paycheck.addHoursWorked(10); //hours 50, total = (30 * 40) + (10 * 30 * 1.5)
    assertEquals(1650, paycheck.getTotalPay(), 0.01);
    
    paycheck.resetHoursWorked();
    assertEquals(0,paycheck.getTotalPay(), 0.01);
  }
}
