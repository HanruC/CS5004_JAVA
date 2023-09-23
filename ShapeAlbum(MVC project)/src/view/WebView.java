package view;

import model.IAlbum;
import model.ShapeAlbum;
import shape.Shape;
import snapshot.Snapshot;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Class for the web view.
 */
public class WebView implements IWebView {
  private static final IWebView INSTANCE = new WebView();
  private final IAlbum albumModel;
  private Appendable out;
  private int frameWidth;
  private int frameHeight;
  
  private WebView() {
    this.albumModel = ShapeAlbum.getInstance();
  }
  
  /**
   * Returns the instance of the web view.
   * @return the instance of the web view
   */
  public static IWebView getInstance() {
    return INSTANCE;
  }
  
  /**
   * Renders the view.
   * @param out the output stream
   * @param frameWidth the width of the frame
   * @param frameHeight the height of the frame
   */
  @Override
  public void go(Appendable out, int frameWidth, int frameHeight) {
    this.out = out;
    this.frameWidth = frameWidth;
    this.frameHeight = frameHeight;
    Head();
    Body();
    try {
      if (out instanceof FileWriter) {
        ((FileWriter) out).flush();
      }
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassCastException ignore) {
      // Ignore the exception because no need to flush if Appendable is not a FileWriter
    }
  }
  
  private void cssFormatting() {
    try {
      out.append("<style>\n");
      out.append(".snapshot-storage {\n"
              + "  background-color: white;\n"
              + "  padding: 20px;\n"
              + "  margin: 20px;\n"
              + "}\n");
      out.append(".snapshot-title {\n"
              + "  font-size: 24px;\n"
              + "  margin-bottom: 10px;\n"
              + "}\n");
      out.append(".snapshot-description {\n"
              + "  font-size: 18px;\n"
              + "  margin-bottom: 20px;\n"
              + "}\n");
      out.append("</style>\n");
    } catch (IOException e) {
      System.err.println("Error: " + e.getMessage());
    }
  }
  
  private void Head() {
    try {
      out.append("<!DOCTYPE html>\n")
              .append("<html lang=\"en\">\n")
              .append("<head>\n")
              .append("    <meta charset=\"UTF-8\">\n")
              .append("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n")
              .append("    <meta name=\"viewport\" content=\"width=device-width, "
                      + "initial-scale=1.0\">\n")
              .append("    <title>Shapes Album</title>\n");
      cssFormatting();
      out.append("</head>\n");
    } catch (IOException e) {
      System.err.println("Error: " + e.getMessage());
    }
  }
  
  private void Body() {
    try {
      out.append("<body>\n")
              .append("<h1>Shapes Album</h1>\n");
      for (Snapshot snapshot : albumModel.getSnapshots()) {
        createSnapshotStorage(snapshot);
      }
      out.append("</body>\n")
              .append("</html>\n");
    } catch (IOException e) {
      System.err.println("Error: " + e.getMessage());
    }
  }
  
  private void createSnapshotStorage(Snapshot snapshot) {
    try {
      out.append(String.format("<div class=\"snapshot-storage\">\n"
              + "  <h2 class=\"snapshot-title\">%s</h2>\n", snapshot.getID()));
      if (!snapshot.getDescription().equals("")) {
        out.append(String.format("  <h3 class=\"snapshot-description\">%s</h3>\n",
                snapshot.getDescription()));
      }
      out.append(String.format("  <svg width=\"%d\" height=\"%d\">\n", frameWidth, frameHeight));
      for (Shape shape : snapshot.getShapes()) {
        out.append(shape.toSVGString());
      }
      out.append("  </svg>\n"
              + "</div>\n");
    } catch (IOException e) {
      System.err.println("Error: " + e.getMessage());
    }
  }
}
