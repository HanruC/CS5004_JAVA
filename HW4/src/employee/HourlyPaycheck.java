package employee;

/**
 * HourlyPaycheck class.
 */
public class HourlyPaycheck extends Paycheck {
  private double hours;
  private double total;
  
  /**
   * HourlyPaycheck constructor.
   * @param payRate pay rate.
   * @param hours hours worked.
   */
  public HourlyPaycheck(double payRate, double hours) {
    super(payRate);
    double hoursLimit = 0;
    double payRateLimit = 0;
    if (hours < hoursLimit) {
      throw new IllegalArgumentException("Hours should be larger than 0.");
    }
    if (payRate < payRateLimit) {
      throw new IllegalArgumentException("Pay rate should be larger than 0.");
    }
    this.hours = hours;
  }
  
  /**
   * Getter for total pay.
   * @return total paid.
   */
  @Override
  public double getTotalPay() {
    if (this.hours <= 40) {
      total = this.payRate * this.hours;
    } else {
      double overtimes = this.hours - 40;
      total = (this.payRate * 40) + (overtimes * this.payRate * 1.5);
    }
    return total;
  }
  
  /**
   * Getter for hours worked.
   * @return hours worked.
   */
  public double getHoursWorked() {
    return this.hours;
  }
  
  /**
   * Add method for hours.
   * @param hoursAdded hours need to add.
   */
  public void addHoursWorked(double hoursAdded) {
    if (this.hours + hoursAdded < 0) { // check if drop lower than 0. If it is then reset to 0.
      this.hours = 0;
    } else {
      this.hours = this.hours + hoursAdded;
    }
    total = getTotalPay();
  }
  
  /**
   * Reset the hours worked.
   */
  public void resetHoursWorked() {
    this.hours = 0;
  }
}