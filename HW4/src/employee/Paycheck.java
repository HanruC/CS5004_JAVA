package employee;

import java.text.DecimalFormat;

/**
 * Abstract class for paycheck which implements IPaycheck.
 */
public abstract class Paycheck implements IPaycheck {
  protected double payRate;
  protected double total;
  
  /**
   * Paycheck constructor.
   * @param payRate pay rate.
   */
  public Paycheck(double payRate) {
    double rateLimit = 0;
    if (payRate < rateLimit) {
      throw new IllegalArgumentException("Pay rate should be larger than 0.");
    }
    this.payRate = payRate;
  }
  
  /**
   * Getter for pay rate.
   * @return pay rate.
   */
  public double getPayRate() {
    return this.payRate;
  }
  
  /**
   * Getter method for pay after taxes.
   * @return pay after taxes.
   */
  public double getPayAfterTaxes() {
    total = getTotalPay();
    double paidAfterTaxes;
    if (total < 400) {
      paidAfterTaxes = total - (0.1 * total);
    } else {
      paidAfterTaxes = total - (0.15 * total);
    }
    double roundLow = 0;
    double roundHigh = 0.01;
    if (paidAfterTaxes > roundLow && paidAfterTaxes < roundHigh) {
      paidAfterTaxes = 0.01;
    }
    return paidAfterTaxes;
  }
  
  /**
   * Getter total pay. Different in hourly and salaried.
   * @return total pay.
   */
  public abstract double getTotalPay();
  
  /**
   * Override toString method.
   * @return string.
   */
  @Override
  public String toString() {
    DecimalFormat d = new DecimalFormat("0.00");
    return "Payment after taxes: $ " + d.format(getPayAfterTaxes());
  }
}