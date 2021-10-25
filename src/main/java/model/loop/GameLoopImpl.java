package model.loop;

import java.util.List;

import controller.Controller;
import controller.ControllerImpl;
import controller.GameState;
import javafx.application.Platform;
import model.Bird;
import model.Column;
import model.World;
import model.WorldImpl;

/**
 * Rappresent the GameLoop
 */
public class GameLoopImpl  extends Thread implements GameLoop{
    
    private static final long PERIOD = 20;
    private World world; 
    private Controller controller;
    
    /**
     * Create the gameloop
     * 
     * @param controller
     *                  the controller
     *
     * @param gameWorldWidth
     *                       the gameWorldWidth
     *
     * @param gameWorldHeight
     *                        gameWorldHeight                              
     */
    public GameLoopImpl(Controller controller, double gameWorldWidth, double gameWorldHeight) {
    
        this.world = new WorldImpl(gameWorldWidth,gameWorldHeight);
        this.controller = controller;
    }

    /**
     * {@inheritDoc}
     */
    public void run() {
        long lastTime = System.currentTimeMillis();
        long start = System.currentTimeMillis();
        boolean stop = true;
        while (stop) {
            final long current = System.currentTimeMillis();
            final long finish = System.currentTimeMillis();
            final int elapsed = (int) (current - lastTime);
            lastTime = current;
            
            this.controller.checkInput();
            this.world.update(this.controller.jump(),controller);
            this.controller.setJump(false);
            
           this.controller.render(this.getColumns(), this.world.getScore(), this.world.getBird());
           

           if (this.controller.getState() == GameState.GAME_OVER) {

               stop=false;                             
           }
           waitNextFrame(current);
            
        }
        this.controller.updateState();
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

    

   
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Column> getColumns() {
        // TODO Auto-generated method stub
        return this.world.getColumns();
    }

  
    

}
