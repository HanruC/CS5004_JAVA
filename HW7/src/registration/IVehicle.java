package registration;

/**
 * Interface for a vehicle.
 */
public interface IVehicle {
  
  /**
   * Get the make of the vehicle.
   * @return the make of the vehicle
   */
  String getMake();
  
  /**
   * Get the production year of the vehicle.
   * @return the production year of the vehicle
   */
  int getProductionYear();
  
  /**
   * Get the price of the vehicle.
   * @return the price of the vehicle
   */
  double getPrice();
  
  /**
   * Get the max number of passengers for the vehicle.
   * @return the max number of passengers for the vehicle
   */
  int getMaxPassengers();
  
  /**
   * Get the vehicle type.
   * @return the vehicle type
   */
  String getVehicleType();
}
