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
     * Call the view to render the updating
     * 
     * @param list
     *              the Column list
     *              
     * @param score
     *              the score
     *              
     *@param bird
     *            the bird                           
     */
    void render(List<Column> list, Integer score, Bird circle);

    /**
     * Update the state
     */
    void updateState();

    /**
     * @return the gameHeight
     */
    public double getGameHeight();
    
    /**
     * @return the gameWidth
     */
    public double getGameWidth();


    /**
     * Check if riceve input
     */
    void checkInput();

    /**
     * @return the gameState
     */
    GameState getState();

    boolean jump();

    /**
     * Set if jump
     */
    void setJump(boolean input);
    
    /**
     * @return the Controller LeaderBoard
     */
    ControllerLeaderBoard getLeaderBoardController();
    


}
