package model.manager;

import java.util.Iterator;
import java.util.List;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import model.Bird;
import model.Column;

public class ManagerCollisionImp implements ManagerCollision{

    private Bird bird;
    private Column listColumn;
    private List<Rectangle> object;
    private boolean result;
    
    public ManagerCollisionImp() {
        
        this.result= false;
    }
   

    @Override
    public boolean checkColumnCollision(List<Column> list, Bird bird) {
        // TODO Auto-generated method stub
      
       for(int i=0; i < list.size(); i++) {
          this.result= intersect(bird,list.get(i));
       }
        return false;
    }


    private boolean intersect(Bird bird2, Column column) {
        // TODO Auto-generated method stub
       
        return false;
    }


    @Override
    public boolean checkFloorCollision(Bird bird) {
        // TODO Auto-generated method stub
        if (bird.getCenterY() > 750) {
            return true;
        }
        else {
            return false;
        }
        
    }

}
