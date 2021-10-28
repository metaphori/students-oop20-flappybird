package model.manager;

import java.util.List;
import controller.Controller;
import controller.GameState;
import model.Bird;
import model.BirdImpl;
import model.Column;

public class ManagerBirdImpl implements ManagerBird{

    private Bird bird;
    private double height;
    private boolean input;
    private ManagerCollision collision;
    private ManagerJump jump;
    private ManagerGravity gravity;

    /**
     * This is the constructor method .
     * 
     */
    public ManagerBirdImpl(double floorPosition) {
        this.input= false;
        this.bird = new BirdImpl();
        this.collision= new ManagerCollisionImpl(floorPosition);
        this.jump= new ManagerJumpImpl();
        this.gravity= new ManagerGravityImpl(floorPosition);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void checkCollision(List<Column> list,Controller controller) {
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
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Bird getBird() {
        return this.bird;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void checkEvent(boolean input) {
        // TODO Auto-generated method stub
       this.input= input;
    }
}
