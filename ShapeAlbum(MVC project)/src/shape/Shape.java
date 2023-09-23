package shape;


/**
 * Shape interface which includes several methods that should be implemented.
 * Includes methods for getting the shape's name, the shape's type, the shape's color
 *    and the shape's description.
 * Setting methods for name and color. Method for moving the shape and the scale method.
 */
public interface Shape {
  
  /**
   * Method for getting the shape's name. Such as "R" or "O".
   * @return name
   */
  String getName();
  
  /** Method for getting the shape's type.
   * @return type of the shape
   */
  String getType();
  
  
  /**
   * Method for getting the shape's x coordinate.
   * @return x
   */
  double getX();
  
  /**
   * Method for getting the shape's y coordinate.
   * @return y
   */
  double getY();
  
  /**
   * Method for setting the shape's x coordinate.
   * @param x X coordinate
   */
  void setX(double x);
  
  /**
   * Method for setting the shape's y coordinate.
   * @param y Y coordinate
   */
  void setY(double y);
  
  /**
   * Method for setting the shape's name.
   * @param name Name
   */
  void setName(String name);
  
  /**
   * Method for getting color Red.
   * @return red
   */
  int getRed();
  
  /**
   * Method for getting color Green.
   * @return green
   */
  int getGreen();
  
  /**
   * Method for getting color Blue.
   * @return blue
   */
  int getBlue();
  
  /**
   * Method for setting color Red.
   * @param red Red
   */
  void setRed(int red) throws IllegalArgumentException;
  
  /**
   * Method for setting color Green.
   * @param green Green
   */
  void setGreen(int green) throws IllegalArgumentException;
  
  /**
   * Method for setting color Blue.
   * @param blue Blue
   */
  void setBlue(int blue) throws IllegalArgumentException;
  
  /**
   * Method for change three color together and return true if success.
   * @param newRed new Red
   * @param newGreen new Green
   * @param newBlue new Blue
   * @return true if success
   */
  boolean changeThreeColor(int newRed, int newGreen, int newBlue);
  
  /**
   * Method for moving the shape.
   * @param moveX X coordinate
   * @param moveY Y coordinate
   */
  void move(double moveX, double moveY);
  
  /**
   * Method for resizing the shape. If the shape has more than two parameters, we could override.
   * @param firstParameter first parameter
   * @param secondParameter second parameter
   * @return true if success
   */
  boolean resize(double firstParameter, double secondParameter);
  
  /**
   * Method for deep copy the shape.
   * @return new shape
   */
  Shape copy();
  
  /**
   * Method for add shape to shape storage.
   * @param shapeStorage shape storage
   */
  void addToShapeStorage(ShapeStorage shapeStorage);
  
  /**
   * Returns the SVG string of the shape.
   * @return SVG string
   */
  String toSVGString();
}
