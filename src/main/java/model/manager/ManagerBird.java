package model.manager;


import java.util.List;

import javafx.scene.input.KeyEvent;
import model.Bird;
import model.BirdImp;
import model.Column;

public class ManagerBird implements Manager{

    private Bird bird;
    private double height;
    private ManagerCollision collision;
    private ManagerJump jump;
    private ManagerGravity gravity;
    KeyEvent eventJump;
    
    public ManagerBird() {
        
       
        this.bird = new BirdImp();
        this.collision= new ManagerCollisionImp();
        this.jump= new ManagerJumpImp();
        this.gravity= new ManagerGravityImp();
        
    }


    @Override
    public void updateColumns(List<Column> list) {
        // TODO Auto-generated method stub
       /* if (this.collision.checkColumnCollision(list,bird)) {
        * 
            //game over
            
        }
        else if (this.collision.checkFloorCollision(bird)) {
        
            //game over
        
        }
        else if (this.jump.checkInput(e)) {
           
            this.bird.updatePosition(this.jump.jump(bird));
        }
        else {
            
         this.bird.updatePosition(this.gravity.setGravity(bird));
        } */
     
        
        
    }
    
    @Override
    public Bird getBird() {
        // TODO Auto-generated method stub
        return this.bird;
    }


    @Override
    public void updateEvent(KeyEvent event) {
        // TODO Auto-generated method stub
        this.eventJump = event;
    }
}
