package model;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public  abstract class ColumnImp implements Column{
    
    private Rectangle column;
    private double height= 200;
    private static final double WEIGHT = 50;
 
    private String viewObject;
    
    
    
    public ColumnImp(Point position) {
        
       
        this.column = new Rectangle();
        this.column.setRect(position.getX(), position.getY(), height, WEIGHT);
    }

    @Override
    public void updatePosition(Point position) {
        // TODO Auto-generated method stub
        this.column.setLocation(position);
    }

    @Override
    public Point getPosition() {
        // TODO Auto-generated method stub
        return this.column.getLocation();
    }

    @Override
    public void setView(String view) {
        // TODO Auto-generated method stub
        this.viewObject = view;
    }


    @Override
    public double getHeigth() {
        // TODO Auto-generated method stub
        return this.height;
    }

    @Override
    public double getWidth() {
        // TODO Auto-generated method stub
        return this.WEIGHT;
    }
    
    //This is a themplate method
    public void setHeight() {
        this.height = this.height - this.updateHeight();
        
        
    }
    
    public Rectangle getColumn() {
        return this.column;
    }
    
    public abstract double updateHeight();
    
    
   
    

   

}
