package view;

import java.util.ArrayList;
import java.util.List;

import controller.Controller;
import controller.ControllerImp;
import controller.GameState;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;
import model.Column;

public class ViewImp extends Application implements View {
    
    private static final int width = 800;
    private static final int height = 600;
  
    Rectangle rec;
    Controller controller;
    ViewObstacle viewObstacle;
    FinishView finish;
    Pane p;
            
    
    public ViewImp() {
     controller = new ControllerImp();
     p = new Pane();
     viewObstacle = new ViewObstacleImp(p);
     finish = new FinishView(p, controller);
    }





   
  


    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        primaryStage.setTitle("ciao");
       
      
        
     
        
        ImageView img = new ImageView();
        img.setImage(new Image("background.png"));
        img.setFitHeight(height);
        img.setFitWidth(width);
        
        p.getChildren().add(img);
     
       
       
         primaryStage.setMaxHeight(height);
         primaryStage.setMaxWidth(width);
        
         primaryStage.setScene(new Scene(p));
         
        
        
         
         this.controller.update(this);
         
         primaryStage.show();
         
       
    }
    
    public static void run(final String[] args) {
        launch();
    }
    
    public  void render(List<Column> columns) {
        // TODO Auto-generated method stub
     
            

        
     
         
      
          Platform.runLater(()->{
              
              viewObstacle.render(columns);

            
              }); 
          
       
    }









    @Override
    public void gameOver() {
        // TODO Auto-generated method stub
        Platform.runLater(()->{
            System.out.println("view game over");
            finish.showFinishView();

          
            }); 
    }



















    






   
        

       
       
           // lay.getChildren().addAll(list);
            
         
    
      
        
        
        
        //System.out.println("ciaoo");
        
     
    







}
