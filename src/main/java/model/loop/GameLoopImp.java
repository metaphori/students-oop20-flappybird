package model.loop;

import java.util.List;

import controller.Controller;
import controller.ControllerImp;
import controller.GameState;
import javafx.application.Platform;
import model.Column;
import model.World;
import model.WorldImp;

public class GameLoopImp  extends Thread implements GameLoop{
    
    private World world;
    private static final long PERIOD = 20;
    private Controller controller;
    
    public GameLoopImp(Controller controllerImp, double gameWorldWidth, double gameWorldHeight) {
        // TODO Auto-generated constructor stub
        this.world = new WorldImp(gameWorldWidth,gameWorldHeight);
        this.controller = controllerImp;
    }

    @Override
    public void initiate() {
        // TODO Auto-generated method stub
        
    }
    
    public void run() {
        long lastTime = System.currentTimeMillis();
        long start = System.currentTimeMillis();
        boolean stop = true;
        while (stop) {
            final long current = System.currentTimeMillis();
            final long finish = System.currentTimeMillis();
            final int elapsed = (int) (current - lastTime);
            lastTime = current;
         
       
            this.world.update();
            
           this.controller.render(this.getColumn(), this.world.getScore());
           
           if (finish -start > 50000) {
               stop=false;
            
               this.controller.setState(GameState.GAME_OVER);
              
               this.controller.updateState();
           }
           waitNextFrame(current);
            
        }
    }

    private void waitNextFrame(final long current) {
        final long delta = System.currentTimeMillis() - current;
        if (delta < PERIOD) {
            try {
                
                Thread.sleep(PERIOD - delta);
                //Thread.sleep(1000);
            } catch (Exception ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

    

   

    @Override
    public List<Column> getColumn() {
        // TODO Auto-generated method stub
        return this.world.getColumns();
    }

    

}
