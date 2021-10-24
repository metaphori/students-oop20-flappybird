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
        label.setLayoutX(115);
        label.setLayoutY(20);
        label.setTextAlignment(TextAlignment.CENTER);
        
        
        ImageView firstBird= new ImageView();
        firstBird.setImage(new Image(ImageID.PLAYER_ONE_BUTTON.getPath()));
        firstBird.setFitHeight(40);
        firstBird.setPreserveRatio(true);
        
        ImageView secondBird= new ImageView();
        secondBird.setImage(new Image(ImageID.PLAYER_TWO_BUTTON.getPath()));
        secondBird.setFitHeight(40);
        secondBird.setPreserveRatio(true);
        
        ImageView thirdBird= new ImageView();
        thirdBird.setImage(new Image(ImageID.PLAYER_THREE_BUTTON.getPath()));
        thirdBird.setFitHeight(40);
        thirdBird.setPreserveRatio(true);
        
        firstButton.setLayoutX(42);
        firstButton.setLayoutY(100);
        firstButton.setPrefWidth(60);
        firstButton.setGraphic(firstBird);
        firstButton.setOnAction(e->{
            viewBird.setImage(firstBird.getImage());
            stage.close();
        });
        
        
        secondButton.setLayoutX(144);
        secondButton.setLayoutY(100);
        secondButton.setPrefWidth(60);
        secondButton.setGraphic(secondBird);
        secondButton.setOnAction(e->{
            viewBird.setImage(secondBird.getImage());
            stage.close();
        });
        
        thirdButton.setLayoutX(248);
        thirdButton.setLayoutY(100);
        thirdButton.setPrefWidth(60);
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
        stage.setHeight(250);
        stage.setWidth(350);
        stage.setScene(new Scene(pane));
        stage.requestFocus();
        stage.setResizable(false);
        stage.show();
       
       
    }
}
