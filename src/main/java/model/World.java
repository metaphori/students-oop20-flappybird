package model;

import java.util.List;

import controller.Controller;

/**
 * Represent the interface that contains the world objects 
 */
public interface World {
    
    /**
     * @return the score
     */
    Integer getScore();
    
    /**
     * @return the bird
     */
    Bird getBird();
    
    /**
     * @return the list of columns
     */
    List<Column> getColumns();

    /**
     * Update the world objects
     * 
     * @param input
     *              true if was riceve an input
     * @param controller
     *                   the controller of the game
     */
    void update(boolean input, Controller controller);
}
