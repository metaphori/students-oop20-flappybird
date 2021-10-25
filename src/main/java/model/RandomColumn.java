package model;

import java.awt.Point;
import java.util.Random;

/**
 * Represent a laser Column
 */
public class RandomColumn extends AbstractColumn{
    
    private static final double MIN_HEIGHT = 50;
    private static final double MAX_HEIGHT = 350;
    private final Random random;
    private double newHeight;
    
    /**
     * Create a new random column 
     * @param position
     *                  the point position of the new column
     * @param type
     *                  true if is a laserType                 
     */
    public RandomColumn(Point position, boolean type,double height) {
        
        super(position,type);
        
        newHeight= height;
        
        this.random = new Random();
        
    }
    
    /**
     * @return a new random height
     */
    @Override
    public double updateHeight() {
       

        return this.newHeight==0? (MIN_HEIGHT + (MAX_HEIGHT - MIN_HEIGHT)* random.nextDouble()): this.newHeight;
    }

    



}
