package model;

import java.awt.Point;
import java.util.Random;

public class LaserColumn extends AbstractColumn{
    
    
    private static final double MIN_HEIGHT = 50;
    private static final double MAX_HEIGHT = 350;
    private final Random random;
    private boolean upDownSwitch;
    private boolean typeUp;
    
    public LaserColumn(Point position, boolean type) {
        
        super(position,type);
     
        if (position.getY()==0) {
            this.typeUp=true;
        } else {
            this.typeUp=false;
        }
            
        
        this.upDownSwitch = false;
        this.random = new Random();
    }
    
    @Override
    public void updatePosition(Point position) {
      
        Point point = new Point();
        if (this.random.nextDouble()<0.01) {
            
            setHeight();    
        }
        if (!this.typeUp) {
            
            point.setLocation(position.getX(), 600-50-getHeigth());
        } else {
            point = position;
        }
        
        super.updatePosition(point);
    }

    @Override
    public double updateHeight() {
       
        if (this.upDownSwitch) {
            this.upDownSwitch = false;
            return MIN_HEIGHT;
        }
        this.upDownSwitch = true;
        return MAX_HEIGHT ;
    }
    
    

}
