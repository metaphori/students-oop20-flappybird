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
import model.file.Leaderboard;

/**
 * The view opened when is gameOver
 */
public class FinishView {
    
    private static final int TABLE_Y = 150;
    private static final int TABLE_X = 200;
    private static final int TABLE_SIZE_Y = 300;
    private static final int TABLE_SIZE_X = 400;
    private static final int BUTTON_SIZE_Y = 50;
    private static final int BUTTON_SIZE_X = 100;
    private static final int BUTTON_Y = 500;
    private static final int BUTTON_X = 350;
    private static final int LEADERIMAGE_HEIGHT = 600;
    private static final int LABEL_SUBTITLE_FONT = 20;
    private static final int LABELSUBTILE_Y = 120;
    private static final int LABLE_SUBTITLE_X = 200;
    private static final int LABLETITLE_FONT = 30;
    private static final int LABLETITLE_Y = 50;
    private static final int LABELTITLE_X = 240;
    private static final int BUTTONLEADER_HEIGHT = 100;
    private static final int BUTTONLEADER_Y = 400;
    private static final int BUTTONLEADER_X = 450;
    private static final int IMAGE_OK_HEIGHT = 40;
    private static final int BUTTON_RESET_HEIGHT = 40;
    private static final int GAME_OVER_IMAGE_HEIGHT = 200;
    private static final int GAME_OVER_IMAGE_WIDTH = 250;
    private static final int GAME_OVER_POS_X = 300;
    private static final int GAME_OVER_POS_Y = 50;
    private static final int FINISH_IMAGE_HEIGHT = 200;
    private static final int FINISH_IMAGE_WIDTH = 300;
    private static final int FINISH_POS_X = 275;
    private static final int FINISH_POS_Y = 175;
    private static final int BUTTON_RESET_X = 300;
    private static final int BUTTON_RESET_Y = 400;
    private static final int TOP_SCORE_FONT = 30;
    private static final int SCORE_POS_X = 500;
    private static final int SCORE_POS_Y = 230;
    private static final int TOP_SCORE_POS_X = 500;
    private static final int TOP_SCORE_POS_Y = 300;
    private static final String TITLE = "Flappy Bird LeaderBoard";
    private static final String TOP_SCORE = "Top Score";
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
        finish.setFitHeight(FINISH_IMAGE_HEIGHT);
        finish.setFitWidth(FINISH_IMAGE_WIDTH);
        finish.setLayoutX(FINISH_POS_X);
        finish.setLayoutY(FINISH_POS_Y);
  
       // Image imageOk = new Image(getClass().getResourceAsStream("ok.png"));
        ImageView imageOk = new ImageView();
        imageOk.setImage(new Image("play.png"));
        imageOk.setFitHeight(IMAGE_OK_HEIGHT);
        imageOk.setPreserveRatio(true);
        
        Button buttonReset = new Button();
        buttonReset.setGraphic(imageOk);
        buttonReset.setLayoutX(BUTTON_RESET_X);
        buttonReset.setLayoutY(BUTTON_RESET_Y);
        buttonReset.setPrefHeight(BUTTON_RESET_HEIGHT);
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
        buttonLeader.setLayoutX(BUTTONLEADER_X);
        buttonLeader.setLayoutY(BUTTONLEADER_Y);
        buttonLeader.setPrefHeight(BUTTONLEADER_HEIGHT);
        buttonLeader.setOnAction(e->{
            pane.getChildren().clear();
           Platform.runLater(()->{
               showLeaderboard();
           });    
        });
       
        this.pane.getChildren().add(gameover);
        this.pane.getChildren().add(finish);
        this.pane.getChildren().add(this.score);
        this.pane.getChildren().add(this.topScore);
        this.pane.getChildren().add(buttonReset);
        this.pane.getChildren().add(buttonLeader);  
    }


    private void showLeaderboard() {        
        Label labelTitle = new Label();
        labelTitle.setText(TITLE);
        labelTitle.setLayoutX(LABELTITLE_X);
        labelTitle.setLayoutY(LABLETITLE_Y);
        labelTitle.setFont(new Font(LABLETITLE_FONT));
        Label labelSubTitle = new Label();
        labelSubTitle.setText(TOP_SCORE);
        labelSubTitle.setLayoutX(LABLE_SUBTITLE_X);
        labelSubTitle.setLayoutY(LABELSUBTILE_Y);
        labelSubTitle.setFont(new Font(LABEL_SUBTITLE_FONT));
        ImageView leaderImage= new ImageView();
        leaderImage.setImage(new Image("leaderboard_background.png"));       
        leaderImage.setFitHeight(LEADERIMAGE_HEIGHT);       
        Button button = new Button();
        button.setText("BACK");
        button.setLayoutX(BUTTON_X);
        button.setLayoutY(BUTTON_Y);
        button.setPrefSize(BUTTON_SIZE_X, BUTTON_SIZE_Y);
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
       table.setPrefSize(TABLE_SIZE_X, TABLE_SIZE_Y);
       table.setLayoutX(TABLE_X);
       table.setLayoutY(TABLE_Y);
       table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

       this.pane.getChildren().add(leaderImage);
       this.pane.getChildren().add(labelTitle);
       this.pane.getChildren().add(labelSubTitle);
       this.pane.getChildren().add(table);
       this.pane.getChildren().add(button);  
    }

}
