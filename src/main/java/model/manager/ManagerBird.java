package model.manager;

import java.util.List;

import controller.Controller;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import model.Bird;
import model.Column;

public interface ManagerBird {

    Bird getBird();

    void checkCollision(List<Column> list, Controller controller);

    void checkEvent(boolean input);

}
