package registration;

/**
 * The class of an automobile.
 */
public class Automobile implements IVehicle {
  private String make;
  private int year;
  private double price;
  
  /**
   * Constructor for an automobile.
   * @param make the make of the automobile
   * @param year the year of the automobile
   * @param price the price of the automobile
   */
  public Automobile(String make, int year, double price) {
    this.make = make;
    this.year = year;
    this.price = price;
  }
  
  /**
   * Get the make of the automobile.
   * @return the make of the automobile
   */
  @Override
  public String getMake() {
    return this.make;
  }
  
  /**
   * Get the year of the automobile.
   * @return the year of the automobile
   */
  @Override
  public int getProductionYear() {
    return this.year;
  }
  
  /**
   * Get the price of the automobile.
   * @return the price of the automobile
   */
  @Override
  public double getPrice() {
    return this.price;
  }
  
  /**
   * Get the maximum number of passengers for the automobile.
   * @return the maximum number of passengers for the automobile
   */
  @Override
  public int getMaxPassengers() {
    return 5;
  }
  
  /**
   * Get the type of the automobile.
   * @return the type of the automobile
   */
  @Override
  public String getVehicleType() {
    return "Automobile";
  }
}
