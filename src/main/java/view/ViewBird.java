package view;

import javafx.scene.image.Image;
import model.Bird;

public interface ViewBird {

    void render(Bird b);
    
    void setImage(Image img);
}
