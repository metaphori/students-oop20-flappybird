package model.manager;

import model.Bird;
import model.BirdImp;

public class ManagerGravityImp implements ManagerGravity{

    private Bird bird;
    private double yBird;
    private double floorPosition;
    private int yMotion;
    
    public ManagerGravityImp(double floorPosition) {
        
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
