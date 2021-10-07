package model.loop;

import java.util.List;

import controller.Controller;
import controller.ControllerImp;
import javafx.application.Platform;
import model.Column;
import model.World;
import model.WorldImp;

public class GameLoopImp  extends Thread implements GameLoop{
    
    private World world;
    private static final long PERIOD = 50;
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
        while (true) {
            final long current = System.currentTimeMillis();
            final int elapsed = (int) (current - lastTime);
            lastTime = current;
         //  System.out.println("ok");
           // this.world.update();
            //this.controller.render(this.world.getColumns());
            System.out.println("inizio ciclo while gameloop");
                
                this.controller.render();
                System.out.println(" fine ciclo while gameloop");
            
            
        
                waitNextFrame(current);
            
        }
    }

    private void waitNextFrame(final long current) {
        final long delta = System.currentTimeMillis() - current;
        if (delta < PERIOD) {
            try {
                
               // Thread.sleep(PERIOD - delta);
                Thread.sleep(1000);
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
