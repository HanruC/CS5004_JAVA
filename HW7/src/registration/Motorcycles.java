package registration;

/**
 * This class represents a motorcycle.
 */
public class Motorcycles implements IVehicle {
  private String make;
  private int year;
  private double price;
  
  /**
   * Constructor for a motorcycle.
   * @param make Vehicle make
   * @param year Vehicle year
   * @param price Vehicle price
   */
  public Motorcycles(String make, int year, double price) {
    this.make = make;
    this.year = year;
    this.price = price;
  }
  
  /**
   * Returns the make of the vehicle.
   * @return Make of the vehicle
   */
  @Override
  public String getMake() {
    return this.make;
  }
  
  /**
   * Returns the year of the vehicle.
   * @return Year of the vehicle
   */
  @Override
  public int getProductionYear() {
    return this.year;
  }
  
  /**
   * Returns the price of the vehicle.
   * @return Price of the vehicle
   */
  @Override
  public double getPrice() {
    return this.price;
  }
  
  /**
   * Returns the maximum number of passengers for the vehicle.
   * @return Maximum number of passengers for the vehicle
   */
  @Override
  public int getMaxPassengers() {
    return 2;
  }
  
  /**
   * Returns the vehicle type.
   * @return Vehicle type
   */
  @Override
  public String getVehicleType() {
    return "Motorcycle";
  }
}
