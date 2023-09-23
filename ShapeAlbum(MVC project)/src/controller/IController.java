package controller;

import view.CustomGraphicsFrame;

/**
 * Controller interface which includes several methods that should be implemented.
 */
public interface IController {
  
  /**
   * Method for showing the graphical view.
   * @param frameWidth Width of the frame
   * @param frameHeight Height of the frame
   */
  void showGraphicalView(int frameWidth, int frameHeight);
  
  /**
   * Run method for the controller.
   * @param in Readable
   * @param out Appendable
   * @param x X coordinate
   * @param y Y coordinate
   */
  void run(Readable in, Appendable out, int x, int y);
  
  /**
   * Method for showing the text view.
   * @param frameWidth Width of the frame
   * @param frameHeight Height of the frame
   * @param out Appendable
   */
  void showWebView(int frameWidth, int frameHeight, Appendable out);
  
  /**
   * Method for setting the custom graphics frame.
   * @param customGraphicsFrame Custom graphics frame
   */
  void setCustomGraphicsFrame(CustomGraphicsFrame customGraphicsFrame);
  
  /**
   * Previous button action.
   */
  void previousButtonAction();
  
  /**
   * Next button action.
   */
  void nextButtonAction();
  
  /**
   * Quit button action.
   */
  void quitButtonAction();
}
