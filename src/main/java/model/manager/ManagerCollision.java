package model.manager;

import java.util.List;
import model.Bird;
import model.Column;

public interface ManagerCollision {

    /**
     * Bird collision control with columns.
     * @param list of columns
     * @param bird Bird
     */
    boolean checkColumnCollision(List<Column> list, Bird bird);
    
    /**
     * Bird collision control with floor.
     * @param bird Bird
     */
    boolean checkFloorCollision(Bird bird);
}
