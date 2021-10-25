package view;

import java.util.List;
import java.util.Optional;

import controller.Controller;
import controller.ControllerImpl;
import controller.GameState;
import javafx.scene.shape.Circle;
import model.Bird;
import model.Column;

/**
 * The view of the game
 */
public interface View {

    /**
     * Update the view interface
     * 
     * @param list
     *             the list of columns
     * 
     * @param score
     *              the score
     *
     * @param bird
     *              the bird                        
     */
    void  render(List<Column> list, Integer score, Bird circle);

    /**
     * Set on the gameOver
     * 
     * @param topScore
     *                 the optional topScore
     */
    void gameOver(Optional<Integer> topScore);

    /**
     * initialize the views
     */
    void initiate();
    
    /**
     * start the game view
     */
    void playGame();

    /**
     * Check if there was an input
     */
    void checkInput();

    

}
