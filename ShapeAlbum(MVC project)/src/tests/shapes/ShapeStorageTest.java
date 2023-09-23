package tests.shapes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import shape.Oval;
import shape.Shape;
import shape.ShapeStorage;

/**
 * Test class for ShapeStorage.
 */
public class ShapeStorageTest {
  private ShapeStorage shapeStorage;
  private Oval oval1;
  
  /**
   * Set up for testing.
   */
  @Before
  public void setUp() {
    shapeStorage = new ShapeStorage();
    oval1 = new Oval("o1", 5, 10,
            5, 0.7, 0.9, 20, 30);
  }
  
  /**
   * Test for ShapeStorage constructor.
   */
  @Test
  public void testAddOvalToShapeStorage() {
    int initialSize = shapeStorage.getSize();
    oval1.addToShapeStorage(shapeStorage);
    int newSize = shapeStorage.getSize();
    
    assertEquals(initialSize + 1, newSize);
    Shape lastAddedShape = shapeStorage.getShape(newSize - 1);
    assertTrue(lastAddedShape instanceof Oval);
    
    Oval addedOval = (Oval) lastAddedShape;
    assertEquals("o1", addedOval.getName());
    assertEquals(0.7, addedOval.getX(), 0.001);
    assertEquals(0.9, addedOval.getY(), 0.001);
    assertEquals(5, addedOval.getRed(), 0.001);
    assertEquals(10, addedOval.getGreen(), 0.001);
    assertEquals(0.5, addedOval.getBlue(), 0.001);
    assertEquals(20, addedOval.getXRadius(), 0.001);
    assertEquals(30, addedOval.getYRadius(), 0.001);
  }
}
