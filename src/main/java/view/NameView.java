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
    
    private static final int STAGE_WIDTH = 300;
    private static final int STAGE_HEIGHT = 200;
    private static final int BUTTON_WIDTH = 60;
    private static final int LABEL_X = 75;
    private static final int LABEL_Y = 20;
    private static final int TEXTFIELD_X = 75;
    private static final int TEXTFIELD_Y = 75;
    private static final int BUTTON_X = 120;
    private static final int BUTTON_Y = 120;
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
        label.setLayoutX(LABEL_X);
        label.setLayoutY(LABEL_Y);
        textField.setLayoutX(TEXTFIELD_X);
        textField.setLayoutY(TEXTFIELD_Y);
        button.setLayoutX(BUTTON_X);
        button.setLayoutY(BUTTON_Y);
        button.setPrefWidth(BUTTON_WIDTH);
        button.setOnAction(e->{
           controllerLeaderBoard.savePlayer(textField.getText());
           stage.close();
        });
        pane.getChildren().add(label);
        pane.getChildren().add(textField);
        pane.getChildren().add(button);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(parentStage);
        stage.setHeight(STAGE_HEIGHT);
        stage.setWidth(STAGE_WIDTH);
        stage.setScene(new Scene(pane));
        stage.requestFocus();
        stage.setResizable(false);
        stage.show();
    }

}
