package controller;

import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

//controller gestisce tutto il gioco appena è partito
public interface Controller {
    
    void setup();
  //  void mainLoop();
    
    void processInput();
   
    void update();
   
    void render();

}
