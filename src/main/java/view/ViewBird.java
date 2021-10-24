package view;

import javafx.scene.image.Image;
import model.Bird;

/**
 * Bird's View interface.
 */
public interface ViewBird {

    /**
     * Render bird in the view.
     * @param b bird.
     */
    void render(Bird b);
    
    /**
     * Set circle's image.
     * @param img bird image
     */
    void setImage(Image img);
}
