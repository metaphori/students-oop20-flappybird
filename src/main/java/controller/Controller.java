package controller;

import java.util.List;
import model.Bird;
import model.Column;

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
    
     * @param cicle
     *              the bird
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
    double getGameHeight();
    
    /**
     * @return the gameWidth
     */
    double getGameWidth();

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
