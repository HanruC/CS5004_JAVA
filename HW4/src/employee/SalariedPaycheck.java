package employee;

/**
 * SalariedPaycheck class which extends Paycheck abstract class.
 */
public class SalariedPaycheck extends Paycheck {
  private int payInterval;
  
  /**
   * SalariedPaycheck constructor.
   * @param payRate pay rate.
   * @param payInterval pay interval.
   * @throws IllegalArgumentException constraints for payInterval.
   */
  public SalariedPaycheck(double payRate, int payInterval) throws IllegalArgumentException {
    super(payRate);
    double payIntervalLimit = 1;
    double payIntervalLimit2 = 2;
    double payIntervalLimit4 = 4;
    if (payInterval != payIntervalLimit && payInterval != payIntervalLimit2
            && payInterval != payIntervalLimit4) {
      throw new IllegalArgumentException("Invalid number for pay interval!");
    }
    double rateLimit = 0;
    if (payRate < rateLimit) {
      throw new IllegalArgumentException("Wrong pay rate.");
    }
    this.payInterval = payInterval;
  }
  
  /**
   * Getter for total pay.
   * @return total pay for salaried worker.
   */
  @Override
  public double getTotalPay() {
    return (this.payRate / 52) * this.payInterval;
  }
  
  public int getPayInterval() {
    return this.payInterval;
  }
}
