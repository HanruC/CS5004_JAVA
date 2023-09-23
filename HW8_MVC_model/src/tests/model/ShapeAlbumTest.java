package tests.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import model.ShapeAlbum;
import org.junit.Before;
import org.junit.Test;
import shape.Oval;
import shape.Rectangle;
import shape.Shape;
import snapshot.Snapshot;

import java.util.List;

/**
 * Test class for ShapeAlbum.
 */
public class ShapeAlbumTest {
  private ShapeAlbum shapeAlbum;
  
  /**
   * Set up for testing.
   */
  @Before
  public void setUp() {
    shapeAlbum = ShapeAlbum.getInstance();
    shapeAlbum.reboot();
  }
  
  /**
   * Test for createShape method.
   */
  @Test
  public void testCreateShape() {
    assertTrue(shapeAlbum.createShape("Oval", "o1", 5,
            10, 0.5, 0.7, 0.9, 20, 30));
    assertFalse(shapeAlbum.createShape("InvalidType", "i1",
            5, 10, 0.5, 0.7, 0.9, 20, 30));
  }
  
  /**
   * Test for addShape method.
   */
  @Test
  public void testAddShape() {
    assertTrue(shapeAlbum.getShapeListWithAll().isEmpty());
    
    Shape oval = new Oval("oval1", 10.0, 20.0,
            100, 150, 200, 50.0, 80.0);
    shapeAlbum.addShape(oval);
    assertEquals(1, shapeAlbum.getShapeListWithAll().size());
    assertEquals(oval, shapeAlbum.getShape("oval1"));
    
    Shape rectangle = new Rectangle("rectangle1", 30.0,
            40.0, 50, 100, 150, 70.0, 90.0);
    shapeAlbum.addShape(rectangle);
    assertEquals(2, shapeAlbum.getShapeListWithAll().size());
    assertEquals(rectangle, shapeAlbum.getShape("rectangle1"));
  }
  
  /**
   * Test for removeShape method.
   */
  @Test
  public void testRemoveShapeAndCheck() {
    shapeAlbum.createShape("Oval", "o1", 5, 10,
            0.5, 0.7, 0.9, 20, 30);
    boolean result = shapeAlbum.removeShapeAndCheck("o1");
    assertTrue(result);
    assertNull(shapeAlbum.getShape("o1"));
  }
  
  /**
   * Test for checkIfNameExist method.
   */
  @Test
  public void testCheckIfNameExist() {
    assertFalse(shapeAlbum.checkIfNameExist("oval1"));
    assertFalse(shapeAlbum.checkIfNameExist("rectangle1"));
    
    shapeAlbum.createShape("Oval", "oval1", 10.0,
            20.0, 100, 150, 200, 50.0, 80.0);
    assertTrue(shapeAlbum.checkIfNameExist("oval1"));
    assertFalse(shapeAlbum.checkIfNameExist("rectangle1"));
    
    shapeAlbum.createShape("Rectangle", "rectangle1",
            30.0, 40.0, 50, 100, 150, 70.0, 90.0);
    assertTrue(shapeAlbum.checkIfNameExist("oval1"));
    assertTrue(shapeAlbum.checkIfNameExist("rectangle1"));
  }
  
  /**
   * Test for create snapshot method.
   * Also checking if the id is the same in both lists.
   */
  @Test
  public void testCreateSnapshot() {
    shapeAlbum.createShape("Oval", "o1", 5, 10,
            0.5, 0.7, 0.9, 20, 30);
    shapeAlbum.createSnapshot("first snapshot");
    
    List<Snapshot> snapshots = shapeAlbum.getSnapshots();
    assertEquals(1, snapshots.size());
    assertNotNull(snapshots.get(0).getID());
    assertFalse(shapeAlbum.getIdList().isEmpty());
    assertEquals(1, shapeAlbum.getIdList().size());
    assertEquals(snapshots.get(0).getID(), shapeAlbum.getIdList().get(0));
    //check if the id is the same in both lists.
  }
  
  /**
   * Test for getSnapshot method.
   */
  @Test
  public void testGetSnapshot() {
    shapeAlbum.createShape("Oval", "o1", 5, 10, 0.5,
            0.7, 0.9, 20, 30);
    shapeAlbum.createSnapshot("first snapshot");
    String snapshotId = shapeAlbum.getSnapshots().get(0).getID();
    
    Snapshot snapshot = shapeAlbum.getSnapshot(snapshotId);
    assertNotNull(snapshot);
    assertEquals("first snapshot", snapshot.getDescription());
    assertEquals(1, snapshot.getShapes().size());
  }
  
  /**
   * Test for getSnapshot method with invalid id.
   */
  @Test
  public void testGetSnapshotWithInvalidId() {
    assertNull(shapeAlbum.getSnapshot("invalid_id"));
  }
  
  /**
   * Test for move shape method and check if the shape is moved.
   */
  @Test
  public void testMoveShapeAndCheck() {
    shapeAlbum.createShape("Oval", "o1", 5, 10,
            0.5, 0.7, 0.9, 20, 30);
    assertTrue(shapeAlbum.moveShapeAndCheck("o1", 3, 4));
    
    Shape shape = shapeAlbum.getShape("o1");
    assertNotNull(shape);
    assertEquals(3.0, shape.getX(), 0.0001);
    assertEquals(4.0, shape.getY(), 0.0001);
  }
  
