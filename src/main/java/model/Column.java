package model;

import java.awt.Rectangle;

/**
 * Represent a generic Column
 */
public interface Column extends GameObject {
    
    /**
     * Set the height of the column            
     */
   void setHeight();
    
   /**
    * Get the height of the column 
    * 
    * @return the height
    *              
    */
    double getHeigth();
    
    /**
     * Get the width of the column 
     * 
     * @return the width
     *              
     */
    double getWidth();
    
    /**
     * Get the rectangle which represent the column
     * 
     * @return the rectangle
     *              
     */
    Rectangle getColumn();
    
    /**
     * 
     * 
     * @return true if the column the type laser
     *              
     */
    boolean isLaserType();
    
    
    

}
