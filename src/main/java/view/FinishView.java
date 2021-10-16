package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import controller.Controller;
import controller.GameState;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.file.Gamer;
import model.file.Leaderboard;


public class FinishView {
    
    Pane pane;
    Controller controller;
    View view;
    Label score;
   
    
    public FinishView(Pane p, Controller controller, View viewImp) {
        this.controller = controller;
        pane = p;
        view = viewImp;
        score = new Label();
     
    }
    
    
    void showFinishView(Label label){
        
        score.setText(label.getText());
        score.setLayoutX(500);
        score.setLayoutY(230);
        score.setTextFill(Color.BLACK);
        score.setFont(new Font("Ariel", 30));
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
        
       
        Button buttonReset = new Button();
    
        buttonReset.setGraphic(imageOk);
        buttonReset.setLayoutX(300);
        buttonReset.setLayoutY(400);
        buttonReset.setPrefHeight(40);
        buttonReset.setOnAction(e->{
          this.pane.getChildren().clear();
          view.initiate();
          view.update();
        //  this.controller.setState(GameState.INITIALIZE);
          //this.controller.updateState();
         
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
        buttonLeader.setOnAction(e->{
           // this.controller.getLeaderboard().getLeaderboard().getG
            pane.getChildren().clear();
           Platform.runLater(()->{
               showLeaderboard();
           }); 
           
            
        });
       
        
        
        pane.getChildren().add(gameover);
        pane.getChildren().add(finish);
        pane.getChildren().add(score);
        pane.getChildren().add(buttonReset);
        pane.getChildren().add(buttonLeader);
        
    }


    private void showLeaderboard() {
        // TODO Auto-generated method stub
        
        Label labelTitle = new Label();
        labelTitle.setText("Flappy Bird LeaderBoard");
        labelTitle.setLayoutX(240);
        labelTitle.setLayoutY(50);
        labelTitle.setFont(new Font(30));
        Label labelSubTitle = new Label();
        labelSubTitle.setText("Top 10 Scores");
        labelSubTitle.setLayoutX(200);
        labelSubTitle.setLayoutY(120);
        labelSubTitle.setFont(new Font(20));
        
        ImageView leaderImage= new ImageView();
        leaderImage.setImage(new Image("leaderboard_background.png"));
       
        leaderImage.setFitHeight(600);
        
        
        Button button = new Button();
        button.setLayoutX(350);
        button.setLayoutY(500);
        button.setPrefSize(100, 50);
        button.setOnAction(e->{
            this.pane.getChildren().clear();
            view.initiate();
            view.update();
        });
        
        
        
        TableView<Gamer> table = new TableView<>();
        List<Gamer> list= this.controller.getLeaderboard();
        
   
        final ObservableList<Gamer> data = FXCollections.observableArrayList(list);
  
        
        System.out.println("fnish "+list.stream()
                .map(i->Integer.parseInt(i.getScore()))
                .sorted().collect(Collectors.toList()));
        
        
        TableColumn<Gamer,String> name = new TableColumn<Gamer,String>("Name");
        name.setCellValueFactory(new PropertyValueFactory("name"));
        TableColumn<Gamer,String> score = new TableColumn<Gamer,String>("Score");
        score.setCellValueFactory(new PropertyValueFactory("score"));
     
        score.setComparator((i1,i2)-> Integer.parseInt(i1)-(Integer.parseInt(i2)));
        table.getSortOrder().add(score);
     //   table.setItems(data);
        table.getColumns().setAll(name,score);
        table.getItems().setAll(data);
       // score.setSortType(TableColumn.SortType.DESCENDING);
        
        name.setStyle("-fx-alignment: CENTER; "
                + "-fx-background-color: #F0FFFF; "
                + "-fx-border-color: black; "
                + "-fx-font-weight: bold;");
               
     //   name.setResizable(false);
      
        score.setStyle("-fx-alignment: CENTER;"
                + " -fx-background-color: #F0FFFF;"
                + " -fx-border-color: black;"
                + " -fx-font-weight: bold;");
           

        
      
        table.setStyle("-fx-font-size: 20;");
        
     
     
        
        
       table.setPrefSize(400, 300);
       table.setLayoutX(200);
       table.setLayoutY(150);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
     
    
       
        pane.getChildren().add(leaderImage);
        pane.getChildren().add(labelTitle);
        pane.getChildren().add(labelSubTitle);
        pane.getChildren().add(table);
        pane.getChildren().add(button);
      
        //
    }

}
