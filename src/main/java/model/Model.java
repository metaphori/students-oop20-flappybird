package model;

import java.util.List;

import controller.GameState;
import model.file.Gamer;
import model.file.LeaderboardManager;

/**
 * The interface of the Score
 */
public interface Model {

    /**
     * return the height of the world
     */
    double getGameHeight();
    
    /**
     * return the weidth of the world
     */
    double getGameWeidth();

    /**
     * Start a new Game
     */
    void startGame();

    /**
     * @return the leaderboard
     */
    List<Gamer> getLeaderboard();

    /**
     * Set when is game over
     * 
     * @param score
     *              the final score of the player
     *           
     */
    void gameOver(Integer score);

    /**
     * Add a new Player to the leaderBoard
     * 
     * @param name
     *             the string name of the player
     */
    void addPlayer(String name);

}
