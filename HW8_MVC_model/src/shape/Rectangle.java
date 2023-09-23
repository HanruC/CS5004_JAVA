package shape;

/**
 * Represents a rectangle shape.
 */
public class Rectangle extends AbstractShape {
  private double width;
  private double height;
  
  /**
   * Constructor for the Rectangle class.
   * @param name Name
   * @param red Red color value
   * @param green Green color value
   * @param blue Blue color value
   * @param x X coordinate
   * @param y Y coordinate
   * @param width Width
   * @param height Height
   */
  public Rectangle(String name, double red, double green, double blue, double x, double y,
                   double width, double height) throws IllegalArgumentException {
    super(name, red, green, blue, x, y);
    if (!setAndCheckWidth(width)) {
      throw new IllegalArgumentException("Width is negative.");
    }
    if (!setAndCheckHeight(height)) {
      throw new IllegalArgumentException("Height is negative.");
    }
  }
  
  /**
   * Private helper method for checking if the width is valid and setting it.
   * @param width Width
   * @return true if width is valid, false otherwise
   */
  private boolean setAndCheckWidth(double width) {
    double lowerBound = 0.0;
    if (width < lowerBound) {
      return false;
    }
    this.width = width;
    return true;
  }
  
  /**
   * Private helper method for checking if the height is valid and setting it.
   * @param height Height
   * @return true if height is valid, false otherwise
   */
  private boolean setAndCheckHeight(double height) {
    double lowerBound = 0.0;
    if (height < lowerBound) {
      return false;
    }
    this.height = height;
    return true;
  }
  
  /**
   * Resize the rectangle to a new width and height.
   * @param newWidth New width
   * @param newHeight New height
   * @return true if the resize is successful, false otherwise
   */
  @Override
  public boolean resize(double newWidth, double newHeight) {
    if (setAndCheckWidth(newWidth) && setAndCheckHeight(newHeight)) {
      return true;
    }
    return false;
  }
  
  
  /**
   * Method for getting the shape's width.
   * @return width
   */
  public double getWidth() {
    return this.width;
  }
  
  /**
   * Method for getting the shape's height.
   * @return height
   */
  public double getHeight() {
    return this.height;
  }
  
  
  /**
   * Method for getting the shape's type.
   * @return type
   */
  @Override
  public String getType() {
    return "Rectangle";
  }
  
  /**
   * Copy method for the shape.
   * @return copy of the shape
   */
  @Override
  public Shape copy() {
    return new Rectangle(this.name, this.red, this.green, this.blue,
            this.x, this.y, this.width, this.height);
  }
  
  /**
   * Method for getting the shape's information.
   * @return shape information
   */
  @Override
  public String toString() {
    return "Name: " + getName() + "\n"
            + "Type: " + getType() + "\n"
            + "Min corner: (" + getX() + ", " + getY() + ")\n"
            + "Width: " + getWidth() + "\n"
            + "Height: " + getHeight() + "\n"
            + "Color: (" + getRed() + ", " + getGreen() + ", " + getBlue() + ")\n";
  }
  
  /**
   * Adding the shape to the shape storage.
   * @param shapeStorage Shape storage
   */
  @Override
  public void addToShapeStorage(ShapeStorage shapeStorage) {
    shapeStorage.addShape(this);
  }
}
