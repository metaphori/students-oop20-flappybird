package view;

import controller.Controller;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PlayerView {


    
    
    public static void show(ViewBird viewBird, Stage stage2) {
        Stage stage= new Stage();
        Label label= new Label("Choose player");
        Pane pane = new Pane();
        Button firstButton= new Button();
        Button secondButton= new Button();
        Button thirdButton= new Button();
        label.setStyle("-fx-font-size: 20;");
        label.setLayoutX(75);
        label.setLayoutY(20);
        
        ImageView firstBird= new ImageView();
        firstBird.setImage(new Image("player.png"));
        
        ImageView secondBird= new ImageView();
        firstBird.setImage(new Image("player2.png"));
        
        ImageView thirdBird= new ImageView();
        firstBird.setImage(new Image("player3.png"));
        
        firstButton.setLayoutX(115);
        firstButton.setLayoutY(120);
        firstButton.setPrefWidth(60);
        firstButton.setGraphic(firstBird);
        firstButton.setOnAction(e->{
            viewBird.setImage(firstBird.getImage());
        });
        
        
        secondButton.setLayoutX(120);
        secondButton.setLayoutY(120);
        secondButton.setPrefWidth(60);
        secondButton.setGraphic(secondBird);
        secondButton.setOnAction(e->{
            viewBird.setImage(secondBird.getImage());
        });
        
        thirdButton.setLayoutX(125);
        thirdButton.setLayoutY(120);
        thirdButton.setPrefWidth(60);
        thirdButton.setGraphic(thirdBird);
        thirdButton.setOnAction(e->{
            viewBird.setImage(thirdBird.getImage());
        });
        
        pane.getChildren().add(firstButton);
        pane.getChildren().add(secondButton);
        pane.getChildren().add(thirdButton);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(stage2);
        stage.setHeight(200);
        stage.setWidth(300);
        stage.setScene(new Scene(pane));
        stage.requestFocus();
        stage.setResizable(false);
        stage.show();
       
    }
}
