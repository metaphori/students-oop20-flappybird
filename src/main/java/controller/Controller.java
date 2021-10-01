package controller;



//controller gestisce tutto il gioco appena è partito
public interface Controller {
    
    void updateState();
    
    void setState(State state);
    
 

}
