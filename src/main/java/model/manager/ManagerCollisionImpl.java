package model.manager;

import java.awt.Point;
import java.util.List;
import model.Bird;
import model.Column;

public class ManagerCollisionImpl implements ManagerCollision{

    private boolean result;
    private double posy;
    private double floorPosition;
    
    public ManagerCollisionImpl(double floorPosition) {
        this.result= false;
        this.floorPosition = floorPosition;
    }
   
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean checkColumnCollision(List<Column> list, Bird bird) {
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
        Point position = column.getPosition();
        if (circleBird.getCenterX() + circleBird.getRadius() > position.getX() && circleBird.getCenterX() + circleBird.getRadius() < position.getX() + column.getWidth() && 
            circleBird.getCenterY() + circleBird.getRadius() > position.getY() && circleBird.getCenterY() + circleBird.getRadius() < position.getY() + column.getHeigth()) {
            
            return true;
            
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean checkFloorCollision(Bird bird) {
        this.posy = bird.getCenterY() + bird.getRadius();
       
        if (posy >= floorPosition) {
            return true;
        }
        else {
            return false;
        }
    }

}
