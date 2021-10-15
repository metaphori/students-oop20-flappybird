package model;

public interface Bird extends ViewObject{

   void updatePosition(double posY);
   
   double getCenterX();
   
   double getCenterY();
   
   double getRadius();
}
