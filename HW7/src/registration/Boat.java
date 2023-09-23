package registration;

/**
 * The class of a boat.
 */
public class Boat implements IVehicle {
  private String make;
  private int year;
  private double price;
  
  /**
   * Constructor for a boat.
   * @param make the make of the boat
   * @param year the year of the boat
   * @param price the price of the boat
   */
  public Boat(String make, int year, double price) {
    this.make = make;
    this.year = year;
    this.price = price;
  }
  
  /**
   * Get the make of the boat.
   * @return the make of the boat
   */
  @Override
  public String getMake() {
    return this.make;
  }
  
  /**
   * Get the year of the boat.
   * @return the year of the boat
   */
  @Override
  public int getProductionYear() {
    return this.year;
  }
  
  /**
   * Get the price of the boat.
   * @return the price of the boat
   */
  @Override
  public double getPrice() {
    return this.price;
  }
  
  /**
   * Get the maximum number of passengers for the boat.
   * @return the maximum number of passengers for the boat
   */
  @Override
  public int getMaxPassengers() {
    return 10;
  }
  
  /**
   * Get the type of the boat.
   * @return the type of the boat
   */
  @Override
  public String getVehicleType() {
    return "Boat";
  }
}
