package view;

import controller.Controller;
import controller.GameState;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class FinishView {
    
    Pane pane;
    Controller controller;
    View view;
    
    public FinishView(Pane p, Controller controller, View viewImp) {
        controller = controller;
        pane = p;
        view = viewImp;
    }
    
    
    void showFinishView(){
        System.out.println("dentro showfinish");
        ImageView gameover = new ImageView();
        gameover.setImage(new Image("gameover.png"));
        gameover.setFitHeight(200);
        gameover.setFitWidth(250);
        gameover.setLayoutX(300);
        gameover.setLayoutY(50);
        
        ImageView finish= new ImageView();
        finish.setImage(new Image("finish_data.png"));
        finish.setFitHeight(200);
        finish.setFitWidth(300);
        finish.setLayoutX(275);
        finish.setLayoutY(175);
        
       
       // Image imageOk = new Image(getClass().getResourceAsStream("ok.png"));
        ImageView imageOk = new ImageView();
        imageOk.setImage(new Image("play.png"));
        imageOk.setFitHeight(40);
        imageOk.setPreserveRatio(true);
        
       
        Button button = new Button();
       /* button.setOnAction(e->{
            controller.setState(GameState.INITIALIZE);
            controller.updateState();
        });*/
        button.setGraphic(imageOk);
        button.setLayoutX(300);
        button.setLayoutY(400);
        button.setPrefHeight(40);
        button.setOnAction(e->{
          this.pane.getChildren().clear();
          view.initiate();
          view.update();
         
        });
          
        ImageView imageLeader = new ImageView();
        imageLeader.setImage(new Image("leaderboard.png"));
        imageLeader.setFitHeight(100);
        imageLeader.setPreserveRatio(true);
        Button buttonLeader = new Button();
        buttonLeader.setGraphic(imageLeader);
        buttonLeader.setLayoutX(450);
        buttonLeader.setLayoutY(400);
        buttonLeader.setPrefHeight(100);
       
        
        
        pane.getChildren().add(gameover);
        pane.getChildren().add(finish);
        pane.getChildren().add(button);
        pane.getChildren().add(buttonLeader);
        
    }

}
