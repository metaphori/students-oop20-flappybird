package view;

import java.util.List;

import controller.Controller;
import controller.ControllerImp;
import controller.GameState;
import model.Column;

public interface View {

   

    // void set(Controller c, String[] args);
    
     void  render(List<Column> list, Integer score);

    void gameOver();

    void initiate();
    void update();

    

}
