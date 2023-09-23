package registration;

/**
 * A person with a name and an address.
 */
public class Person {
  private String name;
  private String address;
  
  /**
   * Constructs a person with a name and an address.
   * @param name the name of the person
   * @param address the address of the person
   */
  public Person(String name, String address) {
    this.name = name;
    this.address = address;
  }
  
  /**
   * Gets the name of the person.
   * @return the name
   */
  public String getName() {
    return this.name;
  }
  
  /**
   * Gets the address of the person.
   * @return the address
   */
  public String getAddress() {
    return this.address;
  }
  
  /**
   * Override toString method.
   * @return the name and address of the person
   */
  @Override
  public String toString() {
    return name + ", " + address;
  }
}
