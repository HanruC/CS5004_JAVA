package tests.htmlTest;

import static org.junit.Assert.assertEquals;

import model.IAlbum;
import model.ShapeAlbum;
import org.junit.Before;
import org.junit.Test;
import view.IWebView;
import view.WebView;

/**
 * Test class for the WebView class.
 */
public class viewTest {
  private final IAlbum model = ShapeAlbum.getInstance();
  private final IWebView view = WebView.getInstance();
  private Appendable out;
  
  /**
   * Set up the model before each test.
   */
  @Before
  public void setUp() {
    model.reboot();
  }
  
  /**
   * Test the view.
   */
  @Test
  public void testView() {
    model.createShape("rectangle", "R1", 5, 5, 0,
            128, 255, 15, 15);
    model.createSnapshot("initial");
    
    // Create an oval, move it and create a snapshot
    model.createShape("oval", "O1", 20, 20, 128,
            0, 128, 30, 30);
    model.moveShapeAndCheck("O1", 25, 25);
    model.createSnapshot("ovalMoved");
    
    // Resize the rectangle, change its color and create a snapshot
    model.resizeShapeAndCheck("R1", 20, 20);
    model.changeColorAndCheck("R1", 255, 128, 0);
    model.createSnapshot("rectangleModified");
    
    // Remove the oval and create a snapshot
    model.removeShapeAndCheck("O1");
    model.createSnapshot("ovalRemoved");
    
    out = new StringBuilder();
    view.go(out, 1000, 1000);
    
    String expectedInitial = "<rect x=\"5\" y=\"5\" width=\"15\" height=\"15\" "
            + "fill=\"rgb(0, 128, 255)\" />";
    String expectedOvalMoved = "<ellipse cx=\"25\" cy=\"25\" rx=\"30\" ry=\"30\" fill=\"rgb(128, "
            + "0, 128)\" />";
    String expectedRectangleModified = "<rect x=\"5\" y=\"5\" width=\"20\" "
            + "height=\"20\" fill=\"rgb(255, 128, 0)\" />";
    
    assertEquals(expectedInitial, model.getSnapshots().get(0).getShapes().get(0).toSVGString());
    assertEquals(expectedOvalMoved, model.getSnapshots().get(1).getShapes().get(1).toSVGString());
    assertEquals(expectedRectangleModified, model.getSnapshots()
            .get(2).getShapes().get(0).toSVGString());
    String expectedOvalRemoved = "";
    assertEquals(expectedOvalRemoved, model.getSnapshots()
            .get(3).getShapes().size() == 1 ? "" : "Error");
  }
}
