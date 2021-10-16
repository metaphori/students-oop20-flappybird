package model.manager;


import java.util.List;

import model.Bird;
import model.BirdImp;
import model.Column;

public class ManagerBird implements Manager{

    private Bird bird;
    private double height;
    private ManagerCollision collision;
    private ManagerJump jump;
    private ManagerGravity gravity;
    
    public ManagerBird() {
        
       
        this.bird = new BirdImp();
        this.collision= new ManagerCollisionImp();
        this.jump= new ManagerJumpImp();
        this.gravity= new ManagerGravityImp();
        
    }


    @Override
    public void update(List<Column> list) {
        // TODO Auto-generated method stub
        if (this.collision.checkCollision(list,bird)) {
            
            
        }
        else if (this.jump.checkInput()) {
            
        }
        else {
            this.gravity.setGravity();
        }
       
    }
    
    @Override
    public Bird getBird() {
        // TODO Auto-generated method stub
        return this.bird;
    }
}
