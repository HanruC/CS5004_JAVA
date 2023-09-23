package registration;

/**
 * The class of GreenJurisdiction.
 */
public class GreenJurisdiction implements IJurisdiction {
  
  /**
   * Returns the excise tax.
   * @param vehicle the vehicle
   * @return the excise tax
   */
  @Override
  public double exciseTax(IVehicle vehicle) {
    double taxRate = 0.04; // 4%
    int passengerAddition = 100;
    return vehicle.getPrice() * taxRate + vehicle.getMaxPassengers() * passengerAddition;
  }
  
  /**
   * Returns the name of the jurisdiction.
   * @return the name of the jurisdiction
   */
  @Override
  public String toString() {
    return "Green Jurisdiction";
  }
}
