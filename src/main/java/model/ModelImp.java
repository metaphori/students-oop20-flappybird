package model;

import controller.State;
import model.loop.GameLoop;
import model.loop.GameLoopImp;

public class ModelImp implements Model {
    
    private static final double GAME_WORLD_WIDTH = 800;
    private static final double GAME_WORLD_HEIGHT = 600;
    
    private GameLoopImp gameLoop;
    
    
    
    
    
    
    public ModelImp() {
        this.gameLoop = new GameLoopImp();
        this.gameLoop.initiate();
    }

    @Override
    public void updateState(State gameState) {
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
        this.gameLoop.startGameLoop();
    }

}
