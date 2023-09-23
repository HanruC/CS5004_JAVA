package controller;

import model.IAlbum;
import model.ShapeAlbum;

import java.io.IOException;
import java.util.Scanner;

public class ShapeAlbumController implements IController {
  private static final IController INSTANCE = new ShapeAlbumController();
  private final IAlbum model;
  private Readable in;
  private Appendable out;
  private Scanner scan;
  
  private ShapeAlbumController() {
    this.model = ShapeAlbum.getInstance();
  }
  
  public static IController getInstance() {
    return INSTANCE;
  }
  
  @Override
  public void run(Readable in, Appendable out, int x, int y) {
    this.in = in;
    this.out = out;
    scan = new Scanner(in);
    takeTokens();
  }
  
  private void takeTokens() {
    while (scan.hasNextLine()) {
      String line = scan.nextLine().trim();
      if (line.length() == 0 || line.startsWith("#")) {
        continue;
      }
      String[] tokens = line.split("\\s+");
      switch (tokens[0].toLowerCase()) {
        case "add":
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
        case "snap":
          takeSnapShot(tokens);
          break;
        default:
          System.out.println("Invalid token");
      }
    }
  }
  private void addShape(String[] tokens) throws IllegalArgumentException {
    try {
      String name = tokens[1];
      String type = tokens[2].toLowerCase();
      double x = Double.parseDouble(tokens[3]);
      double y = Double.parseDouble(tokens[4]);
      double red = Double.parseDouble(tokens[5]);
      double green = Double.parseDouble(tokens[6]);
      double blue = Double.parseDouble(tokens[7]);
      double firstParameter = Double.parseDouble(tokens[8]);
      double secondParameter = Double.parseDouble(tokens[9]);
      
      if (model.createShape(type, name, x, y, red, green, blue, firstParameter, secondParameter)) {
        out.append("Successfully added\n");
      } else {
        out.append("Failed to add shape\n");
        throw new IllegalArgumentException("Failed to add shape");
      }
    } catch (IOException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
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
      double red = Double.parseDouble(tokens[2]);
      double green = Double.parseDouble(tokens[3]);
      double blue = Double.parseDouble(tokens[4]);
      
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
    try {
      String description = tokens[1];
      model.createSnapshot(description);
      out.append("Successfully created snapshot\n");
    } catch (IOException | ArrayIndexOutOfBoundsException e) {
      System.out.println("Error occurs: " + e.getMessage());
    }
  }

}