  /**
   * Test for move shape method with invalid name. Edge cases.
   */
  @Test
  public void testMoveShapeAndCheckWithInvalidName() {
    assertFalse(shapeAlbum.moveShapeAndCheck("invalid_name", 3, 4));
  }
  
  /**
   * Test for move shape method with invalid color value. Edge cases.
   */
  @Test
  public void testCreateShapeWithInvalidColorValues() {
    assertFalse(shapeAlbum.createShape("Oval", "o1", 5, 10,
            -0.5, 256, 0.9, 20, 30));
    assertFalse(shapeAlbum.createShape("Oval", "o1", 5, 10,
            -0.5, 254, 0.9, 20, 30));
  }
  
  /**
   * Test for move shape method with valid color value. Edge cases.
   */
  @Test
  public void testCreateShapeWithValidColorValues() {
    assertTrue(shapeAlbum.createShape("Oval", "o1", 5, 10,
            100, 150, 200, 20, 30));
  }
  
  /**
   * Test for resize shape method and check if the shape is resized.
   */
  @Test
  public void testResizeShapeAndCheck() {
    shapeAlbum.createShape("Oval", "o1", 5,
            10, 0.5, 0.7, 0.9, 20, 30);
    assertTrue(shapeAlbum.resizeShapeAndCheck("o1", 25, 35));
    
    Shape shape = shapeAlbum.getShape("o1");
    assertNotNull(shape);
    String expected = "Name: o1\n"
            + "Type: Oval\n"
            + "Center: (0.7, 0.9)\n"
            + "X radius: 25.0\n"
            + "Y radius: 35.0\n"
            + "Color: (5.0, 10.0, 0.5)\n";
    assertEquals(expected, shape.toString());
  }
  
  /**
   * Test for resize shape method with invalid name. Edge cases.
   */
  @Test
  public void testResizeShapeAndCheckWithInvalidName() {
    assertFalse(shapeAlbum.resizeShapeAndCheck("invalid_name", 25, 35));
  }
  
  /**
   * Test for change color method and check if the color is changed.
   */
  @Test
  public void testChangeColorAndCheck() {
    shapeAlbum.createShape("Oval", "o1", 5, 10, 0.5, 0.7,
            0.9, 20, 30);
    assertTrue(shapeAlbum.changeColorAndCheck("o1", 0.2, 0.8, 0.1));
    
    Shape shape = shapeAlbum.getShape("o1");
    assertNotNull(shape);
    assertEquals(0.2, shape.getRed(), 0.0001);
    assertEquals(0.8, shape.getGreen(), 0.0001);
    assertEquals(0.1, shape.getBlue(), 0.0001);
  }
  
  /**
   * Test for change color method with invalid name. Edge cases.
   */
  @Test
  public void testChangeColorAndCheckWithInvalidName() {
    assertFalse(shapeAlbum.changeColorAndCheck("invalid_name",
            0.2, 0.8, 0.1));
  }
  
  /**
   * Test for toString method.
   */
  @Test
  public void testToString() {
    ShapeAlbum shapeAlbum = ShapeAlbum.getInstance();
    shapeAlbum.reboot();
    shapeAlbum.createShape("Oval", "o1", 5, 10, 0.5,
            0.7, 0.9, 20, 30);
    shapeAlbum.createShape("Rectangle", "r1", 15, 20, 0.3,
            0.4, 0.5, 50, 70);
    shapeAlbum.createSnapshot("first snapshot");
    shapeAlbum.createSnapshot("second snapshot");
  
    String expectedString = "************** Shape Album **************\n"
            + "Shapes:\n"
            + "- Name: o1\nType: Oval\nCenter: (0.7, 0.9)\nX radius: 20.0\nY radius: 30.0\n"
            + "Color: (5.0, 10.0, 0.5)\n\n"
            + "- Name: r1\nType: Rectangle\nMin corner: (0.4, 0.5)\nWidth: 50.0\nHeight: 70.0\n"
            + "Color: (15.0, 20.0, 0.3)\n\n\n"
            + "Snapshots:\n"
            + "- Snapshot ID: " + shapeAlbum.getSnapshots().get(0).getID() + "\n"
            + "Timestamp: " + shapeAlbum.getSnapshots().get(0).getTimeStamp() + "\n"
            + "Description: first snapshot\nShape Information:\n"
            + "Name: o1\nType: Oval\nCenter: (0.7, 0.9)\nX radius: 20.0\nY radius: 30.0\n"
            + "Color: (5.0, 10.0, 0.5)\n\n"
            + "Name: r1\nType: Rectangle\nMin corner: (0.4, 0.5)\nWidth: 50.0\nHeight: 70.0\n"
            + "Color: (15.0, 20.0, 0.3)\n\n\n"
            + "- Snapshot ID: " + shapeAlbum.getSnapshots().get(1).getID() + "\n"
            + "Timestamp: " + shapeAlbum.getSnapshots().get(1).getTimeStamp() + "\n"
            + "Description: second snapshot\nShape Information:\n"
            + "Name: o1\nType: Oval\nCenter: (0.7, 0.9)\nX radius: 20.0\nY radius: 30.0\n"
            + "Color: (5.0, 10.0, 0.5)\n\n"
            + "Name: r1\nType: Rectangle\nMin corner: (0.4, 0.5)\nWidth: 50.0\nHeight: 70.0\n"
            + "Color: (15.0, 20.0, 0.3)\n\n\n";
    assertEquals(expectedString, shapeAlbum.toString());
  }
  
  
}
