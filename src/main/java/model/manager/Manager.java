package model.manager;

import java.util.List;

import javafx.scene.shape.Circle;
import model.Bird;
import model.Column;

public interface Manager {

    Bird getBird();

    void update(List<Column> list);
}
