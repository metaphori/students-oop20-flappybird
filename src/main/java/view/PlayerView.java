package view;

import controller.Controller;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PlayerView {

    
    private static final int STAGE_WIDTH = 350;
    private static final int STAGE_HEIGHT = 250;
    private static final int FIRST_BUTTON_WIDTH = 60;
    private static final int FIRST_BUTTON_Y = 100;
    private static final int FIRST_BUTTON_X = 42;
    private static final int SECOND_BUTTON_WIDTH = 60;
    private static final int SECOND_BUTTON_Y = 100;
    private static final int SECOND_BUTTON_X = 144;
    private static final int THIRD_BUTTON_WIDTH = 60;
    private static final int THIRD_BUTTON_Y = 100;
    private static final int THIRD_BUTTON_X = 248;
    private static final int BIRD_HEIGHT = 40;
    private static final int LABEL_Y = 20;
    private static final int LABEL_X = 115;

    /**
     * Shows the new stage where you can choose the player.
     * @param parentStage is the owner window.
     * @param viewBird.
     */
    
    public static void show(ViewBird viewBird, Stage parentStage) {
        Stage stage= new Stage();
        Pane pane = new Pane();
        Label label= new Label("Select player");
        Button firstButton= new Button();
        Button secondButton= new Button();
        Button thirdButton= new Button();
        label.setStyle("-fx-font-size: 20;");
        label.setLayoutX(LABEL_X);
        label.setLayoutY(LABEL_Y);
        label.setTextAlignment(TextAlignment.CENTER);
        
        
        ImageView firstBird= new ImageView();
        firstBird.setImage(new Image(ImageID.PLAYER_ONE_BUTTON.getPath()));
        firstBird.setFitHeight(BIRD_HEIGHT);
        firstBird.setPreserveRatio(true);
        
        ImageView secondBird= new ImageView();
        secondBird.setImage(new Image(ImageID.PLAYER_TWO_BUTTON.getPath()));
        secondBird.setFitHeight(BIRD_HEIGHT);
        secondBird.setPreserveRatio(true);
        
        ImageView thirdBird= new ImageView();
        thirdBird.setImage(new Image(ImageID.PLAYER_THREE_BUTTON.getPath()));
        thirdBird.setFitHeight(BIRD_HEIGHT);
        thirdBird.setPreserveRatio(true);
        
        firstButton.setLayoutX(FIRST_BUTTON_X);
        firstButton.setLayoutY(FIRST_BUTTON_Y);
        firstButton.setPrefWidth(FIRST_BUTTON_WIDTH);
        firstButton.setGraphic(firstBird);
        firstButton.setOnAction(e->{
            viewBird.setImage(firstBird.getImage());
            stage.close();
        });

        secondButton.setLayoutX(SECOND_BUTTON_X);
        secondButton.setLayoutY(SECOND_BUTTON_Y);
        secondButton.setPrefWidth(SECOND_BUTTON_WIDTH);
        secondButton.setGraphic(secondBird);
        secondButton.setOnAction(e->{
            viewBird.setImage(secondBird.getImage());
            stage.close();
        });
        
        thirdButton.setLayoutX(THIRD_BUTTON_X);
        thirdButton.setLayoutY(THIRD_BUTTON_Y);
        thirdButton.setPrefWidth(THIRD_BUTTON_WIDTH);
        thirdButton.setGraphic(thirdBird);
        thirdButton.setOnAction(e->{
            viewBird.setImage(thirdBird.getImage());
            stage.close();
        });
        
        pane.getChildren().add(firstButton);
        pane.getChildren().add(secondButton);
        pane.getChildren().add(thirdButton);
        pane.getChildren().add(label);
        stage.setTitle("PLAYER");
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
