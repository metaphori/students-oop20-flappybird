package controller;

import java.util.List;
import model.file.Gamer;

/**
 * The controller of the leaderBoard
 */
public interface ControllerLeaderBoard { 
    
    /**
     * @return the list of gamer
     */
    List<Gamer> getLeaderBoard();

    /**
     * Save a player on leaderBoard
     * 
     * @param name
     *             name of the player
     */
    void savePlayer(String name);
}
