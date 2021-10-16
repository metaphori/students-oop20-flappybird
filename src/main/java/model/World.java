package model;

import java.util.List;

import javafx.scene.shape.Circle;

public interface World {
    
    Integer getScore();
    
   
    Bird getBird();
    
   List<Column> getColumns();

    void update();
   
    
    
    
    
    
    

}
