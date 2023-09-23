package registration;

/**
 * This is a class for Red Jurisdiction.
 */
public class RedJurisdiction implements IJurisdiction {
  
  /**
   * Calculate the excise tax for a vehicle.
   * @param vehicle the vehicle
   * @return the excise tax
   */
  @Override
  public double exciseTax(IVehicle vehicle) {
    double taxRate = 0.05; // 5%
    return vehicle.getPrice() * taxRate;
  }
  
  /**
   * Override toString method.
   * @return the string representation of the object
   */
  @Override
  public String toString() {
    return "Red Jurisdiction";
  }
}
