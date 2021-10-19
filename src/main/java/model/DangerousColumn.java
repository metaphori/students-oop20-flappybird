package model;

import java.awt.Point;
import java.util.Random;

public class DangerousColumn extends ColumnImp{
    
    private final Random random;
    private static final double minHeight = 50;
    private static final double maxHeight = 350;
    
    private boolean upDown;
    private boolean typeUp;
    public DangerousColumn(Point position) {
        
        super(position);
        // TODO Auto-generated constructor stub
        if (position.getY()==0) {
            typeUp=true;
        } else {
            typeUp=false;
        }
            
        
        this.upDown = false;
        random = new Random();
    }
    
    @Override
    public void updatePosition(Point position) {
        // TODO Auto-generated method stub
        Point point = new Point();
        if (random.nextDouble()<0.01) {
            
            setHeight();    
        }
        if (!typeUp) {
            
            point.setLocation(position.getX(), 600-50-getHeigth());
        } else {
            point = position;
        }
        
        super.updatePosition(point);
    }

    @Override
    public double updateHeight() {
        // TODO Auto-generated method stub
        if (upDown) {
            upDown = false;
            return minHeight;
        }
        upDown = true;
        return maxHeight ;
    }
    
    

}
