package model.manager;


import java.util.List;

import controller.Controller;
import controller.GameState;
import javafx.scene.input.KeyEvent;
import model.Bird;
import model.BirdImp;
import model.Column;

public class ManagerBirdImp implements ManagerBird{

    private Bird bird;
    private double height;
    boolean input;
    private ManagerCollision collision;
    private ManagerJump jump;
    private ManagerGravity gravity;
    KeyEvent eventJump;
    
    
    public ManagerBirdImp(double floorPosition) {
        
        input= false;
        this.bird = new BirdImp();
        this.collision= new ManagerCollisionImp();
        this.jump= new ManagerJumpImp();
        this.gravity= new ManagerGravityImp(floorPosition);
        
    }


    @Override
    public void checkCollision(List<Column> list,Controller controller) {
        // TODO Auto-generated method stub
      if (this.collision.checkColumnCollision(list,bird)) {
          System.out.println("state");
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
