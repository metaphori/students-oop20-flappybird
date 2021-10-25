package model;

import java.util.List;

import controller.Controller;
import controller.ControllerImpl;
import controller.GameState;
import model.file.Gamer;
import model.file.LeaderBoard;
import model.file.LeaderBoardManager;
import model.file.LeaderboardManagerImpl;
import model.loop.GameLoop;
import model.loop.GameLoopImpl;

/**
 * Implementation of the model
 */
public class ModelImp implements Model {
    
    private static final double GAME_WORLD_WIDTH = 800;
    private static final double GAME_WORLD_HEIGHT = 600;
    private GameLoopImpl gameLoop;
    private LeaderBoardManager leaderboardManager;
    private Gamer gamer;
    private String score;
    
    /**
     * Create a new model
     * 
     * @param controller
     *                   the controller of the game
     */
    public ModelImp(Controller controller) {
        this.gameLoop = new GameLoopImpl(controller,GAME_WORLD_WIDTH,GAME_WORLD_HEIGHT);
        leaderboardManager = new LeaderboardManagerImpl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getGameHeight() {
 
        return GAME_WORLD_HEIGHT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getGameWeidth() {
      
        return GAME_WORLD_WIDTH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startGame() {
        
        this.gameLoop.setDaemon(true);
        this.gameLoop.start();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Gamer> getLeaderboard() {
         
               leaderboardManager.read();
        return leaderboardManager.getLeaderboard();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void gameOver(Integer score) {
      
        this.leaderboardManager.read();
        this.score = Integer.toString(score);
    
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addPlayer(String text) {
        
        gamer = new Gamer(text);
        gamer.setScore(score);
        this.leaderboardManager.addNewGamer(gamer);
        this.leaderboardManager.write();
    }

}
