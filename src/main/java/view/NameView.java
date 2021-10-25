package view;


import controller.ControllerLeaderBoard;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * The view opened to save the gamer name
 */
public class NameView {
    
    private final static String LABEL_NAME = "Insert your name";
    private final static String BUTTON_NAME = "Save";
    /**
     * Show the view
     * 
     * @param parentStage
     *                   the parentStage
     *  
     * @param controllerLeaderBoard
     *                   the controller                  
     */
    public static void show(Stage parentStage, ControllerLeaderBoard controllerLeaderBoard) {
        Stage stage = new Stage();
        Pane pane = new Pane();
        Label label = new Label(LABEL_NAME);
        Button button = new Button(BUTTON_NAME);
        TextField textField = new TextField();
        label.setStyle("-fx-font-size: 20;");
        label.setLayoutX(75);
        label.setLayoutY(20);
        textField.setLayoutX(75);
        textField.setLayoutY(75);
        button.setLayoutX(120);
        button.setLayoutY(120);
        button.setPrefWidth(60);
        button.setOnAction(e->{
           controllerLeaderBoard.savePlayer(textField.getText());
           stage.close();
        });
        pane.getChildren().add(label);
        pane.getChildren().add(textField);
        pane.getChildren().add(button);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(parentStage);
        stage.setHeight(200);
        stage.setWidth(300);
        stage.setScene(new Scene(pane));
        stage.requestFocus();
        stage.setResizable(false);
        stage.show();
    }

}
