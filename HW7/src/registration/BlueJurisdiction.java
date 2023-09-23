package registration;

/**
 * The Blue Jurisdiction.
 */
public class BlueJurisdiction implements IJurisdiction {
  @Override
  public double exciseTax(IVehicle vehicle) {
    double taxRate = 0.03; // 3%
    double tax = vehicle.getPrice() * taxRate;
    int yearLimit = 2000;
    if (vehicle.getProductionYear() < yearLimit) { // older than 2000
      int additional = 99;
      tax += additional;
    }
    return tax;
  }
  
  /**
   * Returns the name of the jurisdiction.
   * @return the name of the jurisdiction
   */
  @Override
  public String toString() {
    return "Blue Jurisdiction";
  }
}
