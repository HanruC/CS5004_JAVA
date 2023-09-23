package tests.snapshot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import shape.Oval;
import shape.Shape;
import snapshot.Snapshot;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class for Snapshot.
 */
public class SnapshotTest {
  private Snapshot snapshot;
  private List<Shape> shapes;
  private final long id = 19980817;
  private final String timeStamp = "17-08-2022 12:30:00";
  private final String description = "first Snapshot";
  
  /**
   * Set up for testing.
   */
  @Before
  public void setUp() {
    shapes = new ArrayList<>();
    shapes.add(new Oval("o1", 5, 10, 5,
            0.7, 0.9, 20, 30));
    
    snapshot = new Snapshot(id, timeStamp, description, shapes);
  }
  
  /**
   * Test for getID. ID should not be null.
   */
  @Test
  public void testGetID() {
    assertEquals("2022-08-17T12:30:00.19980817", snapshot.getID());
    assertNotNull(snapshot.getID());
  }
  
  /**
   * Test for getTimeStamp.
   */
  @Test
  public void testGetTimeStamp() {
    assertEquals(timeStamp, snapshot.getTimeStamp());
  }
  
  /**
   * Test for getDescription.
   */
  @Test
  public void testGetDescription() {
    assertEquals(description, snapshot.getDescription());
  }
  
  /**
   * Test for setDescription.
   */
  @Test
  public void testSetDescription() {
    String newDescription = "New Snapshot Description for first snapshot";
    snapshot.setDescription(newDescription);
    assertEquals(newDescription, snapshot.getDescription());
  }
  
  /**
   * Test for getShapes. Comparing size of shapes list and snapshot's shapes list.
   */
  @Test
  public void testGetShapes() {
    List<Shape> snapshotShapes = snapshot.getShapes();
    assertNotNull(snapshotShapes);
    assertEquals(shapes.size(), snapshotShapes.size());
    
    for (int i = 0; i < shapes.size(); i++) {
      Shape originalShape = shapes.get(i);
      Shape snapshotShape = snapshotShapes.get(i);
      assertEquals(originalShape.toString(), snapshotShape.toString());
    }
  }
  
  /**
   * Test for toString method.
   */
  @Test
  public void testToString() {
    String expected = String.format("Snapshot ID: %s\nTimestamp: %s\n"
                    + "Description: %s\nShape Information:\n%s\n",
            snapshot.getID(), timeStamp, description, shapes.get(0).toString());
    assertEquals(expected, snapshot.toString());
  }
  
}
