package model.manager;

import java.util.List;

import controller.Controller;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import model.Bird;
import model.Column;

public interface ManagerBird {

    /**
     * Get Bird.
     * @return bird defined.
     */
    Bird getBird();

    /**
     * Bird collision control.
     * @param list List of the column.
     * @param controller Controller.
     */
    void checkCollision(List<Column> list, Controller controller);

    void checkEvent(boolean input);

}
