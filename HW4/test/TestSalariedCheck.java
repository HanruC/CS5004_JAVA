import static org.junit.Assert.assertEquals;

import employee.SalariedPaycheck;
import org.junit.Test;

/**
 * Test class for SalariedPaycheck.
 */
public class TestSalariedCheck {
  
  /**
   * Test constructor for salaried class.
   */
  @Test
  public void testConstructor() {
    SalariedPaycheck paycheck = new SalariedPaycheck(12000, 4);
    assertEquals(12000, paycheck.getPayRate(), 0.01);
    assertEquals(4, paycheck.getPayInterval(), 0.01);
  }
  
  /**
   * Test illegal for interval.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testIllegalInterval() {
    new SalariedPaycheck(12000, 3);
    new SalariedPaycheck(12000, 5);
  }
  
  /**
   * Test illegal for pay rate.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testIllegalPayRate() {
    new SalariedPaycheck(-5, 4);
  }
  
  /**
   * Test total pay.
   */
  @Test
  public void testTotalPay() {
    SalariedPaycheck paycheck = new SalariedPaycheck(12000, 1);
    assertEquals(230.76, paycheck.getTotalPay(), 0.01);
    
    SalariedPaycheck paycheck2 = new SalariedPaycheck(52000, 4);
    assertEquals(4000, paycheck2.getTotalPay(), 0.01);
  }
}
