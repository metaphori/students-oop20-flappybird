package model;

import java.awt.Point;
import java.util.Random;

public class RandomColumn extends ColumnImp{
    
    private final Random random;
    private static final double minHeight = 50;
    private static final double maxHeight = 350;
    private double newHeight;
    

    public RandomColumn(Point position, double height) {
        
        
        super(position);
        newHeight= height;
        
        this.random = new Random();
        // TODO Auto-generated constructor stub
    }

    @Override
    public double updateHeight() {
        // TODO Auto-generated method stub

        return this.newHeight==0? (minHeight + (maxHeight - minHeight) * random.nextDouble()): this.newHeight;
    }

    



}
