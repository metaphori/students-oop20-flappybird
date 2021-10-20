package model.manager;

import java.util.List;

import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import model.Bird;
import model.Column;

public interface Manager {

    Bird getBird();

    void updateColumns(List<Column> list);

    void updateEvent(KeyEvent event);
}
