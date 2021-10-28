package model.manager;

import model.Bird;

public class ManagerJumpImpl implements ManagerJump{

    private double height;
    private double yJump;
    
    /**
     * This is the constructor method that initialize bird's height property and y coordinate of the jump.
     */
     public ManagerJumpImpl() {
         this.height = 0;
         this.yJump = 50;
    }

     /**
      * {@inheritDoc}
      */
     @Override
     public double jump(Bird b) {
         // TODO Auto-generated method stub
         if (!(b.getCenterY()- this.yJump<0)) {
             this.height= b.getCenterY()- this.yJump;
         }
         return this.height;
     }


}
