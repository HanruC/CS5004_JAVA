package employee;

import java.text.DecimalFormat;

/**
 * Employee class which includes two kinds of employees.
 */
public class Employee {
  private String name;
  private String id;
  private double payRate;
  private int payInterval;
  private boolean isManager;
  private double hoursWorked;
  private IPaycheck NewPaycheck;
  
  /**
   * First constructor for Salaried.
   * @param name name of employee.
   * @param id id of employee.
   * @param payRate payRate of employee.
   * @param payInterval pay interval of employee.
   * @param isManager check if it is manager.
   * @throws IllegalArgumentException three constraints.
   */
  public Employee(String name, String id, double payRate, int payInterval, boolean isManager)
          throws IllegalArgumentException {
    double rateLimit = 0;
    double payIntervalLimit = 1;
    double payIntervalLimit2 = 2;
    double payIntervalLimit4 = 4;
    if (name == null || name.isEmpty() || id == null || id.isEmpty()) {
      throw new IllegalArgumentException("NAME and ID cannot be empty or null");
    }
    if (payRate < rateLimit) {
      throw new IllegalArgumentException("Wrong pay rate.");
    }
    if (payInterval != payIntervalLimit && payInterval != payIntervalLimit2
            && payInterval != payIntervalLimit4) {
      throw new IllegalArgumentException("Invalid pay interval.");
    }
    this.name = name;
    this.id = id;
    this.payRate = payRate;
    this.payInterval = payInterval;
    this.isManager = isManager;
    this.hoursWorked = -1;
    this.NewPaycheck = null;
  }
  
  /**
   * The second constructor for the hourly employee.
   * @param name name of the employee.
   * @param id id of the employee.
   * @param payRate pay rate of the employee.
   * @param hoursWorked hours worked of the employee.
   * @throws IllegalArgumentException three constraints.
   */
  public Employee(String name, String id, double payRate, double hoursWorked)
          throws IllegalArgumentException {
    double rateLimit = 0;
    double hoursLimit = 0;
    if (name == null || name.isEmpty() || id == null || id.isEmpty()) {
      throw new IllegalArgumentException("Name and Id cannot be null or empty.");
    }
    if (payRate < rateLimit) {
      throw new IllegalArgumentException("Wrong pay rate.");
    }
    if (hoursWorked < hoursLimit) {
      throw new IllegalArgumentException("Invalid value for hours");
    }
    
    this.name = name;
    this.id = id;
    this.payRate = payRate;
    this.hoursWorked = hoursWorked;
    this.isManager = false; // hour worker cannot be manager.
    this.NewPaycheck = null;
  }
  
  /**
   * Check if it is manager.
   * @return True or false.
   */
  public boolean isManager() {
    return this.isManager;
  }
  
  /**
   * Getter for name.
   * @return name.
   */
  public String getName() {
    return this.name;
  }
  
  /**
   * Getter for id.
   * @return id.
   */
  public String getId() {
    return this.id;
  }
  
  /**
   * Getter for pay rate.
   * @return pay rate.
   */
  public double getPayRate() {
    return this.payRate;
  }
  
  /**
   * Getter for pay interval.
   * @return pay interval.
   */
  public int getPayInterval() {
    return this.payInterval;
  }
  
  /**
   * Getter for hours.
   * @return hours worked.
   */
  public double getHoursWorked() {
    return this.hoursWorked;
  }
  
  /**
   * Getter for pay check. Accessing from two concrete classes.
   * @return paycheck.
   */
  public IPaycheck getPaycheck() {
    if (this.NewPaycheck == null) {
      if (this.hoursWorked == -1) {
        this.NewPaycheck = new SalariedPaycheck(this.payRate, this.payInterval);
      } else {
        this.NewPaycheck = new HourlyPaycheck(this.payRate, this.hoursWorked);
      }
    }
    return this.NewPaycheck;
  }
  
  /**
   * Override toString method.
   * @return string.
   */
  @Override
  public String toString() {
    IPaycheck paycheck = getPaycheck();
    DecimalFormat d = new DecimalFormat("0.00");
    return "Name: " + this.name + "\n"
            + "ID: " + this.id + "\n"
            + "Payment after taxes: $ " + d.format(paycheck.getPayAfterTaxes());
  }
}
