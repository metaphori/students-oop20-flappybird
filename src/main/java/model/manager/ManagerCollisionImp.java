package model.manager;

import java.util.List;

import model.Bird;
import model.Column;

public class ManagerCollisionImp implements ManagerCollision{

    private Bird bird;
    private Column listColumn;
    
    public ManagerCollisionImp() {
        
    }
   

    @Override
    public boolean checkCollision(List<Column> list, Bird bird) {
        // TODO Auto-generated method stub
        return false;
    }

}
