package model;

import java.awt.Point;
import java.util.Random;

public class RandomColumn extends ColumnImp{
    
    private final Random random;
    private static final double minHeight = 0;
    private static final double maxHeight = 150;
    

    public RandomColumn(Point position) {
        super(position);
        
        this.random = new Random();
        // TODO Auto-generated constructor stub
    }

    @Override
    public double updateHeight() {
        // TODO Auto-generated method stub
        return (minHeight + (maxHeight - minHeight) * random.nextDouble());
    }

    



}
