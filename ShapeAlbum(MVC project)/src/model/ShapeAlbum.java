package model;

import shape.Shape;
import shape.ShapeStorage;
import snapshot.Snapshot;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The implementation of ShapeAlbum. Modeling the album of shapes.
 */
public class ShapeAlbum implements IAlbum {
  private final ShapeStorage shapeStorage;
  private final List<Snapshot> snapshotList;
  private static ShapeAlbum instance = null;
  private final List<String> idList;
  private final ShapeFactoryDesign shapeFactory = new ShapeFactoryDesign();
  private static final DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy "
          + "HH:mm:ss");
  
  /**
   * Constructor of ShapeActionImpl.
   */
  private ShapeAlbum() {
    this.shapeStorage = new ShapeStorage();
    this.snapshotList = new ArrayList<>();
    this.idList = new ArrayList<>();
  }
  
  /**
   * Singleton pattern.
   * @return the instance of ShapeAlbum.
   */
  public static ShapeAlbum getInstance() {
    if (instance == null) {
      instance = new ShapeAlbum();
    }
    return instance;
  }
  
  /**
   * Create a snapshot of the list of shapes.
   * @param type the type of the snapshot.
   *           "Oval" or "Rectangle" or other types. If not belongs to these types, return false
   */
  @Override
  public boolean createShape(String type, String name, double x, double y, int red,
                             int green, int blue, double firstParameter,
                             double secondParameter) {
    double lowerBound = 0;
    double upperBound = 255;
    if (red < lowerBound || red > upperBound || green < lowerBound || green > upperBound
            || blue < lowerBound || blue > upperBound) {
      return false;
    }
    Shape shape = shapeFactory.createShape(type, name, x, y, red, green, blue,
            firstParameter, secondParameter);
    if (shape != null) {
      shapeStorage.addShape(shape);
      return true;
    } else {
      return false;
    }
  }
  
  /**
   * Create a snapshot of the list of shapes.
   * @param description the description of the snapshot.
   */
  @Override
  public void createSnapshot(String description) {
    LocalDateTime myDate = LocalDateTime.now();
    String formattedDate = myDate.format(myFormat);
    long id = ThreadLocalRandom.current().nextLong(1000000L, 10000000L);
    Snapshot newSnapshot = new Snapshot(id, formattedDate, description,
            shapeStorage.getAllShapes());
    
    snapshotList.add(newSnapshot);
    idList.add(newSnapshot.getID());
  }
  
  /**
   * Get all snapshots.
   * @return the list of snapshots.
   */
  @Override
  public List<Snapshot> getSnapshots() {
    return snapshotList;
  }
  
  /**
   * Get a snapshot from the list of snapshots.
   * @param id the id of the snapshot to be returned.
   * @return the snapshot with the given index.
   */
  @Override
  public Snapshot getSnapshot(String id) {
    for (Snapshot snapshot : snapshotList) {
      if (snapshot.getID().equals(id)) {
        return snapshot;
      }
    }
    return null;
  }
  
  /**
   * Get the list of ids of all snapshots.
   * @return the list of ids of all snapshots.
   */
  public List<String> getIdList() {
    return idList;
  }
  
  /**
   * Clear all snapshots.
   */
  public void clearSnapShots() {
    snapshotList.clear();
  }
  
  /**
   * Add a shape to the list of shapes.
   * @param shape the shape to be added.
   */
  public void addShape(Shape shape) {
    shapeStorage.addShape(shape);
  }
  
  /**
   * Clear all shapes.
   */
  public void clearAllShapes() {
    shapeStorage.clear();
  }
  
  
  /**
   * Get the list of shapes.
   * @param name the name of the shape.
   * @return the shape with the given name.
   */
  public Shape getShape(String name) {
    
    return shapeStorage.getShapeObject(name);
  }
  
  /**
   * Get the list of shapes.
   * @return the list of shapes.
   */
  public List<Shape> getShapeListWithAll() {
    return shapeStorage.getAllShapes();
  }
  
  /**
   * Get the shape description.
   * @return the shape description.
   */
  public String getAllShapesDescription() {
    return shapeStorage.getAllShapesDescription();
  }
  
  /**
   * Move shape and check if the move is successful.
   * @param name the name of the shape.
   * @param moveX the x coordinate to be moved.
   * @param moveY the y coordinate to be moved.
   * @return true if the move is successful, false otherwise.
   */
  public boolean moveShapeAndCheck(String name, double moveX, double moveY) {
    Shape shape = shapeStorage.getShapeObject(name);
    if (shape != null) {
      shape.move(moveX, moveY); // calling the move method in the shape class to move the shape.
      return true;
    }
    return false;
  }
  
  /**
   * Resize the shape with the given name to a new width and height.
   * @param shapeName Name of the shape to be resized
   * @param first first parameter of the shape
   * @param second second parameter of the shape
   * @return true if the resize is successful, false otherwise
   */
  public boolean resizeShapeAndCheck(String shapeName, double first, double second) {
    Shape shape = getShape(shapeName);
    if (shape != null) {
      return shape.resize(first, second);
    }
    return false;
  }
  
  /**
   * Change the color of the shape with the given name to a new color.
   * @param name the name of the shape.
   * @param red the red value of the shape.
   * @param green the green value of the shape.
   * @param blue the blue value of the shape.
   * @return true if the change is successful, false otherwise.
   */
  public boolean changeColorAndCheck(String name, int red, int green, int blue) {
    Shape shape = shapeStorage.getShapeObject(name);
    if (shape != null) {
      shape.changeThreeColor(red, green, blue);
      return true;
    }
    return false;
  }
  
  /**
   * Remove the shape with the given name.
   * @param name the name of the shape.
   * @return true if the remove is successful, false otherwise.
   */
  public boolean removeShapeAndCheck(String name) {
    return shapeStorage.removeShape(name);
  }
  
  /**
   * Check if the name of the shape already exists.
   * @param name the name of the shape.
   * @return true if the name exists, false otherwise.
   */
  public boolean checkIfNameExist(String name) {
    return shapeStorage.getNamesList().contains(name);
  }
  
  /**
   * Reboot.
   */
  public void reboot() {
    clearAllShapes();
    clearSnapShots();
  }
  
  /**
   * Get a string representation of the shapes and snapshots.
   * @return a string representation of the shapes and snapshots.
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("************** Shape Album **************\n");
    
    // Shapes
    builder.append("Shapes:\n");
    List<Shape> shapes = getShapeListWithAll();
    if (shapes.isEmpty()) {
      builder.append("- No shapes in album\n");
    } else {
      for (Shape shape : shapes) {
        builder.append("- ").append(shape.toString()).append("\n");
      }
    }
    
    // Snapshots
    builder.append("\nSnapshots:\n");
    List<Snapshot> snapshots = getSnapshots();
    if (snapshots.isEmpty()) {
      builder.append("- No snapshots in album\n");
    } else {
      for (Snapshot snapshot : snapshots) {
        builder.append("- ").append(snapshot.toString()).append("\n");
      }
    }
    return builder.toString();
  }


}
