package view;

/**
 * Interface for the web view.
 */
public interface IWebView {
  
  /**
   * Renders the view.
   * @param out the output stream
   * @param frameWidth the width of the frame
   * @param frameHeight the height of the frame
   */
  void go(Appendable out, int frameWidth, int frameHeight);
}
