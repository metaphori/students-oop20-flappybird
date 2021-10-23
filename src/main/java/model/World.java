package model;

import java.util.List;

import controller.Controller;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;

public interface World {
    
    Integer getScore();
    
   
    Bird getBird();
    
    List<Column> getColumns();

    void update(boolean b, Controller controller);


   
    
    
    
    
    
    

}
