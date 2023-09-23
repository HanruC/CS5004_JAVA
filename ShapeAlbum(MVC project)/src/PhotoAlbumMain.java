import controller.IController;
import controller.ShapeAlbumController;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class represents the main class for the photo album program.
 */
public class PhotoAlbumMain {
  
  /**
   * This is the main method for the photo album program.
   * @param args the command line arguments
   * @throws IllegalArgumentException if the arguments are invalid
   */
  public static void main(String[] args) throws IllegalArgumentException {
    String view = "";
    String in = "";
    String out = "buildingsOut.html";
    int xMax = 1000;
    int yMax = 1000;
    
    for (int i = 0; i < args.length; i++) {
      switch (args[i].toLowerCase()) {
        case "-v":
        case "-view":
          view = args[++i];
          break;
        case "-in":
          in = args[++i];
          break;
        case "-out":
          out = args[++i];
          break;
        default:
          try {
            int value = Integer.parseInt(args[i]);
            if (value > 0) {
              xMax = value;
              yMax = Integer.parseInt(args[++i]);
            }
          } catch (NumberFormatException ignored) {
          }
          break;
      }
    }
    
    if (in.isEmpty() || view.isEmpty()) {
      System.err.println("Error: -in and -view arguments are mandatory.");
      return;
    }
    
    if (view.equalsIgnoreCase("web") && out.isEmpty()) {
      System.err.println("Error: -out argument is required for web view.");
      return;
    }
    
    execute(view, in, out, xMax, yMax);
  }
  
  private static void execute(String view, String inputFile, String outputFile,
                              int frameWidth, int frameHeight) {
    IController controller = ShapeAlbumController.getInstance();
    
    try (FileReader input = new FileReader(inputFile)) {
      if (view.equalsIgnoreCase("web")) {
        if (!outputFile.isEmpty()) {
          try (FileWriter output = new FileWriter(outputFile)) {
            controller.run(input, output, frameWidth, frameHeight);
          }
        } else {
          controller.run(input, System.out, frameWidth, frameHeight);
        }
      } else { // assuming graphical view
        controller.run(input, null, frameWidth, frameHeight);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}