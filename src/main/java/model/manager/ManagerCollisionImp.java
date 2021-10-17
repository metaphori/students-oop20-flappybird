package model.manager;

import java.util.List;

import javafx.scene.shape.Rectangle;
import model.Bird;
import model.Column;

public class ManagerCollisionImp implements ManagerCollision{

    private Bird bird;
    private Column listColumn;
    private List<Rectangle> object;
    
    public ManagerCollisionImp() {
        
    }
   

    @Override
    public boolean checkCollision(List<Column> list, Bird bird) {
        // TODO Auto-generated method stub
        
        return false;
    }

}
