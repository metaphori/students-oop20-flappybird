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
    private static double basemant = 250;
    private double basemantHeight;
    private int counterColumn;
    private static double space = 300;
  
    public OperationGenerateImpl(double gameWorldWidth, double gameWorldHeight ) {
        
        basemantHeight = gameWorldHeight-basemant;
        counterColumn =0;
        variable = false;
        this.upPosition = new Point();
        upPosition.setLocation(gameWorldWidth,0);
        
        this.downPosition = new Point();
        downPosition.setLocation(gameWorldWidth, basemantHeight);
        this.random = new Random();
     
    }

    @Override
    public Column getElement() {
        // TODO Auto-generated method stub
        
      //  this.column = createColumn();
        counterColumn++;
       // System.out.println(counterColumn);
            return this.column;
      
    }

    private Column createColumn() {
        // TODO Auto-generated method stub
        System.out.println("ciaoooo");
        double rand = random.nextDouble();
        if (counterColumn<10) {
            BasicColumn r = new BasicColumn(downPosition);
            return r;
        } else if (counterColumn<20) {
            BasicColumn r = new BasicColumn(upPosition);
            return r;
        } else if (counterColumn<40) {
            if (variable) {
                variable = false;
                BasicColumn r = new BasicColumn(upPosition);
                r.setHeight();
                return r;
            } 
            variable = true;
            
            BasicColumn r = new BasicColumn(downPosition);
            
           
            return r;
        }
        variable = true;
        
        BasicColumn r = new BasicColumn(downPosition);
        
       
        return r;
       
        
       // variable = true;
        
        //BasicColumn r = new BasicColumn(downPosition);
        
       
        //return r;
     /*   if (rand<0.5) {
            
            return new BasicColumn(upPosition);
        }
        return new RandomColumn(upPosition);
        */
    }

}
