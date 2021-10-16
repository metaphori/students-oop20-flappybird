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
        // TODO Auto-generated method stub
        return GAME_WORLD_HEIGHT;
    }

    @Override
    public double getGameWeidth() {
        // TODO Auto-generated method stub
        return GAME_WORLD_WIDTH;
    }

    @Override
    public void updateGame() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void startGame() {
        // TODO Auto-generated method stub
       
        this.gameLoop.setDaemon(true);
        this.gameLoop.start();
    }

    @Override
    public List<Gamer> getLeaderboard() {
        // TODO Auto-generated method stub
       
        
               leaderboardManager.read();
        return leaderboardManager.getLeaderboard();
    }

    @Override
    public void gameOver() {
        // TODO Auto-generated method stub
        this.leaderboardManager.read();
        this.leaderboardManager.addNewGamer("fra", "6");
        this.leaderboardManager.write();
        
    }

}
