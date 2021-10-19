package view;


import java.util.List;



import controller.Controller;
import controller.ControllerImp;
import controller.GameState;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;

import model.Column;
import view.ImageID;

public class ViewImp extends Application implements View {
    
    private double width;
    private double height;
  
    Rectangle rec;
    Controller controller;
    ViewObstacle viewObstacle;
    FinishView finish;
    Pane p;
    Stage stage;
    Label label;

            
    
    public ViewImp() {
     
    }
    
    public void initiate() {
        
        controller = new ControllerImp();
        width = controller.getGameWidth();
        height = controller.getGameHeight();
        p = new Pane();
        viewObstacle = new ViewObstacleImp(p);
        
        
        ImageView img = new ImageView();
        img.setImage(new Image(ImageID.PLAYING_BACKGROUND.getPath()));
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
     
 
         
         
         update();
       
    }
    
    public static void run(final String[] args) {
        launch();
    }
    
    public  void render(List<Column> columns, Integer score) {
        // TODO Auto-generated method stub
     
       
        
     
        
      
          Platform.runLater(()->{
             
              viewObstacle.render(columns);
              p.getChildren().remove(label);
              label.setText(Integer.toString(score));
              p.getChildren().add(label);
              
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
