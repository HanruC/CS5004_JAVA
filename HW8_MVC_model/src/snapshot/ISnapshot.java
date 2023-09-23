package snapshot;

import shape.Shape;

import java.util.List;

/**
 * The interface of snapshot.
 */
public interface ISnapshot {
  
  /**
   * Get the ID of the snapshot.
   * @return the ID of the snapshot
   */
  String getID();
  
  /**
   * Get the timestamp of the snapshot.
   * @return the timestamp of the snapshot
   */
  String getTimeStamp();
  
  /**
   * Get the description of the snapshot.
   * @return the description of the snapshot
   */
  String getDescription();
  
  /**
   * Set the description of the snapshot.
   * @param description the description of the snapshot
   */
  void setDescription(String description);
  
  /**
   * Get the shapes of the snapshot.
   * @return the shapes of the snapshot
   */
  List<Shape> getShapes();
}
