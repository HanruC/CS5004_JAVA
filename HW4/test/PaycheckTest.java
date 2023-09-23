import static org.junit.Assert.assertEquals;

import employee.HourlyPaycheck;
import employee.Paycheck;
import org.junit.Test;

/**
 * Test pay check abstract class with various data.
 */
public class PaycheckTest {
  
  /**
   * Test normal data.
   */
  @Test
  public void testPaycheck() {
    Paycheck paycheck = new HourlyPaycheck(40, 40);
    assertEquals(1600, paycheck.getTotalPay(), 0.01);
    assertEquals(1360, paycheck.getPayAfterTaxes(), 0.01);
  }
  
  /**
   * Test lower data.
   */
  @Test
  public void testPaycheckUnder() {
    Paycheck paycheck = new HourlyPaycheck(4, 10);
    assertEquals(40, paycheck.getTotalPay(), 0.01);
    assertEquals(36, paycheck.getPayAfterTaxes(), 0.01);
  }
  
  /**
   * Test higher data.
   */
  @Test
  public void testPaycheckHigh() {
    Paycheck paycheck = new HourlyPaycheck(400, 10);
    assertEquals(4000, paycheck.getTotalPay(), 0.01);
    assertEquals(3400, paycheck.getPayAfterTaxes(), 0.01);
  }
}
