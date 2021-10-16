package model.manager;

import java.util.List;

import model.Bird;
import model.Column;

public interface ManagerCollision {

    

    boolean checkCollision(List<Column> list, Bird bird);
}
