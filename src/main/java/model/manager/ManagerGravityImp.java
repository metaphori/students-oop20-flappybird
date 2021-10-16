package model.manager;

import model.Bird;
import model.BirdImp;

public class ManagerGravityImp implements ManagerGravity{

    private Bird bird;
    private double height;
    
    public ManagerGravityImp() {
        
        this.bird = new BirdImp();
        height = this.bird.getCenterY();
    }

    @Override
    public void setGravity() {
        // TODO Auto-generated method stub
        height = height + 1;
        this.bird.updatePosition(height);
    }
}
