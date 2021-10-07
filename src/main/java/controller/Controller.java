package controller;

import java.util.List;

import javafx.stage.Stage;
import model.Column;
import view.GamePane;
import view.View;
import view.ViewImp;

//controller gestisce tutto il gioco appena è partito
public interface Controller {
    
   
    
    void setState(State state);

    void start(String[] args, View view);
    
   

    void render();

   

    void updateState();

    void setPane(GamePane gamePane);

    void update();
    
 

}
