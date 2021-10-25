package controller;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javafx.application.Platform;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.Bird;
import model.Column;
import model.Model;
import model.ModelImp;
import model.file.Gamer;
import model.file.LeaderBoard;
import model.file.LeaderBoardManager;
import view.View;
import view.ViewImpl;

public class ControllerImpl implements Controller{
    
    
    

    private GameState gameState;

    private Model model;
    private View view;
    private Integer score;
    private boolean jump;

    
    Pane pane;
 
    public ControllerImpl(ViewImpl view) {
     
        this.view = view;
        this.model = new ModelImp(this);
     
        this.gameState = GameState.INITIALIZE;
        this.jump = false;
      
    }

    @Override
    public void updateState() {
       
  
        switch (gameState) {
        case GAME_OVER:
         
          this.model.gameOver(this.score);
          this.view.gameOver(topScorer());
            break;
        case INITIALIZE:
            this.model.startGame();
   
            break;
     
        default:
            break;
        }
    }

    private Optional<Integer> topScorer() {
        // TODO Auto-generated method stub
        Optional<Integer> topScor =this.model.getLeaderboard().stream().map(a->a.getScore()).map(a-> Integer.parseInt(a)).max((a,b)->a-b);
        
        
        return topScor;
    }

    @Override
    public void setState(GameState state) {
        
      
        gameState = state;
    }
    

    public void render(List<Column> list, Integer score, Bird bird) {
       
           this.score = score;
       
      
           this.view.render(list,score,bird);

     

        
    }

  

 
    

    @Override
    public List<Gamer> getLeaderboard() {
        // TODO Auto-generated method stub
       return this.model.getLeaderboard();
    }

    @Override

    public double getGameHeight() {
        // TODO Auto-generated method stub
        return this.model.getGameHeight();
    }

    @Override
    public double getGameWidth() {
        // TODO Auto-generated method stub
        return this.model.getGameWeidth();
    }

    @Override
    public void savePlayer(String text) {
        // TODO Auto-generated method stub
        this.model.addPlayer(text);
    }


    @Override
    public void checkInput() {
        
        // TODO Auto-generated method stub
        this.view.checkInput();
    }

    @Override
    public GameState getState() {
        // TODO Auto-generated method stub
        return this.gameState;
    }

    @Override
    public boolean jump() {
        // TODO Auto-generated method stub
        
        return this.jump;
    }

    @Override
    public void setJump(boolean input) {
        // TODO Auto-generated method stub
        this.jump = input;
    }

    
   


   


  
   
    
  
    

 
          
               
             
   
 }




   
  

   