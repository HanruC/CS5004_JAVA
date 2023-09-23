package shape;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The ShapeStorage class is used to store all the shapes in a hashmap.
 */
public class ShapeStorage {
  private final List<Shape> shapesList = new ArrayList<>();
  private final Set<String> namesList = new HashSet<>();
  private final Map<String, Shape> shapesMap = new HashMap<>();
  
  
  /**
   * Get the shape object from the hashmap.
   * @param name the name of the shape
   * @return the shape object
   */
  public Shape getShapeObject(String name) {
    return shapesMap.get(name);
  }
  
  /**
   * Get all names of the shapes.
   * @return a list of all names of the shapes
   */
  public List<String> getNamesList() {
    return new ArrayList<>(namesList);
  }
  
  /**
   * Get size of the shapeList.
   * @return the size of the shapeList
   */
  public int getSize() {
    return shapesList.size();
  }
  
  /**
   * Get shape from the shapeList.
   * @param index the index of the shape in the shapeList
   * @return the shape
   */
  public Shape getShape(int index) {
    return shapesList.get(index);
  }
  
  /**
   * Add a shape to the hashmap.
   * @param shape the shape to be added to the hashmap
   * @return true if the shape is added successfully, false otherwise
   */
  public boolean addShape(Shape shape) {
    if (!namesList.contains(shape.getName())) {
      shapesList.add(shape);
      namesList.add(shape.getName());
      shapesMap.put(shape.getName(), shape);
      return true;
    }
    return false;
  }
  
  /**
   * Remove a shape from the hashmap.
   * @param name the name of the shape to be removed
   * @return true if the shape is removed successfully, false otherwise
   */
  public boolean removeShape(String name) {
    Shape shape = getShapeObject(name);
    if (shape != null) {
      shapesList.remove(shape);
      namesList.remove(name);
      shapesMap.remove(name);
      return true;
    }
    return false;
  }
  
  /**
   * Clear the hashmap. Remove all the shapes.
   */
  public void clear() {
    shapesList.clear();
    namesList.clear();
    shapesMap.clear();
  }
  
  /**
   * Get all the shapes in the hashmap.
   * @return a list of all the shapes in the hashmap
   */
  public List<Shape> getAllShapes() {
    return new ArrayList<>(shapesList);
  }
  
  /**
   * Get the description of all the shapes in the hashmap.
   * @return a string of all the shapes in the hashmap
   */
  public String getAllShapesDescription() {
    StringBuilder builder = new StringBuilder();
    for (Shape shape: getAllShapes()) {
      builder.append(shape.toString());
      builder.append("\n");
    }
    return builder.toString();
  }
}
