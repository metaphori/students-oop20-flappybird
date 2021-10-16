package view;

import java.util.List;

import controller.Controller;
import controller.ControllerImp;
import controller.GameState;
import javafx.scene.shape.Circle;
import model.Bird;
import model.Column;

public interface View {

   

    // void set(Controller c, String[] args);
    
     void  render(List<Column> list, Integer score, Bird circle);

    void gameOver();

    void initiate();
    void update();

    

}
