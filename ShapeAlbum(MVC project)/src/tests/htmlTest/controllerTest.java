package tests.htmlTest;

import controller.IController;
import controller.ShapeAlbumController;
import model.IAlbum;
import model.ShapeAlbum;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.StringReader;

import static org.junit.Assert.assertEquals;

/**
 * The test class for the controller.
 */
public class controllerTest {
  private final IAlbum model = ShapeAlbum.getInstance();
  private final IController controller = ShapeAlbumController.getInstance();
  private Readable in;
  private Appendable out;
  private int xMax;
  private int yMax;
  
  /**
   * The rule for expected exception.
   */
  @Rule
  public final ExpectedException exception = ExpectedException.none();
  
  /**
   * Set up the test.
   */
  @Before
  public void setUp() {
    model.reboot();
    xMax = 1000;
    yMax = 1000;
  }
  
  /**
   * Test the read method.
   */
  @Test
  public void testRead() {
    in = new StringReader("# Make a rectangle and oval. Color red and green\n"
            + "    shape   myrect0   rectangle  200  200 50  100  255  0  0\n"
            + "    shape   myoval0   oval       500  100 60  30   0 255 1\n"
            + "\n"
            + "# Take a snapshot. Optional description text follows snapshot command\n"
            + "    snapshot After first selfie\n");
    out = new StringBuilder();
    controller.run(in, out, xMax, yMax);
    assertEquals(String.format("<!DOCTYPE html>\n"
                    + "<html lang=\"en\">\n"
                    + "<head>\n"
                    + "    <meta charset=\"UTF-8\">\n"
                    + "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                    + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1"
                    + ".0\">\n"
                    + "    <title>Shapes Album</title>\n"
                    + "<style>\n"
                    + ".snapshot-storage {\n"
                    + "  background-color: white;\n"
                    + "  padding: 20px;\n"
                    + "  margin: 20px;\n"
                    + "}\n"
                    + ".snapshot-title {\n"
                    + "  font-size: 24px;\n"
                    + "  margin-bottom: 10px;\n"
                    + "}\n"
                    + ".snapshot-description {\n"
                    + "  font-size: 18px;\n"
                    + "  margin-bottom: 20px;\n"
                    + "}\n"
                    + "</style>\n"
                    + "</head>\n"
                    + "<body>\n"
                    + "<h1>Shapes Album</h1>\n"
                    + "<div class=\"snapshot-storage\">\n"
                    + "  <h2 class=\"snapshot-title\">%s</h2>\n"
                    + "  <h3 class=\"snapshot-description\">After first selfie</h3>\n"
                    + "  <svg width=\"1000\" height=\"1000\">\n"
                    + "    <rect x=\"200\" y=\"200\" width=\"50\" height=\"100\" fill=\"rgb(255, "
                    + "0, 0)\" />\n"
                    + "    <ellipse cx=\"500\" cy=\"100\" rx=\"60\" ry=\"30\" fill=\"rgb(0, 255, "
                    + "1)\" />\n"
                    + "  </svg>\n"
                    + "</div>\n"
                    + "</body>\n"
                    + "</html>\n",
            model.getSnapshots().get(0).getID()), out.toString());
  }
  
  /**
   * Test empty input.
   */
  @Test
  public void testEmptyInput() {
    in = new StringReader("");
    out = new StringBuilder();
    controller.run(in, out, xMax, yMax);
  }
  
  /**
   * Test invalid shape type.
   */
  @Test
  public void testInvalidShapeType() {
    in = new StringReader("shape myinvalidshape invalidtype 50 50 100 100 0 0 255");
    out = new StringBuilder();
    exception.expect(IllegalArgumentException.class);
    controller.run(in, out, xMax, yMax);
  }
  
  /**
   * Test invalid shape name.
   */
  @Test
  public void EdgeCaseNoneExistenceShape() {
    exception.expect(IllegalArgumentException.class);
    exception.expectMessage("Failed to move");
    in = new StringReader("shape rect1 rectangle 200 200 50 100 255 0 0\n"
            + "shape oval1 oval 500 100 60 30 0 255 1\n"
            + "snapshot First snapshot\n"
            + "move nonExistentRect 300 200");
    out = new StringBuilder();
    controller.run(in, out, xMax, yMax);
  }
  
  /**
   * Edge case for resize shape.
   */
  @Test
  public void testResizeShapeEdgeCaseWithNoShape() {
    exception.expect(IllegalArgumentException.class);
    exception.expectMessage("Failed to resize");
    in = new StringReader("shape rect2 rectangle 200 200 50 100 255 0 0\n"
            + "shape oval2 oval 500 100 60 30 0 255 1\n"
            + "snapshot Second snapshot\n"
            + "resize nonExistentRect 25 50");
    out = new StringBuilder();
    controller.run(in, out, xMax, yMax);
  }
  
  /**
   * Edge case for color shape.
   */
  @Test
  public void testColorShapeEdgeCaseWithNoShape() {
    exception.expect(IllegalArgumentException.class);
    exception.expectMessage("Failed to color");
    in = new StringReader("shape rect3 rectangle 200 200 50 100 255 0 0\n"
            + "shape oval3 oval 500 100 60 30 0 255 1\n"
            + "snapshot Third snapshot\n"
            + "color nonExistentRect 0 0 255");
    out = new StringBuilder();
    controller.run(in, out, xMax, yMax);
  }
  
  /**
   * Edge case for remove shape.
   */
  @Test
  public void testRemoveShapeNonExistent() {
    exception.expect(IllegalArgumentException.class);
    exception.expectMessage("Failed to remove");
    in = new StringReader("shape rect4 rectangle 200 200 50 100 255 0 0\n"
            + "shape oval4 oval 500 100 60 30 0 255 1\n"
            + "snapshot Fourth snapshot\n"
            + "remove nonExistentRect");
    out = new StringBuilder();
    controller.run(in, out, xMax, yMax);
  }
}


