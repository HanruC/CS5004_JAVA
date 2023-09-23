package view;

import controller.IController;
import controller.ShapeAlbumController;
import model.IAlbum;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * This class represents the graphical view of the ShapeAlbum application. It implements the
 */
public class GraphicalView implements IGraphicalView {
  private static final IGraphicalView INSTANCE = new GraphicalView();
  
  private GraphicalView() {
  }
  
  /**
   * This method returns the instance of the graphical view.
   * @return the instance of the graphical view
   */
  public static IGraphicalView getInstance() {
    return INSTANCE;
  }
  
  /**
   * This method creates and shows the GUI.
   * @param frameWidth - the width of the frame
   * @param frameHeight - the height of the frame
   * @param albumModel - the album model
   */
  @Override
  public void go(int frameWidth, int frameHeight, IAlbum albumModel) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI(frameWidth, frameHeight, albumModel);
      }
    });
  }
  
  private void createAndShowGUI(int frameWidth, int frameHeight, IAlbum albumModel) {
    IController controller = ShapeAlbumController.getInstance();
    CustomGraphicsFrame customGraphicsFrame = new CustomGraphicsFrame(albumModel, frameWidth,
            frameHeight, controller);
    controller.setCustomGraphicsFrame(customGraphicsFrame);
    customGraphicsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    customGraphicsFrame.setSize(frameWidth, frameHeight);
  }
}
