package model;

import java.util.List;

public interface World {
    
    Integer getScore();
    
   
    Bird getBird();
    
   List<Column> getColumns();

    void update();
   
    
    
    
    
    
    

}
