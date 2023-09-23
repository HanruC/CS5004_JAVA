package registration;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The Registration class represents a vehicle registration.
 */
public class Registration implements IRegistration {
  private int registrationYear;
  private IVehicle vehicle;
  private IJurisdiction jurisdiction;
  private List<Person> owners;
  
  /**
   * Constructor for Registration.
   * @param registrationYear - the year of the registration.
   * @param vehicle - the vehicle to be registered.
   * @param jurisdiction - the jurisdiction of the registration.
   * @param owners - the owners of the vehicle.
   */
  public Registration(int registrationYear, IVehicle vehicle,
                      IJurisdiction jurisdiction, List<Person> owners) {
    
    this.registrationYear = registrationYear;
    this.vehicle = vehicle;
    this.jurisdiction = jurisdiction;
    this.owners = Collections.unmodifiableList(owners);
  }
  
  /**
   * Get the registration year.
   * @return the registration year.
   */
  @Override
  public int getRegistrationYear() {
    return this.registrationYear;
  }
  
  /**
   * Get the vehicle production year.
   * @return the vehicle production year.
   */
  @Override
  public int getProductionYear() {
    return vehicle.getProductionYear();
  }
  
  /**
   * Get the Jurisdiction.
   * @return the Jurisdiction.
   */
  @Override
  public IJurisdiction getJurisdiction() {
    return this.jurisdiction;
  }
  
  /**
   * Get the owners of the vehicle.
   * @return the owners of the vehicle.
   */
  @Override
  public List<Person> getOwners() {
    return this.owners;
  }
  
  /**
   * Get the max passengers of the vehicle.
   * @return the max passengers of the vehicle.
   */
  @Override
  public int getMaxPassengers() {
    return vehicle.getMaxPassengers();
  }
  
  /**
   * Calculate the excise tax.
   * @return the excise tax.
   */
  @Override
  public double calculateExciseTax() {
    return jurisdiction.exciseTax(vehicle);
  }
  
  /**
   * Specified toString method.
   * @return the string representation of the registration.
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    String ownerList = owners.stream().map(Person::toString)
            .collect(Collectors.joining("; "));
    builder.append("Registration:\n").append(vehicle.getVehicleType().toUpperCase()).append(": ")
            .append(vehicle.getMake()).append(" Year(").append(vehicle.getProductionYear())
            .append(") ").append(" Price = $").append(String.format("%.2f", vehicle.getPrice()))
            .append("\n").append("Owned By: ").append(ownerList).append("\n").append("Year: ")
            .append(this.registrationYear).append("\nExcise Tax: $")
            .append(String.format("%.2f", calculateExciseTax()));
    return builder.toString();
  }
  
  /**
   * Specified equals method.
   * @param obj - the object to be compared.
   * @return true if the two objects are equal, false otherwise. Ignore the jurisdiction since
   *     it is not allowed to register a vehicle in two different jurisdictions.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || this.getClass() != obj.getClass()) return false;
    Registration other = (Registration) obj;
    return this.registrationYear == other.registrationYear
            && this.vehicle.equals(other.vehicle)
            && this.owners.equals(other.owners);
  }
  
  /**
   * Specified hashCode method.
   * @return the hash code of the registration.
   */
  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + registrationYear;
    result = 31 * result + vehicle.hashCode();
    result = 31 * result + owners.hashCode();
    return result;
  }
}
