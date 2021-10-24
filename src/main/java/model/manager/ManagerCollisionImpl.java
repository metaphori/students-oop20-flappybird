package model.manager;

import java.util.Iterator;
import java.awt.Point;
import java.util.List;


import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import model.Bird;
import model.Column;

public class ManagerCollisionImpl implements ManagerCollision{

    private Bird bird;
    private Column listColumn;
    private List<Rectangle> object;
    private boolean result;
    private double posy;
    private double floorPosition;
    
    public ManagerCollisionImpl(double floorPosition) {
        
        this.result= false;
        this.floorPosition = floorPosition;
    }
   

    @Override
    public boolean checkColumnCollision(List<Column> list, Bird bird) {
        // TODO Auto-generated method stub
           
           list.forEach(l->{
              if(intersect(bird, l)) {
                  result = true;
              };
               
           });
       
          return result;
     
    }

    /**
     * Control the intersection between bird and columns.
     * @param bird Bird
     * @param column Column
     */
    private boolean intersect(Bird circleBird, Column column) {
        // TODO Auto-generated method stub
        Point position = column.getPosition();
        if (circleBird.getCenterX() + circleBird.getRadius() > position.getX() && circleBird.getCenterX() + circleBird.getRadius() < position.getX() + column.getWidth() && 
            circleBird.getCenterY() + circleBird.getRadius() > position.getY() && circleBird.getCenterY() + circleBird.getRadius() < position.getY() + column.getHeigth()) {

            return true;
            
        }
        
        return false;
    }


    @Override
    public boolean checkFloorCollision(Bird bird) {
        // TODO Auto-generated method stub
        this.posy = bird.getCenterY() + bird.getRadius();
       
        if (posy >= floorPosition) {
            return true;
        }
        else {
            return false;
        }
        
    }

}
