package model;

import shape.Oval;
import shape.Rectangle;
import shape.Shape;

/**
 * Factory design pattern for creating shapes.
 */
public class ShapeFactoryDesign {
  
  /**
   * Create a shape.
   * @param type the type of the shape.
   * @param name the name of the shape.
   * @param x the x coordinate of the shape.
   * @param y the y coordinate of the shape.
   * @param red the red value of the shape.
   * @param green the green value of the shape.
   * @param blue the blue value of the shape.
   * @param firstParameter the first parameter of the shape.
   * @param secondParameter the second parameter of the shape.
   * @return the shape.
   */
  public Shape createShape(String type, String name, double x, double y, double red,
                           double green, double blue, double firstParameter,
                           double secondParameter) {
    if (type.equalsIgnoreCase("Oval")) {
      return new Oval(name, x, y, red, green, blue, firstParameter, secondParameter);
    } else if (type.equalsIgnoreCase("Rectangle")) {
      return new Rectangle(name, x, y, red, green, blue, firstParameter, secondParameter);
    } else {
      return null;
    }
  }
}
