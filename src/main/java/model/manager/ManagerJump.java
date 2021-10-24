package model.manager;

import javafx.scene.input.KeyEvent;
import model.Bird;

public interface ManagerJump {

    /**
     * Increase the coordinate y of the bird.
     * @return bird's height.
     */
    double jump(Bird b);
    
    
   
}
