package model;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public  abstract class ColumnImp implements Column{
    
    private Rectangle column;
    private double height;
    private static final double WEIGHT = 50;
 
    private String viewObject;
    
    
    
    public ColumnImp(Point position) {
        
        this.height = 200;
        this.column = new Rectangle();
        this.column.setRect(position.getX(), position.getY(), WEIGHT, this.height );
    }

    @Override
    public void updatePosition(Point position) {
        
        this.column.setLocation(position);
    }

    @Override
    public Point getPosition() {
       
        return this.column.getLocation();
    }

    @Override
    public void setView(String view) {
        // TODO Auto-generated method stub
        this.viewObject = view;
    }


    @Override
    public double getHeigth() {
      
        return this.height;
    }

    @Override
    public double getWidth() {
      
        return ColumnImp.WEIGHT;
    }
    
    //This is a themplate method
    @Override
    public void setHeight() {
        
        this.height = this.updateHeight();
        
        
    }
    
    @Override
    public Rectangle getColumn() {
        return this.column;
    }
    
    public abstract double updateHeight();
    
    
   
    

   

}
