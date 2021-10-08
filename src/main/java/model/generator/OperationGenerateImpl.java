package model.generator;

import java.awt.Point;
import java.util.Random;

import model.BasicColumn;
import model.Column;
import model.RandomColumn;

public class OperationGenerateImpl implements OperationGenerate{
    
    
   
    private Column column;
    private Point upPosition;
    private Point downPosition;
    private Random random;
    private boolean variable;
  
    public OperationGenerateImpl(double gameWorldWidth, double gameWorldHeight ) {
        
        variable = false;
        this.upPosition = new Point();
        upPosition.setLocation(gameWorldWidth,0);
        
        this.downPosition = new Point();
        downPosition.setLocation(gameWorldWidth, gameWorldHeight-250);
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
        System.out.println(rand);
        if (false) {
            variable = true;
            return new BasicColumn(upPosition);
        }
        variable = false;
        return new BasicColumn(downPosition);
     /*   if (rand<0.5) {
            
            return new BasicColumn(upPosition);
        }
        return new RandomColumn(upPosition);
        */
    }

}
