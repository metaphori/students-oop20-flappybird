package model.manager;

import model.Bird;
import model.BirdImp;

public class ManagerGravityImp implements ManagerGravity{

    private Bird bird;
    private double yBird;
    private int ticks;
    private double floorPosition;
    private int yMotion;
    
    public ManagerGravityImp(double floorPosition) {
        
       this.floorPosition = floorPosition;
       this.yMotion = 1;
       
    }

    
    
    
    @Override
    public double setGravity(Bird b) {
        // TODO Auto-generated method stub
        this.yBird= b.getCenterY();
        fallBird();
        return this.yBird;
        
    
    }


    private double fallBird() {
        // TODO Auto-generated method stub
        if (yBird > 0 && yBird < floorPosition) {
            this.yBird= yBird +1;
        }
        else {
            this.yBird= yBird; 
        }
        
        return this.yBird; 
     
    }
}
