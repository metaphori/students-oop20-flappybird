package model;

import controller.State;

public interface Model {

    void updateState(State gameState);
    
    double getGameHeight();
    
    double getGameWeidth();

    void updateGame();

    void startGame();

}
