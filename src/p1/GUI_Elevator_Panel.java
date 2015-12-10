package p1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
        primaryStage.setScene(new Scene(getPane(), 260, 320));

        // Setup the stage
        primaryStage.setTitle("Elevator Buttons");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    protected Pane getPane() {
        GridPane gridPane = new GridPane();         //overall grid to hold everything
        Pane pane1 = new VBox(5);                   //left hand column of buttons (odds)
        Pane pane2 = new VBox(5);                   //right hand column of buttons (evens)
        //Pane pane3 = new HBox(2);                   //bottom row of buttons (TEST / CLEAR)
        //pane1.setPadding(new Insets(20,10,10,20));  //insets for left hand column
        //pane2.setPadding(new Insets(20,20,10,10));  //insets for right hand column
        gridPane.setPadding(new Insets(20,20,20,20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        //pane3.setPadding(new Insets(10,20,20,20));  //insets for bottom row
        gridPane.add(pane1,0,0);    //add pane to grid
        gridPane.add(pane2,1,0);    //add pane to grid
        //gridPane.add(pane3,0,1);    //add pane to grid

        /* place buttons in left hand column (odds) */
        for (int i = numOfButtons - 1; i >= 0; i--) {

            // Set the button number as text for the button
            buttonsArray1[i] = new Button(Integer.toString((i*2) + 1));

            // Set preferred width and style with a light gray background
            buttonsArray1[i].setPrefWidth(120);
            buttonsArray1[i].setStyle("-fx-font: 22 arial; -fx-base: LightGray");

            // Add the button to the pane and set the handler
            pane1.getChildren().add(buttonsArray1[i]);
            buttonsArray1[i].setOnAction(ButtonHandler1);
        }

        /* place buttons in right hand column (evens) */
        for (int i = numOfButtons - 1; i >= 0; i--) {

            // Set the button number as text for the button
            buttonsArray2[i] = new Button(Integer.toString((i + 1) *2));

            // Set preferred width and style with a light gray background
            buttonsArray2[i].setPrefWidth(120);
            buttonsArray2[i].setStyle("-fx-font: 22 arial; -fx-base: LightGray");

            // Add the button to the pane and set the handler
            pane2.getChildren().add(buttonsArray2[i]);
            buttonsArray2[i].setOnAction(ButtonHandler2);
        }

        /* place buttons in the bottom row (TEST / CLEAR) */
        Button test = new Button("TEST");
        test.setPrefWidth(100);
        test.setStyle("-fx-font: 22 arial; -fx-base: LightGray");
        //pane3.getChildren().add(0,test);
        test.setPrefWidth(120);
        gridPane.add(test,0,1);
        test.setOnAction(ButtonHandler3);
        Button clear = new Button("CLEAR");
        clear.setPrefWidth(100);
        clear.setStyle("-fx-font: 22 arial; -fx-base: LightGray");
        //pane3.getChildren().add(1,clear);
        clear.setPrefWidth(120);
        gridPane.add(clear,1,1);
        clear.setOnAction(ButtonHandler3);

        return gridPane;    //place gridPane with everything in it into the scene
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

    // Build an event handler for the bottom row of buttons
    EventHandler<ActionEvent> ButtonHandler3 = e -> {
        // Identify the object that caused the event
        Button b = (Button)e.getSource();

        if(b.getText() == "TEST") {     //button TEST pressed
            for(int i = numOfButtons - 1; i >= 0; i--){
                buttonsArray1[i].setStyle("-fx-font: 22 arial; -fx-base: Orange");
                buttonsArray2[i].setStyle("-fx-font: 22 arial; -fx-base: Orange");
            }

        } else {    //button CLEAR pressed
            for(int i = numOfButtons - 1; i >= 0; i--){
                buttonsArray1[i].setStyle("-fx-font: 22 arial; -fx-base: LightGrey");
                buttonsArray2[i].setStyle("-fx-font: 22 arial; -fx-base: LightGrey");
            }

        }

    };
}
