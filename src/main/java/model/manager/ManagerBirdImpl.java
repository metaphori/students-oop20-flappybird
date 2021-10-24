package model.manager;


import java.util.List;

import controller.Controller;
import controller.GameState;
import javafx.scene.input.KeyEvent;
import model.Bird;
import model.BirdImpl;
import model.Column;

public class ManagerBirdImpl implements ManagerBird{

    private Bird bird;
    private double height;
    boolean input;
    private ManagerCollision collision;
    private ManagerJump jump;
    private ManagerGravity gravity;
    KeyEvent eventJump;
    
    /**
     * This is the constructor method .
     * 
     */
    public ManagerBirdImpl(double floorPosition) {
        
        input= false;
        this.bird = new BirdImpl();
        this.collision= new ManagerCollisionImpl(floorPosition);
        this.jump= new ManagerJumpImpl();
        this.gravity= new ManagerGravityImpl(floorPosition);
        
    }


    @Override
    public void checkCollision(List<Column> list,Controller controller) {
        // TODO Auto-generated method stub
      if (this.collision.checkColumnCollision(list,bird)) {
          
            controller.setState(GameState.GAME_OVER);
            
        }
   
       if (input) {
            
            this.bird.updatePosition(this.jump.jump(bird));
            
        }
       
        if (this.collision.checkFloorCollision(bird)) {
           
           controller.setState(GameState.GAME_OVER);
           
       }
        
        this.bird.updatePosition(this.gravity.setGravity(bird));
    }
    
    @Override
    public Bird getBird() {
        // TODO Auto-generated method stub
        return this.bird;
    }


    @Override
    public void checkEvent(boolean input) {
        // TODO Auto-generated method stub
       this.input= input;
    }


}
