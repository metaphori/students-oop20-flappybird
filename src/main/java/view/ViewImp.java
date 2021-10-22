package view;


import java.util.List;
import java.util.Optional;

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
import javafx.scene.input.KeyCode;
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
import view.ImageID;

public class ViewImp extends Application implements View {
    
    private double width;
    private double height;
    boolean b;
  
    Rectangle rec;
    Controller controller;
    ViewObstacle viewObstacle;
    FinishView finish;
    Pane p;
    Stage stage;
    
    ViewBird viewBird;
    ViewMenu viewMenu;
    PlayView playView;


            
    
    public ViewImp() {
     
    }
    

 
    public void initiate() {
      
        b = false;
        controller = new ControllerImp();
        p = new Pane();
        //viewMenu = new ViewMenu(p);
        viewBird = new ViewBird(p);
        viewMenu = new ViewMenu(this,p,viewBird,stage);
        viewMenu.render();

        stage.setMaxHeight(600);
        stage.setMaxWidth(800);
        stage.setScene(new Scene(p));
        stage.show();
        
        
        
    }
    
    public void playGame(){
        System.out.println("ciaoo");
        
        
        
        viewObstacle = new ViewObstacleImp(p);
        
        playView = new PlayView(p);
        playView.display(this, controller);
        
        
        
        
        this.controller.update(this);
    }





   
  


    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        primaryStage.setTitle("ciao");
        this.stage = primaryStage;
        initiate();
     
      
         
         
      
       
    }
    
    public static void run(final String[] args) {
        launch();
    }
    
    public  void render(List<Column> columns, Integer score, Bird bird) {
        // TODO Auto-generated method stub

        
     
        
      
          Platform.runLater(()->{

              viewObstacle.render(columns);
              playView.updateScore(score);
              
              
              viewBird.render(bird);
              
        
              
              }); 
          
       
    }



    @Override
    public void gameOver(Optional<Integer> topScore) {
     
        
        finish = new FinishView(p, controller, this);
        Platform.runLater(()->{
            NameView.show(stage,controller);
           
            finish.showFinishView(playView.getScore(),topScore);
          
            }); 
    }



    @Override
    public boolean checkInput() {
        // TODO Auto-generated method stub
        Platform.runLater(()->{
            b = false;
            p.getScene().setOnKeyPressed(e->{
                if (e.getCode() == KeyCode.SPACE) {
                    
                    b = true;
                }
               
            });
        });
       
        return b;
    }



















    






   
  
     
    







}
