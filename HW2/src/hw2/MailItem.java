package hw2;

/**
 * This is a class for mail item, which includes width, height, depth, and person from Recipient
 * class.
 */
public class MailItem {
  private final int width;
  private final int height;
  private final int depth;
  private final Recipient person;
  
  /**
   * This is a constructor for the mail item.
   * Set some constraints. No smaller than 1 in any dimension.
   * Person cannot be null.
   * @param width width.
   * @param height height.
   * @param depth depth.
   * @param person person.
   */
  public MailItem(int width, int height, int depth, Recipient person) {
    int bounder = 1;
    if (width < bounder || height < bounder || depth < bounder) {
      throw new IllegalArgumentException("Should be larger than 1.");
    }
  
    if (person == null) {
      throw new IllegalArgumentException("recipient cannot be null. Reenter!");
    }
    this.width = width;
    this.height = height;
    this.depth = depth;
    this.person = person;
  }
  
  /**
   * Getter method for width.
   * @return width.
   */
  public int getWidth() {
    return this.width;
  }
  
  /**
   * Getter method for height.
   * @return height.
   */
  public int getHeight() {
    return this.height;
  }
  
  /**
   * Getter method for depth.
   * @return depth.
   */
  public int getDepth() {
    return this.depth;
  }
  
  /**
   * Getter method for recipient.
   * @return person for recipient.
   */
  public Recipient getRecipient() {
    return this.person;
  }
}
