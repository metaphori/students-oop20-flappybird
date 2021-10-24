package model;

import java.awt.Point;
import java.util.Random;

public class RandomColumn extends AbstractColumn{
    
    
    private static final double MIN_HEIGHT = 50;
    private static final double MAX_HEIGHT = 350;
    private final Random random;
    private double newHeight;
    

    public RandomColumn(Point position, boolean type,double height) {
        
        super(position,type);
        
        newHeight= height;
        
        this.random = new Random();
        
    }

    @Override
    public double updateHeight() {
       

        return this.newHeight==0? (MIN_HEIGHT + (MAX_HEIGHT - MIN_HEIGHT)* random.nextDouble()): this.newHeight;
    }

    



}
