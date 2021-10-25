package controller;

import java.util.List;

import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.Bird;
import model.Column;
import model.file.Gamer;
import model.file.LeaderBoardManager;
import view.View;
import view.ViewImpl;

/**
 * The controller of the game
 */
public interface Controller {
    
    /**
     * Set the state of the game
     * 
     * @param state
     *              the next state
     */
    void setState(GameState state);

    /**
     * 
     * 
     * @param state
     *              the next state
     */
    void render(List<Column> list, Integer score, Bird circle);

   

    void updateState();

  

  

    List<Gamer> getLeaderboard();

    

    public double getGameHeight();
    
    public double getGameWidth();

    void savePlayer(String text);

    void checkInput();

    GameState getState();

    boolean jump();

    void setJump(boolean input);
    


}
