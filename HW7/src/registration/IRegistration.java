package registration;

import java.util.List;

/**
 * The interface of a vehicle registration.
 */
public interface IRegistration {
  
  /**
   * Get the registration year.
   * @return the registration year
   */
  int getRegistrationYear();
  
  /**
   * Get the production year.
   * @return production year
   */
  int getProductionYear();
  
  /**
   * Get the jurisdiction.
   * @return the jurisdiction
   */
  IJurisdiction getJurisdiction();
  
  /**
   * Get the owner list.
   * @return the owner list
   */
  List<Person> getOwners();      // return NON-MUTABLE list
  
  /**
   * Get the maximum number of passengers.
   * @return the maximum number of passengers
   */
  int getMaxPassengers();
  
  /**
   * Calculate the excise tax.
   * @return the excise tax
   */
  double calculateExciseTax();
}
