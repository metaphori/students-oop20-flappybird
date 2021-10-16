package model.manager;


import java.util.List;

import model.Bird;
import model.BirdImp;
import model.Column;

public class ManagerBird implements Manager{

    private Bird bird;
    private double height;
    private ManagerCollision collision;
    
    public ManagerBird() {
        
       
        this.bird = new BirdImp();
        height = this.bird.getCenterY();
        this.collision= new ManagerCollision();
        
    }


    @Override
    public void update(List<Column> list) {
        // TODO Auto-generated method stub
        if (this.collision.checkCollision(list,bird)) {
            
        }
       
        height = height + 1;
        this.bird.updatePosition(height);
    }
    
    @Override
    public Bird getBird() {
        // TODO Auto-generated method stub
        return this.bird;
    }
}
