package controller;


import java.util.List;

import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Column;
import model.Model;
import model.ModelImp;


import view.View;
import view.ViewImp;

public class ControllerImp implements Controller{
    
    
    

    private GameState gameState;
    public Model model;
    public View view;
    Pane pane;
 
    public ControllerImp() {
        
        this.model = new ModelImp(this);
      //  this.view = new ViewImp();
        this.gameState = GameState.INITIALIZE;
       
    }

    @Override
    public void updateState() {
       
        System.out.println(gameState);
        switch (gameState) {
        case GAME_OVER:
            System.out.println("controll game over");
          this.view.gameOver();
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
    public void setState(GameState state) {
        // TODO Auto-generated method stub
        gameState = state;
    }
    
    public void render(List<Column> list) {
       
  
       
      
           this.view.render(list);
     
   
       
   
       
        
    }

  

   
    @Override
    public void update(View viewd) {
        // TODO Auto-generated method stub
     
        this.view = viewd;
        this.updateState();
        
    }

    @Override
    public void start(String[] args, View view) {
        // TODO Auto-generated method stub
    
        this.updateState();
    }

   


  
   
    
  
    

 
          
               
             
   
 }




   
  

   