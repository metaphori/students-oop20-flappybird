package model;

import java.awt.Point;
import java.util.Random;

public class DangerousColumn extends ColumnImp{
    
    
    private static final double MIN_HEIGHT = 50;
    private static final double MAX_HEIGHT = 350;
    private final Random random;
    private boolean upDown;
    private boolean typeUp;
    
    public DangerousColumn(Point position) {
        
        super(position);
     
        if (position.getY()==0) {
            this.typeUp=true;
        } else {
            this.typeUp=false;
        }
            
        
        this.upDown = false;
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
       
        if (this.upDown) {
            this.upDown = false;
            return MIN_HEIGHT;
        }
        this.upDown = true;
        return MAX_HEIGHT ;
    }
    
    

}
