package shape;

/**
 * Oval class.
 */
public class Oval extends AbstractShape {
  private double X_Radius;
  private double Y_Radius;
  
  /**
   * Constructor for the Oval class.
   * @param name Name
   * @param x X coordinate
   * @param y Y coordinate
   * @param X_Radius X radius
   * @param Y_Radius Y radius
   */
  public Oval(String name, int red, int green, int blue, double x, double y,
              double X_Radius, double Y_Radius) throws IllegalArgumentException {
    super(name, red, green, blue, x, y);
    if (!setAndCheckXRadius(X_Radius)) {
      throw new IllegalArgumentException("X radius is negative.");
    }
    if (!setAndCheckYRadius(Y_Radius)) {
      throw new IllegalArgumentException("Y radius is negative.");
    }
  }
  
  /**
   * Private helper method for checking if the X radius is valid and setting it.
   * @param X_Radius X radius
   * @return true if X radius is valid, false otherwise
   */
  private boolean setAndCheckXRadius(double X_Radius) {
    double lowerBound = 0.0;
    if (X_Radius < lowerBound) {
      return false;
    }
    this.X_Radius = X_Radius;
    return true;
  }
  
  /**
   * Private helper method for checking if the Y radius is valid and setting it.
   * @param Y_Radius Y radius
   * @return true if Y radius is valid, false otherwise
   */
  private boolean setAndCheckYRadius(double Y_Radius) {
    double lowerBound = 0.0;
    if (Y_Radius < lowerBound) {
      return false;
    }
    this.Y_Radius = Y_Radius;
    return true;
  }
  
  /**
   * Resize the oval to a new X radius and Y radius.
   * @param xRadius New X radius
   * @param yRadius New Y radius
   * @return true if the resize is successful, false otherwise
   */
  @Override
  public boolean resize(double xRadius, double yRadius) {
    if (setAndCheckXRadius(xRadius) && setAndCheckYRadius(yRadius)) {
      return true;
    }
    return false;
  }

  
  /**
   * Method for getting the shape's X radius.
   * @return X radius
   */
  public double getXRadius() {
    return this.X_Radius;
  }
  
  /**
   * Method for getting the shape's Y radius.
   * @return Y radius
   */
  public double getYRadius() {
    return this.Y_Radius;
  }
  
  /**
   * Method for getting the shape's type.
   * @return type
   */
  @Override
  public String getType() {
    return "Oval";
  }
  
  /**
   * Adding the shape to the shape storage.
   * @param shapeStorage Shape storage
   */
  @Override
  public void addToShapeStorage(ShapeStorage shapeStorage) {
    shapeStorage.addShape(this);
  }
  
  /**
   * Method for getting the shape's information.
   * @return shape's information including name, type, center, x radius, y radius, and color
   */
  @Override
  public String toString() {
    return "Name: " + getName() + "\n"
            + "Type: " + getType() + "\n"
            + "Center: (" + getX() + ", " + getY() + ")\n"
            + "X radius: " + getXRadius() + "\n"
            + "Y radius: " + getYRadius() + "\n"
            + "Color: (" + getRed() + ", " + getGreen() + ", " + getBlue() + ")\n";
  }
  
  /**
   * Copy method for Oval class.
   * @return copy of the Oval object
   */
  @Override
  public Shape copy() {
    return new Oval(this.name, this.red, this.green, this.blue, this.x, this.y, this.X_Radius,
            this.Y_Radius);
  }
  
  @Override
  public String toSVGString() {
    return String.format("<ellipse cx=\"%d\" cy=\"%d\" rx=\"%d\" ry=\"%d\" "
                    + "fill=\"rgb(%d, %d, %d)\" />",
            (int) getX(),
            (int) getY(),
            (int) getXRadius(),
            (int) getYRadius(),
            (int) getRed(),
            (int) getGreen(),
            (int) getBlue());
  }
}
