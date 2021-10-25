package model;

import java.awt.Point;

/**
 * Represent a generic object
 */
public interface GameObject {
    
    /**
     * Update the new position of the object
     * 
     * @param position
     *                 new point position of the object 
     *              
     */
    void updatePosition(Point position);
    
    /**
     * Get the new position of the object
     * 
     * @return the point position of the object
     *              
     */
    Point getPosition();
    
    
    
    

}
