import static org.junit.Assert.assertEquals;

import employee.Employee;
import employee.HourlyPaycheck;
import employee.IPaycheck;
import employee.SalariedPaycheck;
import org.junit.Test;

/**
 * Test for employee class.
 */
public class TestEmployee {
  
  /**
   *  Test for constructors.
   */
  @Test
  public void testSalariedConstructor() {
    Employee Salaried = new Employee("Luke", "AE86",
            90000, 4, false);
    assertEquals("Luke", Salaried.getName());
    assertEquals("AE86", Salaried.getId());
    assertEquals(90000, Salaried.getPayRate(), 0.01);
    assertEquals(4, Salaried.getPayInterval(), 0.01);
    assertEquals(false, Salaried.isManager());
  }
  
  /**
   * Test invalid case.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testInvalid() {
    new Employee("Luke", "AE86",
            90000, 5, false);
  }
  
  /**
   * Test invalid case.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testInvalidPayRate() {
    new Employee("Kobe", "24",
            -100, 4, true);
  }
  
  /**
   * Test for Hourly constructor.
   */
  @Test
  public void testHourlyConstructor() {
    Employee Hourly = new Employee("Luke", "AE85", 90, 40);
    assertEquals("Luke", Hourly.getName());
    assertEquals("AE85", Hourly.getId());
    assertEquals(90, Hourly.getPayRate(), 0.01);
    assertEquals(40, Hourly.getHoursWorked(), 0.01);
    assertEquals(false, Hourly.isManager());
  }
  
  /**
   * Test can get pay check - salaried worker.
   */
  @Test
  public void TestGetPaycheck() {
    Employee salaried = new Employee("Luke", "AE86",
            90000, 4, false);
    IPaycheck paycheck = salaried.getPaycheck();
    assertEquals(true, paycheck instanceof SalariedPaycheck);
    assertEquals(90000, paycheck.getPayRate(), 0.01);
  }
  
  /**
   * Test can get pay check - hourly.
   */
  @Test
  public void TestGetPaycheck2() {
    Employee hourly = new Employee("Luke", "AE85", 90, 40);
    IPaycheck paycheck = hourly.getPaycheck();
    assertEquals(true, paycheck instanceof HourlyPaycheck);
    assertEquals(90, hourly.getPayRate(), 0.01);
  }
  
  /**
   * Test toString method.
   */
  @Test
  public void testToString() {
    Employee salaried = new Employee("Luke", "AE86",
            90000, 4, true);
    assertEquals("Name: Luke\nID: AE86\nPayment after taxes: $ 5884.62",
            salaried.toString());
    
    Employee hourly = new Employee("Luke", "AE85", 90, 40);
    assertEquals("Name: Luke\nID: AE85\nPayment after taxes: $ 3060.00", hourly.toString());
  }
}
