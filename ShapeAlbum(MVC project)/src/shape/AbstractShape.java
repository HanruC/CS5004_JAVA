package shape;

/**
 * AbstractShape class which implements the Shape interface.
 */
public abstract class AbstractShape implements Shape {
  protected String name;
  protected int red;
  protected int green;
  protected int blue;
  protected double x;
  protected double y;
  
  /**
   * Constructor for the AbstractShape class.
   * @param name Name
   * @param red Red
   * @param green Green
   * @param blue Blue
   * @param x X coordinate
   * @param y Y coordinate
   */
  public AbstractShape(String name, int red, int green, int blue, double x, double y)
          throws IllegalArgumentException {
    if (name == null || name.equals("")) {
      throw new IllegalArgumentException("Name cannot be null or empty.");
    }
    this.name = name;
    this.x = x;
    this.y = y;
    setRed(red);
    setGreen(green);
    setBlue(blue);
  }
  
  /**
   * Method for getting the shape's name.
   * @return name
   */
  @Override
  public String getName() {
    return this.name;
  }
  
  
  /**
   * Method for getting the shape's x coordinate.
   * @return x
   */
  @Override
  public double getX() {
    return this.x;
  }
  
  /**
   * Method for getting the shape's y coordinate.
   * @return y
   */
  @Override
  public double getY() {
    return this.y;
  }
  
  /**
   * Method for setting the shape's x coordinate.
   * @param x X coordinate
   */
  @Override
  public void setX(double x) {
    this.x = x;
  }
  
  /**
   * Method for setting the shape's y coordinate.
   * @param y Y coordinate
   */
  @Override
  public void setY(double y) {
    this.y = y;
  }
  
  /**
   * Method for setting the shape's name.
   * @param name Name
   */
  @Override
  public void setName(String name) {
    this.name = name;
  }
  
  @Override
  public int getRed() {
    return this.red;
  }
  
  @Override
  public int getGreen() {
    return this.green;
  }
  
  @Override
  public int getBlue() {
    return this.blue;
  }
  
  @Override
  public void setRed(int red) throws IllegalArgumentException {
    int low = 0;
    int high = 255;
    if (red < low || red > high) {
      throw new IllegalArgumentException("Red must be between 0 and 255.");
    }
    this.red = red;
  }
  
  @Override
  public void setGreen(int green) throws IllegalArgumentException {
    int low = 0;
    int high = 255;
    if (green < low || green > high) {
      throw new IllegalArgumentException("Green must be between 0 and 255.");
    }
    this.green = green;
  }
  
  @Override
  public void setBlue(int blue) throws IllegalArgumentException {
    int low = 0;
    int high = 255;
    if (blue < low || blue > high) {
      throw new IllegalArgumentException("Blue must be between 0 and 255.");
    }
    this.blue = blue;
  }
  
  @Override
  public void move(double moveX, double moveY) {
    this.x = moveX;
    this.y = moveY;
  }
  
  @Override
  public boolean changeThreeColor(int newRed, int newGreen, int newBlue) {
    int low = 0;
    int high = 255;
    if (newRed < low || newRed > high || newGreen < low
            || newGreen > high || newBlue < low || newBlue > high) {
      return false;
    }
    this.red = newRed;
    this.green = newGreen;
    this.blue = newBlue;
    return true;
  }
}
