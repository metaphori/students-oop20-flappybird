package model.manager;

import java.util.List;

import model.Bird;
import model.Column;

public interface ManagerCollision {

    

    boolean checkColumnCollision(List<Column> list, Bird bird);

    boolean checkFloorCollision(Bird bird);
}
