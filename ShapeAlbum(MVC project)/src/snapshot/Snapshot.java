package snapshot;

import shape.Shape;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class represents a snapshot of the current state of the album.
 */
public class Snapshot implements ISnapshot {
  private String description; //description of the snapshot
  private final List<Shape> shapes;
  private final long id;
  private final String timeStamp;
  
  /**
   * Constructor of the snapshot.
   * @param description the description of the snapshot
   * @param shapes the shapes of the snapshot
   */
  public Snapshot(long id, String timeStamp, String description, List<Shape> shapes) {
    this.description = description;
    this.shapes = new ArrayList<>();
    this.id = id;
    this.timeStamp = timeStamp;
    copyShapes(shapes, this.shapes);
  }
  
  private static void copyShapes(List<Shape> shapes, List<Shape> copy) {
    copy.clear(); //clear copy list first to ensure empty.
    for (Shape shape : shapes) { //make a deep copy of the shapes
      copy.add(shape.copy());
    }
  }
  
  /**
   * Get the ID of the snapshot.
   * @return the ID of the snapshot
   */
  @Override
  public String getID() {
    SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    
    try {
      Date date = inputFormat.parse(timeStamp);
      String formattedTimeStamp = outputFormat.format(date);
      return formattedTimeStamp + "." + id;
    } catch (ParseException e) {
      e.printStackTrace();
      return null;
    }
  }
  
  /**
   * Get the timestamp of the snapshot.
   * @return the timestamp of the snapshot
   */
  @Override
  public String getTimeStamp() {
    return this.timeStamp;
  }
  
  /**
   * Get the description of the snapshot.
   * @return the description of the snapshot
   */
  @Override
  public String getDescription() {
    return this.description;
  }
  
  /**
   * Set the description of the snapshot.
   * @param newDescription the description of the snapshot
   */
  @Override
  public void setDescription(String newDescription) {
    this.description = newDescription;
  }
  
  /**
   * Get the shapes of the snapshot.
   * @return the shapes of the snapshot
   */
  @Override
  public List<Shape> getShapes() {
    return this.shapes;
  }
  
  /**
   * Get the string representation of the snapshot.
   * @return the string representation of the snapshot
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
  
    for (Shape shape : shapes) {
      builder.append(shape.toString()).append("\n");
    }
    return String.format("Snapshot ID: %s\n"
                    + "Timestamp: %s\n"
                    + "Description: %s\n"
                    + "Shape Information:\n"
                    + "%s",
            getID(), timeStamp, description, builder);
  }
}
