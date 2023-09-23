package employee;

/**
 * Interface of IPaycheck with three main methods.
 */
public interface IPaycheck {
  /**
   * Getter method for total pay.
   * @return total pay.
   */
  double getTotalPay();
  
  /**
   * Getter method for pay after taxes.
   * @return pay after taxes.
   */
  double getPayAfterTaxes();
  
  /**
   * Getter for pay rate.
   * @return pay rate.
   */
  double getPayRate();
}