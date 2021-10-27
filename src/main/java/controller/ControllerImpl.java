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
import model.file.Leaderboard;
import model.file.LeaderboardManager;
import view.View;
import view.ViewImpl;

public class ControllerImpl implements Controller{
    
    private GameState gameState;
    private Model model;
    private View view;
    private Integer score;
    private boolean jump;
    private Pane pane;
    private ControllerLeaderBoard clb;
 
    public ControllerImpl(ViewImpl view) {
     
        this.view = view;
        this.model = new ModelImp(this);
        this.clb = new ControllerLeaderBoardImpl(model);
        this.gameState = GameState.INITIALIZE;
        this.jump = false;
      
    }

    /**
     * {@inheritDoc}
     */
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
        Optional<Integer> topScor =this.model.getLeaderboard().stream()
                .map(a->a.getScore()).map(a-> Integer.parseInt(a)).max((a,b)->a-b);
        return topScor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setState(GameState state) {

        this.gameState = state;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void render(List<Column> list, Integer score, Bird bird) {       
           this.score = score;
           this.view.render(list,score,bird);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getGameHeight() {
        // TODO Auto-generated method stub
        return this.model.getGameHeight();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public double getGameWidth() {
        // TODO Auto-generated method stub
        return this.model.getGameWeidth();
    }
   
 
    /**
     * {@inheritDoc}
     */
    @Override
    public void checkInput() {
        
        // TODO Auto-generated method stub
        this.view.checkInput();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameState getState() {
        // TODO Auto-generated method stub
        return this.gameState;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean jump() {
        // TODO Auto-generated method stub
        
        return this.jump;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setJump(boolean input) {
        // TODO Auto-generated method stub
        this.jump = input;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ControllerLeaderBoard getLeaderBoardController() {
        // TODO Auto-generated method stub
        return this.clb;
    }

 }




   
  

   