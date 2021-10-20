package model.manager;

import javafx.scene.input.KeyEvent;
import model.Bird;

public interface ManagerJump {

    boolean checkInput(KeyEvent e);

    double jump(Bird b);
    
    
   
}
