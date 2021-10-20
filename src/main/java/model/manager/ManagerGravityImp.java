package model.manager;

import model.Bird;
import model.BirdImp;

public class ManagerGravityImp implements ManagerGravity{

    private Bird bird;
    private double y;
    private int ticks;
    
    public ManagerGravityImp() {
        
       
       
    }

    
    
    
    @Override
    public double setGravity(Bird b) {
        // TODO Auto-generated method stub
        y= b.getCenterY();
        fallBird();
        return y;
        
    
    }


    private double fallBird() {
        // TODO Auto-generated method stub
      /*  if (y == 790) {
            y= y -1;
        }
        else {
            y= y + 1; 
        }
        
        return y; */
        y= y + 1;   
        return y;
    }
}
