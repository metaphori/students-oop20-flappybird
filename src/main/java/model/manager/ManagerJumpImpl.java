package model.manager;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.Bird;
import model.BirdImpl;

public class ManagerJumpImpl implements ManagerJump{

    private double height;
    private double yJump;
    private String codeString;
    
    
    /**
     * This is the constructor method that initialize bird's height property and y coordinate of the jump.
     */
     public ManagerJumpImpl() {
        // TODO Auto-generated constructor stub
         this.height = 0;
         this.yJump = 50;
      
    }

     @Override
     public double jump(Bird b) {
         // TODO Auto-generated method stub
         if (!(b.getCenterY()- yJump<0)) {
             this.height= b.getCenterY()- yJump;
         }
         return this.height;
     }


}
