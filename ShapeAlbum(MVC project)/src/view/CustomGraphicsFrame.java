package view;

import controller.IController;
import model.IAlbum;
import snapshot.Snapshot;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * This class represents a custom graphics frame that displays the snapshots in the album.
 */
public class CustomGraphicsFrame extends JFrame {
  private final IAlbum albumModel;
  private final CardLayout cardLayout;
  private final JPanel snapshotsStorage;
  private int currentSnapshotIndex;
  private final IController controller;
  
  private final JPanel controlPanel = new JPanel();
  
  private final JButton previousButton = new JButton("<- Prev");
  private final JButton nextButton = new JButton("Next ->");
  private final JButton quitButton = new JButton("Quit xXx");
  
  /**
   * Constructs a custom graphics frame that displays the snapshots in the album.
   * @param albumModel the album model
   * @param frameWidth frame width
   * @param frameHeight frame height
   * @param controller the controller
   */
  public CustomGraphicsFrame(IAlbum albumModel, int frameWidth, int frameHeight,
                             IController controller) {
    super();
    this.controller = controller;
    this.albumModel = albumModel;
    this.cardLayout = new CardLayout();
    this.snapshotsStorage = new JPanel(cardLayout);
    
    setTitle("Shape Album");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    
    initializeSnapshotsStorage();
    initializeControlPanel();
    
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }
  
  /**
   * Gets the current snapshot index.
   * @return the current snapshot index
   */
  public int getCurrentSnapshotIndex() {
    return this.currentSnapshotIndex;
  }
  
  /**
   * Gets the album model.
   * @return the album model
   */
  public IAlbum getAlbumModel() {
    return this.albumModel;
  }
  
  /**
   * Adds the current snapshot index.
   */
  public void addCurrentSnapshotIndex() {
    this.currentSnapshotIndex++;
  }
  
  /**
   * Decrements the current snapshot index.
   */
  public void decrementCurrentSnapshotIndex() {
    this.currentSnapshotIndex--;
  }
  
  private void initializeSnapshotsStorage() {
    snapshotsStorage.setBackground(Color.PINK);
    List<Snapshot> snapshotLists = albumModel.getSnapshots();
    int panelWidth = 800;
    int panelHeight = 800;
    for (Snapshot snapshot : snapshotLists) {
      CustomSnapshotPanel panel = new CustomSnapshotPanel(snapshot, panelWidth, panelHeight);
      snapshotsStorage.add(panel, snapshot.getID());
    }
    add(snapshotsStorage, BorderLayout.CENTER);
    displaySnapshot(currentSnapshotIndex);
  }
  
  private void initializeControlPanel() {
    controlPanel.setBackground(Color.BLUE);
    controlPanel.setLayout(new GridLayout(1, 3));
    
    controlPanel.add(previousButton);
    controlPanel.add(nextButton);
    controlPanel.add(quitButton);
    
    setPreviousButton();
    setNextButton();
    setQuitButton();
    
    add(controlPanel, BorderLayout.SOUTH);
  }
  
  private void displaySnapshot(int index) {
    List<Snapshot> snapshotLists = albumModel.getSnapshots();
    if (index < 0 || index >= snapshotLists.size()) {
      return;
    }
    
    String snapshotID = snapshotLists.get(index).getID();
    cardLayout.show(snapshotsStorage, snapshotID);
  }
  
  private void setPreviousButton() {
    previousButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        controller.previousButtonAction();
      }
    });
  }
  
  private void setNextButton() {
    nextButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        controller.nextButtonAction();
      }
    });
  }
  
  private void setQuitButton() {
    quitButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        controller.quitButtonAction();
      }
    });
  }
  
  /**
   * Displays the current snapshot.
   */
  public void displayCurrentSnapshot() {
    displaySnapshot(currentSnapshotIndex);
  }
}
