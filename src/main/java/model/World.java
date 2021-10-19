package model;

import java.util.List;

import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;

public interface World {
    
    Integer getScore();
    
   
    Bird getBird();
    
    List<Column> getColumns();

    void update();


    void sendEvent(KeyEvent event);
   
    
    
    
    
    
    

}
