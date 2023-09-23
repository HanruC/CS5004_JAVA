package view;

import model.IAlbum;

/**
 * This interface represents a graphical view of an album. It is responsible for
 */
public interface IGraphicalView {
  
  /**
   * This method is responsible for displaying the album in a graphical view.
   * @param frameWidth the width of the frame
   * @param frameHeight the height of the frame
   * @param albumModel the album model
   */
  void go(int frameWidth, int frameHeight, IAlbum albumModel);
}
