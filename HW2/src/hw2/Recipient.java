package hw2;

/**
 * This is a class to have Recipient name and email.
 */
public class Recipient {
  private final String firstName;
  private final String lastName;
  private final String email;
  
  /**
   * This is the constructor for recipient.
   * Setting some conditions: name and email cannot be null.
   * Name and email cannot be null.
   * @param firstName first name.
   * @param lastName last name.
   * @param email email.
   */
  public Recipient(String firstName, String lastName, String email) {
    if (firstName == null || lastName == null || email == null) {
      throw new IllegalArgumentException("Name is null. Check please!");
    }
    if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
      throw new IllegalArgumentException("Do not enter empty string!");
    }
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }
  
  /**
   * Getter method for first name.
   * @return first name.
   */
  public String getFirstName() {
    return this.firstName;
  }
  
  /**
   * Getter method for last name.
   * @return last name.
   */
  public String getLastName() {
    return this.lastName;
  }
  
  /**
   * Getter method for email.
   * @return email.
   */
  public String getEmail() {
    return this.email;
  }
  /**
   * toString method for getting string with name and email.
   * @return string includes name and email.
   */
  
  @Override
  public String toString() {
    return String.format("%s %s Email:%s", firstName, lastName, email);
  }
  
  /**
   * This is an override equals method to check hashcode equality between two objects.
   * @param other other.
   * @return true or false
   */
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (this.getClass() == other.getClass()) {
      Recipient o = (Recipient) other;
      if (this.lastName.equals(o.lastName) && (this.firstName.equals(o.firstName))
              && (this.email == o.email)) {
        return true;
      }
    }
    return false;
  }
}
