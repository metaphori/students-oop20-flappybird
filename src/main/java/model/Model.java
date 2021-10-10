package model;

import controller.GameState;

public interface Model {

    void updateState(GameState gameState);
    
    double getGameHeight();
    
    double getGameWeidth();

    void updateGame();

    void startGame();

}
