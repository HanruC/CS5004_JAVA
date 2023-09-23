package view;

import snapshot.ISnapshot;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

/**
 * This class represents a custom snapshot panel that is used to display a snapshot in the GUI.
 */
public class CustomSnapshotPanel extends JPanel {
  private ISnapshot snapshot;
  private final int panelWidth;
  private final int panelHeight;
  
  private final GridBagLayout gridBagLayout = new GridBagLayout();
  private final GridBagConstraints gridBagConstraints = new GridBagConstraints();
  
  /**
   * Constructor for the custom snapshot panel.
   * @param snapshot the snapshot to be displayed
   * @param panelWidth the width of the panel
   * @param panelHeight the height of the panel
   */
  public CustomSnapshotPanel(ISnapshot snapshot, int panelWidth, int panelHeight) {
    super();
    this.panelWidth = panelWidth;
    this.panelHeight = panelHeight;
    this.snapshot = snapshot;
  
    setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    drawLabelPanel();
    drawShapePanel();
  }
  
  private void drawLabelPanel() {
    JPanel labelPanel = new JPanel();
    labelPanel.setBackground(Color.WHITE);
    labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.PAGE_AXIS));
    
    JLabel idLabel = new JLabel(snapshot.getID());
    labelPanel.add(idLabel);
    
    if (!snapshot.getDescription().equals("")) {
      JLabel descriptionLabel = new JLabel(snapshot.getDescription());
      labelPanel.add(descriptionLabel);
    }
    add(labelPanel);
  }
  
  private void drawShapePanel() {
    JPanel shapePanel = new JPanel() {
      @Override
      public void paint(Graphics g) {
        for (shape.Shape shape : snapshot.getShapes()) {
          g.setColor(new Color(
                  (int) shape.getRed(),
                  (int) shape.getGreen(),
                  (int) shape.getBlue()));
          int posX = (int) shape.getX();
          int posY = (int) shape.getY();
          
          if (shape.getType().equals("Rectangle")) {
            shape.Rectangle rectangle = (shape.Rectangle) shape;
            int width = (int) rectangle.getWidth();
            int height = (int) rectangle.getHeight();
            g.fillRect(posX, posY, width, height);
          } else { // assuming this is an Oval shape
            shape.Oval oval = (shape.Oval) shape;
            int xRadius = (int) oval.getXRadius();
            int yRadius = (int) oval.getYRadius();
            g.fillOval(posX, posY, xRadius, yRadius);
          }
        }
      }
    };
    shapePanel.setBackground(Color.BLUE);
    shapePanel.setPreferredSize(new Dimension(panelWidth, panelHeight));
    shapePanel.setMaximumSize(new Dimension(panelWidth, panelHeight));
    
    add(shapePanel);
  }
  
  /**
   * Gets the ID of the snapshot.
   * @return the ID of the snapshot
   */
  public String getID() {
    return snapshot.getID();
  }
}
