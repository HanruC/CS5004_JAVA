package tests.shapes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import shape.Oval;
import shape.Shape;



/**
 * Test class for Oval. Including all methods in Shape interface.
 */
public class OvalTest {
  private Oval oval1;
  
  /**
   * Set up for testing.
   */
  @Before
  public void setUp() {
    oval1 = new Oval("o1", 5, 10, 5, 0.7,
            0.9, 20.0, 30.0);
  }
  
  /**
   * Test for Oval constructor.
   */
  @Test
  public void testOvalCreation() {
    assertEquals("o1", oval1.getName());
    assertEquals(0.7, oval1.getX(), 0.001);
    assertEquals(0.9, oval1.getY(), 0.001);
    assertEquals(5.0, oval1.getRed(), 0.001);
    assertEquals(10.0, oval1.getGreen(), 0.001);
    assertEquals(5, oval1.getBlue(), 0.001);
    assertEquals(20.0, oval1.getXRadius(), 0.001);
    assertEquals(30.0, oval1.getYRadius(), 0.001);
  }
  
  /**
   * Test for Oval setters.
   */
  @Test
  public void testOvalSetters() {
    oval1.setX(15);
    oval1.setY(20);
    oval1.setRed(1);
    oval1.setGreen(2);
    oval1.setBlue(3);
    assertEquals(15, oval1.getX(), 0.001);
    assertEquals(20, oval1.getY(), 0.001);
    assertEquals(0.1, oval1.getRed(), 0.001);
    assertEquals(0.2, oval1.getGreen(), 0.001);
    assertEquals(0.3, oval1.getBlue(), 0.001);
  }
  
  /**
   * Test for setter name.
   */
  @Test
  public void testSetName() {
    String newName = "OvalNewName";
    oval1.setName(newName);
    assertEquals(newName, oval1.getName());
  }
  
  /**
   * Test for move method.
   */
  @Test
  public void testOvalMove() {
    oval1.move(5, -5);
    assertEquals(5, oval1.getX(), 0.001);
    assertEquals(-5, oval1.getY(), 0.001);
  }
  
  /**
   * Test for Oval copy method.
   */
  @Test
  public void testOvalCopy() {
    Shape copiedOval = oval1.copy();
    assertEquals(oval1.getName(), copiedOval.getName());
    assertEquals(oval1.getX(), copiedOval.getX(), 0.001);
    assertEquals(oval1.getY(), copiedOval.getY(), 0.001);
    assertEquals(oval1.getRed(), copiedOval.getRed(), 0.001);
    assertEquals(oval1.getGreen(), copiedOval.getGreen(), 0.001);
    assertEquals(oval1.getBlue(), copiedOval.getBlue(), 0.001);
    assertEquals(oval1.getXRadius(), ((Oval) copiedOval).getXRadius(), 0.001);
    assertEquals(oval1.getYRadius(), ((Oval) copiedOval).getYRadius(), 0.001);
    assertNotSame(oval1, copiedOval);
  }
  
  /**
   * Test for Oval resize method.
   * Including changeFirstParameter and changeSecondParameter.
   */
  @Test
  public void testOvalResize() {
    assertTrue(oval1.resize(15, 19));
    assertEquals(15, oval1.getXRadius(), 0.001);
    assertEquals(19, oval1.getYRadius(), 0.001);
  }
  
  /**
   * Test for Oval resize method. Invalid input.
   * Invalid input should not resize the Oval.
   */
  @Test
  public void testOvalResizeInvalid() {
    assertFalse(oval1.resize(-25, -35));
    assertEquals(20.0, oval1.getXRadius(), 0.001);
    assertEquals(30.0, oval1.getYRadius(), 0.001);
  }

  
  /**
   * Test for Oval change color method.
   * Successfully change the color.
   * Including changeRed, changeGreen and changeBlue.
   */
  @Test
  public void testOvalChangeThreeColor() {
    assertTrue(oval1.changeThreeColor(8, 6, 4));
    assertEquals(8, oval1.getRed(), 0.001);
    assertEquals(6, oval1.getGreen(), 0.001);
    assertEquals(4, oval1.getBlue(), 0.001);
  }
  
  /**
   * Test for Oval change color method. Invalid input.
   * Invalid input should not change the color.
   */
  @Test
  public void testOvalChangeThreeColorInvalid() {
    assertFalse(oval1.changeThreeColor(2, 1, 5));
    assertEquals(5.0 , oval1.getRed(), 0.001);
    assertEquals(10.0, oval1.getGreen(), 0.001);
    assertEquals(0.5, oval1.getBlue(), 0.001);
  }
  
  /**
   * Test for Oval negative parameters.
   * Should throw IllegalArgumentException.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testNegativeParameters() {
    Oval ovalInvalid = new Oval("o2", -5, -10, -5,
            -0.7, -0.9, -20, -30);
    assertEquals("o2", ovalInvalid.getName());
    assertEquals(-0.7, ovalInvalid.getX(), 0.001);
    assertEquals(-0.9, ovalInvalid.getY(), 0.001);
    assertEquals(-5, ovalInvalid.getRed(), 0.001);
    assertEquals(-10, ovalInvalid.getGreen(), 0.001);
    assertEquals(-0.5, ovalInvalid.getBlue(), 0.001);
    assertEquals(-20, ovalInvalid.getXRadius(), 0.001);
    assertEquals(-30, ovalInvalid.getYRadius(), 0.001);
  }
  
  /**
   * Test for Oval toString method. Make it visually clear.
   */
  @Test
  public void testToString() {
    assertEquals("Name: o1\n"
            + "Type: Oval\n"
            + "Center: (0.7, 0.9)\nX radius: 20.0\nY radius: 30.0\nColor: (5.0, 10.0, 0.5)\n",
            oval1.toString());
  }
}
