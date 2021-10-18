package model;

import java.awt.Point;
import java.util.Random;

public class DangerousColumn extends ColumnImp{
    
    private final Random random;
    private static final double minHeight = 50;
    private static final double maxHeight = 350;
    private boolean upDown;
    public DangerousColumn(Point position) {
        super(position);
        // TODO Auto-generated constructor stub
        this.upDown = false;
        random = new Random();
    }
    
    @Override
    public void updatePosition(Point position) {
        // TODO Auto-generated method stub
        
        if (random.nextDouble()<0.01) {
            
            setHeight();    
        }
        super.updatePosition(position);
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
