package model.loop;

import model.World;
import model.WorldImp;

public class GameLoopImp  extends Thread implements GameLoop{
    
    private World world;
    private static final long PERIOD = 50;
    
    @Override
    public void initiate() {
        // TODO Auto-generated method stub
        this.world = new WorldImp();
    }
    
    public void run() {
        long lastTime = System.currentTimeMillis();
        while (true) {
            final long current = System.currentTimeMillis();
            final int elapsed = (int) (current - lastTime);
            lastTime = current;
       
            this.world.update();
           
            
                waitNextFrame(current);
            
        }
    }

    private void waitNextFrame(final long current) {
        final long delta = System.currentTimeMillis() - current;
        if (delta < PERIOD) {
            try {
                Thread.sleep(PERIOD - delta);
            } catch (Exception ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

    

    @Override
    public void startGameLoop() {
        // TODO Auto-generated method stub
        
        this.start();
    }

    

}
