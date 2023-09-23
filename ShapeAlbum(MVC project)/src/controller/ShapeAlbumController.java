package controller;

import model.IAlbum;
import model.ShapeAlbum;
import view.CustomGraphicsFrame;
import view.GraphicalView;
import view.IGraphicalView;
import view.IWebView;
import view.WebView;

import javax.swing.JOptionPane;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class represents the controller of the ShapeAlbum program.
 */
public class ShapeAlbumController implements IController {
  private static final IController INSTANCE = new ShapeAlbumController();
  private final IAlbum model;
  private Readable in;
  private Appendable out;
  private Scanner scan;
  private CustomGraphicsFrame customGraphicsFrame;
  
  private ShapeAlbumController() {
    this.model = ShapeAlbum.getInstance();
  }
  
  /**
   * Get the instance of the controller.
   * @return the instance of the controller
   */
  public static IController getInstance() {
    return INSTANCE;
  }
  
  /**
   * Set the custom graphics frame.
   * @param customGraphicsFrame Custom graphics frame
   */
  @Override
  public void setCustomGraphicsFrame(CustomGraphicsFrame customGraphicsFrame) {
    this.customGraphicsFrame = customGraphicsFrame;
  }
  
  /**
   * Previous button action.
   */
  @Override
  public void previousButtonAction() {
    if (customGraphicsFrame.getCurrentSnapshotIndex() > 0) {
      customGraphicsFrame.decrementCurrentSnapshotIndex();
      customGraphicsFrame.displayCurrentSnapshot();
    } else {
      JOptionPane.showMessageDialog(null, "First snapshot!",
              "Error", JOptionPane.ERROR_MESSAGE);
    }
  }
  
  /**
   * Next button action.
   */
  @Override
  public void nextButtonAction() {
    if (customGraphicsFrame.getCurrentSnapshotIndex() < customGraphicsFrame.getAlbumModel()
            .getSnapshots().size() - 1) {
      customGraphicsFrame.addCurrentSnapshotIndex();
      customGraphicsFrame.displayCurrentSnapshot();
    } else {
      JOptionPane.showMessageDialog(null, "Last snapshot!",
              "Error", JOptionPane.ERROR_MESSAGE);
    }
  }
  
  /**
   * Quit button action.
   */
  @Override
  public void quitButtonAction() {
    customGraphicsFrame.setVisible(false);
    customGraphicsFrame.dispose();
  }
  
  /**
   * Run the program.
   * @param in Readable
   * @param out Appendable
   * @param x X coordinate
   * @param y Y coordinate
   */
  @Override
  public void run(Readable in, Appendable out, int x, int y) {
    this.in = in;
    this.out = out;
    scan = new Scanner(in);
    takeTokens();
    if (out == null) {
      showGraphicalView(x, y);
    } else {
      showWebView(x, y, out);
    }
  }
  
  private void takeTokens() {
    while (scan.hasNextLine()) {
      String line = scan.nextLine().trim();
      if (line.length() == 0 || line.startsWith("#")) {
        continue;
      }
      String[] tokens = line.split("\\s+");
      tokens[0] = tokens[0].toLowerCase();
      switch (tokens[0]) {
        case "shape":
          addShape(tokens);
          break;
        case "move":
          moveShape(tokens);
          break;
        case "remove":
          removeShape(tokens);
          break;
        case "color":
          colorShape(tokens);
          break;
        case "resize":
          resizeShape(tokens);
          break;
        case "snapshot":
          takeSnapShot(tokens);
          break;
        default:
          System.out.println("Invalid token");
      }
    }
  }
  
  /**
   * Show the graphical view.
   * @param frameWidth Width of the frame
   * @param frameHeight Height of the frame
   */
  @Override
  public void showGraphicalView(int frameWidth, int frameHeight) {
    IGraphicalView graphicalView = GraphicalView.getInstance();
    graphicalView.go(frameWidth, frameHeight, model);
  }
  
  /**
   * Show the web view.
   * @param frameWidth Width of the frame
   * @param frameHeight Height of the frame
   * @param out Appendable
   */
  @Override
  public void showWebView(int frameWidth, int frameHeight, Appendable out) {
    IWebView webView = WebView.getInstance();
    webView.go(out, frameWidth, frameHeight);
  }
  
  private void addShape(String[] tokens) throws IllegalArgumentException {
    try {
      String name = tokens[1];
      String type = tokens[2].toLowerCase();
      double x = Double.parseDouble(tokens[3]);
      double y = Double.parseDouble(tokens[4]);
      double firstParameter = Double.parseDouble(tokens[5]);
      double secondParameter = Double.parseDouble(tokens[6]);
      int red = Integer.parseInt(tokens[7]);
      int green = Integer.parseInt(tokens[8]);
      int blue = Integer.parseInt(tokens[9]);
  
      if (!model.createShape(type, name, x, y, red, green, blue, firstParameter, secondParameter)) {
        throw new IllegalArgumentException("Failed to add shape");
      }
    } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
        System.out.println("Error occurs: " + e.getMessage());
    }
  }
  
  private void moveShape(String[] tokens) throws IllegalArgumentException {
    try {
      String name = tokens[1];
      double moveX = Double.parseDouble(tokens[2]);
      double moveY = Double.parseDouble(tokens[3]);
      
      if (model.moveShapeAndCheck(name, moveX, moveY)) {
        out.append("Successfully moved\n");
      } else {
        out.append("Failed to move\n");
        throw new IllegalArgumentException("Failed to move");
      }
    } catch (IOException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
      System.out.println("Error occurs: " + e.getMessage());
    }
  }
  
  private void removeShape(String[] tokens) throws IllegalArgumentException {
    try {
      String name = tokens[1];
      if (model.removeShapeAndCheck(name)) {
        out.append("Successfully removed\n");
      } else {
        out.append("Failed to remove\n");
        throw new IllegalArgumentException("Failed to remove");
      }
    } catch (IOException | ArrayIndexOutOfBoundsException e) {
      System.out.println("Error occurs: " + e.getMessage());
    }
  }
  
  private void colorShape(String[] tokens) throws IllegalArgumentException {
    try {
      String name = tokens[1];
      int red = Integer.parseInt(tokens[2]);
      int green = Integer.parseInt(tokens[3]);
      int blue = Integer.parseInt(tokens[4]);
      
      if (model.changeColorAndCheck(name, red, green, blue)) {
        out.append("Successfully colored\n");
      } else {
        out.append("Failed to color\n");
        throw new IllegalArgumentException("Failed to color");
      }
    } catch (IOException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
      System.out.println("Error occurs: " + e.getMessage());
    }
  }
  
  private void resizeShape(String[] tokens) throws IllegalArgumentException {
    try {
      String name = tokens[1];
      double firstParameter = Double.parseDouble(tokens[2]);
      double secondParameter = Double.parseDouble(tokens[3]);
      
      if (model.resizeShapeAndCheck(name, firstParameter, secondParameter)) {
        out.append("Successfully resized\n");
      } else {
        out.append("Failed to resize\n");
        throw new IllegalArgumentException("Failed to resize");
      }
    } catch (IOException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
      System.out.println("Error occurs: " + e.getMessage());
    }
  }
  
  private void takeSnapShot(String[] tokens) throws IllegalArgumentException {
    String description = "";
    for (int i = 1; i < tokens.length; i++) {
      if (i != 1) {
        description = description + " ";
      }
      description = description + tokens[i];
    }
    model.createSnapshot(description);
  }


}