package registration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * The RegistrationSystem class is a Singleton class that manages the registration of vehicles.
 */
public class RegistrationSystem {
  private List<IRegistration> registrations;
  private static RegistrationSystem instance;
  
  // Private constructor to enforce the Singleton pattern.
  // Only one instance, and prevent other classes from creating instances.
  // Only through the getInstance() method can we get an instance.
  private RegistrationSystem() {
    registrations = new ArrayList<>();
  }
  
  /**
   * Get the instance of the RegistrationSystem.
   * @return the instance of the RegistrationSystem.
   */
  public static RegistrationSystem getInstance() {
    if (instance == null) { // check if the instance has been created or not.
      instance = new RegistrationSystem();
    }
    return instance;
  }
  
  /**
   * Add a registration to the system.
   * @param kind - the kind of vehicle.
   * @param make - the make of the vehicle.
   * @param productionYear - the year the vehicle was produced.
   * @param purchasePrice - the price the vehicle was purchased for
   * @return the concrete vehicle object created. Null if the kind is not recognized.
   * @throws IllegalArgumentException IllegalArgumentException.
   */
  public IVehicle createVehicle(String kind, String make,  int productionYear, double purchasePrice)
          throws  IllegalArgumentException {
    if (kind == null || kind.isEmpty()) {
      throw new IllegalArgumentException("Kind cannot be null or empty.");
    }
    if (make == null || make.isEmpty()) {
      throw new IllegalArgumentException("Make cannot be null or empty.");
    }
    int productionYearLow = 1900;
    int productionYearHigh = 2023;
    if (productionYear < productionYearLow || productionYear > productionYearHigh) {
      throw new IllegalArgumentException("Production year must be between 1900 and 2023.");
    }
    double purchasePriceLow = 0.0;
    if (purchasePrice < purchasePriceLow) {
      throw new IllegalArgumentException("Purchase price cannot be negative.");
    }
    
    if ("Boat".equalsIgnoreCase(kind)) {
      return new Boat(make, productionYear, purchasePrice); 
    } else if ("Auto".equalsIgnoreCase(kind)) {
      return new Automobile(make, productionYear, purchasePrice);
    } else if ("Motorcycle".equalsIgnoreCase(kind)) {
      return new Motorcycles(make, productionYear, purchasePrice);
    } else {
      return null;
    }
  }
  
  /**
   * Add a registration to the system. If the registration already exists, do nothing.
   * @param vehicle - the vehicle to be registered.
   * @param jurisdiction - the jurisdiction of the registration.
   * @param registrationYear - the year of the registration.
   * @param owners - the owners of the vehicle.
   */
  public void register(IVehicle vehicle, IJurisdiction jurisdiction, int registrationYear,
                       List<Person> owners) {
    Registration newRegistration = new Registration(registrationYear, vehicle, jurisdiction,
            owners); // create a new registration object.
    
    boolean ifDuplicate = registrations.stream()
            .anyMatch(existingRegistration -> existingRegistration.equals(newRegistration));
    
    if (!ifDuplicate) {
      registrations.add(newRegistration);
    }
  }
  
  /**
   * Get all the registrations in the system.
   * @return Unmodifiable list of all the registrations in the system.
   */
  public List<IRegistration> getAllRegistrations() { // answer an unmodifiable list!
    return Collections.unmodifiableList(registrations);
  }
  
  /**
   * Get a filtered list of registrations.
   * @param query - the query to filter the registrations.
   * @return Unmodifiable list of filtered registrations.
   */
  public List<IRegistration> getFilteredList(Predicate<IRegistration> query) {
    // answer an unmodifiable list!
    return registrations.stream()
            .filter(query).collect(Collectors.toUnmodifiableList());
  }
  
  /**
   * Reboot the system to initial "start state".
   */
  public void reboot() { // reset the system to initial "start state"
    registrations.clear();
  }
}
