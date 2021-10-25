package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import controller.Controller;
import controller.ControllerLeaderBoard;
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
import model.file.LeaderBoard;

/**
 * The view opened when is gameOver
 */
public class FinishView {
    
    private static final int GAME_OVER_IMAGE_HEIGHT = 200;
    private static final int GAME_OVER_IMAGE_WIDTH = 250;
    private static final int GAME_OVER_POS_X = 300;
    private static final int GAME_OVER_POS_Y = 50;
    private static final int TOP_SCORE_FONT = 30;
    private static final int SCORE_POS_X = 500;
    private static final int SCORE_POS_Y = 230;
    private static final int TOP_SCORE_POS_X = 500;
    private static final int TOP_SCORE_POS_Y = 300;
    private static final String TITLE = "Flappy Bird LeaderBoard";
    private static final String TOP_SCORE = "Top 10 Score";
    private Pane pane;
    private ControllerLeaderBoard controller;
    private View view;
    private Label score;
    private Label topScore;
   
    /**
     * Create the view
     * 
     * @param pane
     *             the pane of the game
     * 
     * @param controllerLeaderBoard
     *                   the controller of the game
     *
     * @param view
     *             the view class                              
     */
  
    public FinishView(Pane pane, ControllerLeaderBoard controllerLeaderBoard, View view) {
        this.controller = controllerLeaderBoard;
        this.pane = pane;
        this.view = view;
        this.score = new Label();
        this.topScore = new Label("0");     
    }
    
    /**
     * Show the view when the game is over
     */
    void showFinishView(Label label, Optional<Integer> topScore){        
        this.score.setText(label.getText());
        this.score.setLayoutX(SCORE_POS_X);
        this.score.setLayoutY(SCORE_POS_Y);
        this.score.setTextFill(Color.BLACK);
        this.score.setFont(new Font("Ariel", 30));
        
        if (!topScore.isEmpty()) {
            this.topScore.setText(Integer.toString(topScore.get()));
        }
       
        this.topScore.setLayoutX(TOP_SCORE_POS_X);
        this.topScore.setLayoutY(TOP_SCORE_POS_Y);
        this.topScore.setTextFill(Color.BLACK);
        this.topScore.setFont(new Font("Ariel", TOP_SCORE_FONT));
        
        ImageView gameover = new ImageView();
        gameover.setImage(new Image("gameover.png"));
        gameover.setFitHeight(GAME_OVER_IMAGE_HEIGHT);
        gameover.setFitWidth(GAME_OVER_IMAGE_WIDTH);
        gameover.setLayoutX(GAME_OVER_POS_X);
        gameover.setLayoutY(GAME_OVER_POS_Y);
        
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
            pane.getChildren().clear();
           Platform.runLater(()->{
               showLeaderboard();
           });    
        });
       
        pane.getChildren().add(gameover);
        pane.getChildren().add(finish);
        pane.getChildren().add(score);
        pane.getChildren().add(this.topScore);
        pane.getChildren().add(buttonReset);
        pane.getChildren().add(buttonLeader);  
    }


    private void showLeaderboard() {
        
        Label labelTitle = new Label();
        labelTitle.setText(TITLE);
        labelTitle.setLayoutX(240);
        labelTitle.setLayoutY(50);
        labelTitle.setFont(new Font(30));
        Label labelSubTitle = new Label();
        labelSubTitle.setText(TOP_SCORE);
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
        
        });

        TableView<Gamer> table = new TableView<>();
        List<Gamer> list= this.controller.getLeaderBoard();
        final ObservableList<Gamer> data = FXCollections.observableArrayList(list);               
        TableColumn<Gamer,String> name = new TableColumn<Gamer,String>("Name");
        name.setCellValueFactory(new PropertyValueFactory("name"));
        TableColumn<Gamer,String> score = new TableColumn<Gamer,String>("Score");
        score.setCellValueFactory(new PropertyValueFactory("score"));
        score.setComparator((i1,i2)-> Integer.parseInt(i1)-(Integer.parseInt(i2)));
        table.getSortOrder().add(score);
     
        table.getColumns().setAll(name,score);
        table.getItems().setAll(data);
        name.setStyle("-fx-alignment: CENTER; "
                + "-fx-background-color: #F0FFFF; "
                + "-fx-border-color: black; "
                + "-fx-font-weight: bold;");
        
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
    }

}
