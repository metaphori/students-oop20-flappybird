package model.generator;

import java.awt.Point;
import java.util.Random;

import model.BasicColumn;
import model.Column;
import model.RandomColumn;

public class OperationGenerateImpl implements OperationGenerate{
    
    
   
    private Column column;
    private Point upPosition;
    private Random random;
  
    public OperationGenerateImpl(double gameWorldWidth, double gameWorldHeight ) {
        
        
        this.upPosition = new Point();
        upPosition.setLocation(gameWorldWidth,0);
        this.random = new Random();
     
    }

    @Override
    public Column getElement() {
        // TODO Auto-generated method stub
        this.column = createColumn();
            return this.column;
      
    }

    private Column createColumn() {
        // TODO Auto-generated method stub
        double rand = random.nextDouble();
        if (rand<0.5) {
            return new BasicColumn(upPosition);
        }
        return new RandomColumn(upPosition);
    }

}
