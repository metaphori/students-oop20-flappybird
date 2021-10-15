package controller;

import java.util.List;

import javafx.stage.Stage;
import model.Bird;
import model.Column;
import model.file.Gamer;
import model.file.LeaderboardManager;
import view.View;
import view.ViewImp;

//controller gestisce tutto il gioco appena è partito
public interface Controller {
    
   
    
    void setState(GameState state);

    void start(String[] args, View view);
    
   

    void render(List<Column> list, Integer score, Bird bird);

   

    void updateState();

  

    void update(View viewImp);

    List<Gamer> getLeaderboard();
    
 

}
