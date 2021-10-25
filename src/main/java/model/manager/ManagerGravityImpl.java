package model.manager;

import model.Bird;
import model.BirdImpl;

public class ManagerGravityImpl implements ManagerGravity{

    private Bird bird;
    private double yBird;
    private double floorPosition;
    private int yMotion;
    
    public ManagerGravityImpl(double floorPosition) {
        
       this.floorPosition = floorPosition;
       this.yMotion = 2;
       
    }

    
    @Override
    public double setGravity(Bird b) {
        // TODO Auto-generated method stub
        this.yBird= b.getCenterY();
        fallBird();
        return this.yBird;
        
    
    }

    /**
     * Control the coordinate y of the bird to apply gravity.
     * @return yBird of the bird
     */
    private double fallBird() {
        // TODO Auto-generated method stub
        if (yBird > 0 && yBird < floorPosition) {
            this.yBird= yBird + yMotion;
        }
        else {
            this.yBird= yBird; 
        }
        
        return this.yBird; 
     
    }
}
