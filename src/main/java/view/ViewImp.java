package view;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import controller.Controller;
import controller.ControllerImp;
import controller.GameState;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;
import model.Bird;
import model.Column;

public class ViewImp extends Application implements View {
    
    private static final int width = 800;
    private static final int height = 600;
  
    Rectangle rec;
    Controller controller;
    ViewObstacle viewObstacle;
    FinishView finish;
    Pane p;
    Stage stage;
    Label label;
    ViewBird viewBird;
    ViewMenu viewMenu;

            
    
    public ViewImp() {
     
    }
    
 /*   public void initiate() {
        //controller = new ControllerImp();
        p = new Pane();
        //viewObstacle = new ViewObstacleImp(p);
        //viewBird = new ViewBird(p);
        viewMenu = new ViewMenu(p);
        
        ImageView img = new ImageView();
        img.setImage(new Image("background.png"));
        img.setFitHeight(height);
        img.setFitWidth(width);
        
        label = new Label();
        label.setLayoutX(400);
        label.setLayoutY(50);
        label.setText("0");
        label.setFont(new Font("Arial", 60));
        label.setTextFill(Color.ANTIQUEWHITE);
        
        
        p.getChildren().add(img);
        p.getChildren().add(label);
        
        stage.setMaxHeight(height);
        stage.setMaxWidth(width);
        stage.setScene(new Scene(p));
        stage.show();
        
        
        
    } */
    
    //prova
    public void initiate() {
       // the start button
        p = new Pane();
        viewMenu = new ViewMenu(p);
        Button startButton= new Button();
        startButton.setLayoutX(400);
        startButton.setLayoutY(200);
        startButton.setTextAlignment(TextAlignment.CENTER);
        startButton.setAlignment(Pos.CENTER);
        startButton.setText("START");
        startButton.setFont(new Font("Arial", 12));
        
        Button scoreButton= new Button();
        scoreButton.setLayoutX(400);
        scoreButton.setLayoutY(250);
        scoreButton.setAlignment(Pos.CENTER);
        scoreButton.setTextAlignment(TextAlignment.CENTER);
        scoreButton.setText("SCORE");
        scoreButton.setFont(new Font("Arial", 12));
        
        Button exitButton= new Button();
        exitButton.setLayoutX(400);
        exitButton.setLayoutY(300);
        exitButton.setAlignment(Pos.CENTER);
        exitButton.setTextAlignment(TextAlignment.CENTER);
        exitButton.setText("EXIT");
        exitButton.setFont(new Font("Arial", 12));
        
        Button playerButton= new Button();
        playerButton.setLayoutX(400);
        playerButton.setLayoutY(350);
        playerButton.setAlignment(Pos.CENTER);
        playerButton.setTextAlignment(TextAlignment.CENTER);
        playerButton.setText("SCEGLI IL PERSONAGGIO");
        playerButton.setFont(new Font("Arial", 12));
        
        
       
        
        
        ImageView img = new ImageView();
        img.setImage(new Image("background.png"));
        img.setFitHeight(height);
        img.setFitWidth(width);
        
        label = new Label();
        label.setLayoutX(400);
        label.setLayoutY(50);
        label.setText("0");
        label.setFont(new Font("Arial", 60));
        label.setTextFill(Color.ANTIQUEWHITE);
        
        
        p.getChildren().add(img);
        p.getChildren().add(label);
        p.getChildren().add(startButton);
        p.getChildren().add(scoreButton);
        p.getChildren().add(playerButton);
        p.getChildren().add(exitButton);
        
        stage.setMaxHeight(height);
        stage.setMaxWidth(width);
        stage.setScene(new Scene(p));
        stage.show();
        
        
        
    }
    
    public void update(){
        this.controller.update(this);
    }





   
  


    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        primaryStage.setTitle("ciao");
        this.stage = primaryStage;
        initiate();
     
 
         
         
         //update();
       
    }
    
    public static void run(final String[] args) {
        launch();
    }
    
    public  void render(List<Column> columns, Integer score, Bird bird) {
        // TODO Auto-generated method stub
        
      
            

        
     
         
      
          Platform.runLater(()->{
              
              
              viewObstacle.render(columns);
              p.getChildren().remove(label);
              label.setText(Integer.toString(score));
              p.getChildren().add(label);
              
              viewBird.render(bird);
              
              p.getScene().setOnKeyPressed(e ->{
                  {
                     this.controller.setEvent(e);
                 }
             });
              
              }); 
          
       
    }









    @Override
    public void gameOver() {
        // TODO Auto-generated method stub
        finish = new FinishView(p, controller, this);
        Platform.runLater(()->{
            System.out.println("view game over");
            finish.showFinishView(label);

          
            }); 
    }



















    






   
  
     
    







}
