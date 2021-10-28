package model.manager;

import model.Bird;
import model.BirdImpl;

public class ManagerGravityImpl implements ManagerGravity{

    private double yBird;
    private double floorPosition;
    private int yMotion;
    
    public ManagerGravityImpl(double floorPosition) {
       this.floorPosition = floorPosition;
       this.yMotion = 2;
    }

    /**
     * {@inheritDoc}
     */
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
        if (this.yBird > 0 && this.yBird < this.floorPosition) {
            this.yBird= this.yBird + this.yMotion;
        }
        return this.yBird; 
    }
}
