package controller;


import java.util.List;

import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Column;
import model.Model;
import model.ModelImp;
import view.GamePane;

import view.View;
import view.ViewImp;

public class ControllerImp implements Controller{
    
    
    

    private State gameState;
    public Model model;
    public View view;
    Pane pane;
 
    public ControllerImp() {
        
        this.model = new ModelImp(this);
      //  this.view = new ViewImp();
        this.gameState = State.INITIALIZE;
       
    }

    @Override
    public void updateState() {
       
      //  System.out.println("ciaoo2-");
        switch (gameState) {
        case GAME_OVER:
          
            break;
        case INITIALIZE:
       //     System.out.println("ciaoo2");
            this.model.startGame();
           
            
            break;
        case PLAYING:
            this.model.updateGame();
            break;
        case READY:
            
            break;
            
        default:
            break;
        }
    }

    @Override
    public void setState(State state) {
        // TODO Auto-generated method stub
        
    }
    
    public void render() {
       
         //
       
          //  this.view.render();
        System.out.println("inizio a chiamare Platform.runLate()");
     Platform.runLater(()->{
         System.out.println("--dentro platform.runLater--");
           this.view.render();
           System.out.println("fine platform.runLater");
     });
       
   
       
        
    }

  

    @Override
    public void setPane(GamePane gamePane) {
        // TODO Auto-generated method stub
        pane = gamePane;
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
     
                this.view.render();
        
        
    }

    @Override
    public void start(String[] args, View view) {
        // TODO Auto-generated method stub
      //  System.out.println("ciaoo2--");
        view.set(this, args);
        this.updateState();
    }


  
   
    
  
    

 
          
               
             
   
 }




   
  

   