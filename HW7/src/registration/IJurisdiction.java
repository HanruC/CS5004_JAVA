package registration;

/**
 * The interface of a jurisdiction.
 */
public interface IJurisdiction {
  
  /** Default tax rate.
   * @param vehicle the vehicle
   * @return 0.0
   */
  default double exciseTax(IVehicle vehicle) {
    return 0.0;
  }
}
