package model.generator;

import java.util.List;

import model.Column;

/**
 * Interface of the column generator
 */
public interface Generator {
    
    /**
     * @return the list of columns in the world
     */
    List<Column> getWorldElements();
    
    /**
     * Update the postion of the columns
     */
    void update();
    
    
  
    
    

}
