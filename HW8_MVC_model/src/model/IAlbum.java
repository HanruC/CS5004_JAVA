package model;

import shape.Shape;
import snapshot.Snapshot;

import java.util.List;

/**
 * The interface of ShapeAction.
 */
public interface IAlbum {
  
  /**
   * Create a snapshot of the list of shapes.
   * @param type the type of the snapshot.
   * @param name the name of the shape.
   * @param x the x coordinate of the shape.
   * @param y the y coordinate of the shape.
   * @param red the red value of the shape.
   * @param green the green value of the shape.
   * @param blue the blue value of the shape.
   * @param firstParameter the first parameter of the shape.
   * @param secondParameter the second parameter of the shape.
   */
  boolean createShape(String type, String name, double x, double y, double red, double green,
                         double blue, double firstParameter, double secondParameter);
  
  /**
   * Create a snapshot of the list of shapes.
   * @param description the description of the snapshot.
   */
  void createSnapshot(String description);
  
  /**
   * Get all snapshots.
   * @return the list of snapshots.
   */
  List<Snapshot> getSnapshots();
  
  /**
   * Get a snapshot from the list of snapshots.
   * @param id the id of the snapshot to be returned.
   * @return the snapshot with the given index.
   */
  Snapshot getSnapshot(String id);
  
  /**
   * Get the list of ids of all snapshots.
   * @return the list of ids of all snapshots.
   */
  List<String> getIdList();
  
  /**
   * Clear all snapshots.
   */
  void clearSnapShots();
  
  /**
   * Add a shape to the list of shapes.
   * @param shape the shape to be added.
   */
  void addShape(Shape shape);
  
  /**
   * Clear all shapes.
   */
  void clearAllShapes();
  
  /**
   * Get the shape with the given name.
   * @param name the name of the shape.
   * @return the shape with the given name.
   */
  Shape getShape(String name);
  
  /**
   * Get the list of shapes.
   * @return the list of shapes.
   */
  List<Shape> getShapeListWithAll();
  
  /**
   * Get the list of shapes.
   * @return the list of shapes.
   */
  String getAllShapesDescription();
  
  /**
   * Move the shape with the given name.
   * @param name the name of the shape.
   * @param moveX the x coordinate to be moved.
   * @param moveY the y coordinate to be moved.
   * @return true if the shape is moved successfully, false otherwise.
   */
  boolean moveShapeAndCheck(String name, double moveX, double moveY);
  
  /**
   * Resize the shape with the given name.
   * @param shapeName the name of the shape.
   * @param first the first parameter of the shape.
   * @param second the second parameter of the shape.
   * @return true if the shape is resized successfully, false otherwise.
   */
  boolean resizeShapeAndCheck(String shapeName, double first, double second);
  
  /**
   * Change the color of the shape with the given name.
   * @param name the name of the shape.
   * @param red the red value of the shape.
   * @param green the green value of the shape.
   * @param blue the blue value of the shape.
   * @return true if the shape is changed successfully, false otherwise.
   */
  boolean changeColorAndCheck(String name, double red, double green, double blue);
  
  /**
   * Remove the shape with the given name.
   * @param name the name of the shape.
   * @return true if the shape is removed successfully, false otherwise.
   */
  boolean removeShapeAndCheck(String name);
  
  /**
   * Check if the name of the shape is valid.
   * @param name the name of the shape.
   * @return true if the name is valid, false otherwise.
   */
  boolean checkIfNameExist(String name);
  
  /**
   * Reboot the album.
   */
  void reboot();
  
}
