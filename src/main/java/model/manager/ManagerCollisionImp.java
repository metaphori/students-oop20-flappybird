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

public class ManagerCollisionImp implements ManagerCollision{

    private Bird bird;
    private Column listColumn;
    private List<Rectangle> object;
    private boolean result;
    private double posy;
    private double floorPosition;
    
    public ManagerCollisionImp(double floorPosition) {
        
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


    private boolean intersect(Bird circleBird, Column column) {
        // TODO Auto-generated method stub
        Point position = column.getPosition();
        if (circleBird.getCenterX() > position.getX() && circleBird.getCenterX() < position.getX() + column.getWidth() && 
            circleBird.getCenterY() > position.getY() && circleBird.getCenterY() < position.getY() + column.getHeigth()) {
            System.out.println("return true");
            return true;
            
        }
        
        return false;
    }


    @Override
    public boolean checkFloorCollision(Bird bird) {
        // TODO Auto-generated method stub
        this.posy = bird.getCenterY() + bird.getRadius();
        System.out.println(posy);
        if (posy >= floorPosition) {
            return true;
        }
        else {
            return false;
        }
        
    }

}
