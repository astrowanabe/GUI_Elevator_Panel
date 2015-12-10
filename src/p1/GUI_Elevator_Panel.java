package p1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
 * Phillip Dingus
 * 12-10-15
 * Mr. Mailman
 * CIS150-401
 *
 * This program creates a GUI elevator button panel with 10 buttons for floors in 2 columns, as well as a test
 * button to select all floors and a clear button to deselect all floors. Selected floors will have their button
 * background turn from light grey to orange.
 */
public class GUI_Elevator_Panel extends Application{

    // Create an array of buttons
    int numOfButtons = 5;
    Button[] buttonsArray1 = new Button[numOfButtons];
    Button[] buttonsArray2 = new Button[numOfButtons];

    @Override
    public void start(Stage primaryStage) {
        // Get the pane for the scene
        primaryStage.setScene(new Scene(getPane(), 260, 400));

        // Setup the stage
        primaryStage.setTitle("Elevator Buttons");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    protected Pane getPane() {
        GridPane gridPane = new GridPane();
        Pane pane1 = new VBox(5);
        Pane pane2 = new VBox(5);
        pane1.setPadding(new Insets(20,10,20,20));
        pane2.setPadding(new Insets(20,20,20,10));
        gridPane.add(pane1,0,0);
        gridPane.add(pane2,1,0);

        for (int i = numOfButtons - 1; i >= 0; i--) {

            // Set the button number as text for the button
            buttonsArray1[i] = new Button(Integer.toString((i*2) + 1));

            // Set preferred width and style with a light gray background
            buttonsArray1[i].setPrefWidth(100);
            buttonsArray1[i].setStyle("-fx-font: 22 arial; -fx-base: LightGray");

            // Add the button to the pane and set the handler
            pane1.getChildren().add(buttonsArray1[i]);
            buttonsArray1[i].setOnAction(ButtonHandler1);
        }

        for (int i = numOfButtons - 1; i >= 0; i--) {

            // Set the button number as text for the button
            buttonsArray2[i] = new Button(Integer.toString((i + 1) *2));

            // Set preferred width and style with a light gray background
            buttonsArray2[i].setPrefWidth(100);
            buttonsArray2[i].setStyle("-fx-font: 22 arial; -fx-base: LightGray");

            // Add the button to the pane and set the handler
            pane2.getChildren().add(buttonsArray2[i]);
            buttonsArray2[i].setOnAction(ButtonHandler2);
        }

        return gridPane;
    }

    // Build an event handler for the first column of buttons
    EventHandler<ActionEvent> ButtonHandler1 = e -> {
        // Identify the object that caused the event
        Button b = (Button)e.getSource();

        // Read the text field of the object and convert it to an integer
        int i = (Integer.parseInt(b.getText()) + 1) / 2;

        // Check the background of the button to orange
        buttonsArray1[i-1].setStyle("-fx-font: 22 arial; -fx-base: Orange");
    };

    // Build an event handler for the second column of buttons
    EventHandler<ActionEvent> ButtonHandler2 = e -> {
        // Identify the object that caused the event
        Button b = (Button)e.getSource();

        // Read the text field of the object and convert it to an integer
        int i = (Integer.parseInt(b.getText()) / 2);

        // Check the background of the button to orange
        buttonsArray2[i-1].setStyle("-fx-font: 22 arial; -fx-base: Orange");
    };
}
