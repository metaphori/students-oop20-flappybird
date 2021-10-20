package model;

import java.util.List;

import controller.Controller;
import controller.ControllerImp;
import controller.GameState;
import model.file.Gamer;
import model.file.Leaderboard;
import model.file.LeaderboardManager;
import model.file.LeaderboardManagerImpl;
import model.loop.GameLoop;
import model.loop.GameLoopImp;

public class ModelImp implements Model {
    
    private static final double GAME_WORLD_WIDTH = 800;
    private static final double GAME_WORLD_HEIGHT = 600;
   
    private GameLoopImp gameLoop;
    private LeaderboardManager leaderboardManager;
    private Gamer gamer;
    private String score;
    
    
    
    
    
    public ModelImp(Controller controllerImp) {
        this.gameLoop = new GameLoopImp(controllerImp,GAME_WORLD_WIDTH,GAME_WORLD_HEIGHT);
        leaderboardManager = new LeaderboardManagerImpl();
    }

    @Override
    public void updateState(GameState gameState) {
        // TODO Auto-generated method stub 
    }

    @Override
    public double getGameHeight() {
 
        return GAME_WORLD_HEIGHT;
    }

    @Override
    public double getGameWeidth() {
      
        return GAME_WORLD_WIDTH;
    }

    @Override
    public void updateGame() {
       
        
    }

    @Override
    public void startGame() {
     
       
        this.gameLoop.setDaemon(true);
        this.gameLoop.start();
    }

    @Override
    public List<Gamer> getLeaderboard() {
     
       
        
               leaderboardManager.read();
        return leaderboardManager.getLeaderboard();
    }

    @Override
    public void gameOver(Integer score) {
      
        this.leaderboardManager.read();
        this.score = Integer.toString(score);
       
        
    }

    @Override
    public void addPlayer(String text) {
        
        gamer = new Gamer(text);
        gamer.setScore(score);
        this.leaderboardManager.addNewGamer(gamer);
        this.leaderboardManager.write();
    }

}
