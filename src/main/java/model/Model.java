package model;

import java.util.List;

import controller.GameState;
import model.file.Gamer;
import model.file.LeaderboardManager;

public interface Model {

    void updateState(GameState gameState);
    
    double getGameHeight();
    
    double getGameWeidth();

    void updateGame();

    void startGame();

    List<Gamer> getLeaderboard();

    void gameOver(Integer score);

    void addPlayer(String text);

}
