For HW9, I implemented Controller and View sections. 

Compared to the model part, I added two more packages which are view and controller. 

For view, I created two view which are graphical view and web view. In order to implement the graphical view, I extended the ShapeAlbum application to include a graphical view of the album and a controller to handle user interactions.

The IGraphicalView interface represents a graphical view of an album and is responsible for displaying the album in a graphical view. The GraphicalView class implements this interface and creates the graphical view using Java Swing. It has a singleton pattern, providing a single instance of the graphical view. The go method creates and shows the GUI, which includes a CustomGraphicsFrame.

The CustomGraphicsFrame class extends JFrame and displays the snapshots in the album. It contains a CardLayout to store the snapshots and a control panel with buttons to navigate between the snapshots. The initializeSnapshotsStorage method creates a CustomSnapshotPanel for each snapshot in the album, while the initializeControlPanel method sets up the previous, next, and quit buttons with their corresponding actions.

The CustomSnapshotPanel class extends JPanel and is responsible for displaying a snapshot in the GUI. It draws the label panel with the snapshot's ID and description using a BoxLayout. It also creates a shape panel, which renders the shapes in the snapshot using a custom paint method.

For web view, the IWebView interface contains a single method go(Appendable out, int frameWidth, int frameHeight) that is responsible for rendering the view.

The WebView class is a singleton that implements the IWebView interface. It contains:

A private constructor that initializes the albumModel to an instance of ShapeAlbum.

A getInstance() method that returns the instance of the WebView.

The go(Appendable out, int frameWidth, int frameHeight) method, which sets the output stream, frame width, and frame height, and writes the HTML and CSS code for the shape album. It also flushes the output stream if it is an instance of FileWriter.

The WebView class has several helper methods:

cssFormatting(): Appends the CSS styles for the HTML elements.

Head(): Appends the head section of the HTML document, including the meta tags and title.

Body(): Appends the body section of the HTML document, including the main heading and calls the createSnapshotStorage(Snapshot snapshot) method for each snapshot in the album.

createSnapshotStorage(Snapshot snapshot): Appends the HTML code for the snapshot div, which includes the snapshot ID, description (if available), and an SVG element containing the shapes in the snapshot. The SVG element has the specified frame width and height.

The resulting HTML code will display the shape album with each snapshot rendered using SVG elements, and the snapshots will be styled according to the provided CSS.

For the controller, it defines an application that manipulates and displays shapes in an album, allowingusers to create, modify, and remove shapes, and take snapshots of the shapes' states.

The code consists of two parts:

IController interface: This interface defines the methods that a controller class should implement for this application. Some methods include showGraphicalView(), showWebView(), setCustomGraphicsFrame(), and several button action methods like previousButtonAction(), nextButtonAction(), and quitButtonAction().

ShapeAlbumController class: This class implements the IController interface and represents the controller of the ShapeAlbum program. It is a Singleton, meaning there is only one instance of the class. The controller interacts with the model (IAlbum and ShapeAlbum instances) and the views (CustomGraphicsFrame, GraphicalView, IGraphicalView, IWebView, and WebView). The controller handles the input (Readable) and output (Appendable) streams, processing commands (like adding, moving, removing shapes, etc.) and updating the views accordingly.

The previousButtonAction() and nextButtonAction() methods handle the actions for the previous and next buttons, updating the displayed snapshot in the custom graphics frame. 

The quitButtonAction() method closes the custom graphics frame. The run() method takes input commands and processes them, calling the appropriate methods for each command. 

Finally, the showGraphicalView() and showWebView() methods display the respective views of the application.
