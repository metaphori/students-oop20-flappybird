package controller;


//controller gestisce tutto il gioco appena è partito
public interface Controller {
    
    
    void mainLoop();
    
    void processInput();
   
    void update();
   
    void render();

}
