package hw2;

/**
 * This is a class for room.
 * Getting an enum for having different types of room.
 */
public class Room {
  private final RoomType type;
  // private final double price;
  private int guests;
  private int maxOccupancy;
  
  /**
   * constructor of room.
   * Also, giving different conditions for different types of room.
   * @param type type of room.
   * @param price room price.
   */
  public Room(RoomType type, double price) {
    int SmallestBounder = 0;
    if (price < SmallestBounder) {
      throw new IllegalArgumentException("Negative price. Please reset!");
    }
    this.type = type;
    //this.price = price;
    this.guests = 0;
    switch (this.type) {
      case SINGLE:
        this.maxOccupancy = 1;
        break;
      case DOUBLE:
        this.maxOccupancy = 2;
        break;
      case FAMILY:
        this.maxOccupancy = 4;
        break;
    }
  }
  
  /**
   * Method to check if the room is available.
   * @return true or false.
   */
  public boolean isAvailable() {
    int zeroGuest = 0;
    if (guests != zeroGuest) {
      return false;
    }
    return true;
  }
  
  /**
   * Getter method for number of guests.
   * @return guests.
   */
  public int getNumberOfGuests() {
    return this.guests;
  }
  
  /**
   * check the room can be booked or not.
   * @param guests guests.
   */
  public void bookRoom(int guests) {
    int guestBounder = 0;
    if (isAvailable() && guests > guestBounder && guests <= maxOccupancy) {
      this.guests = guests;
    }
  }
}
