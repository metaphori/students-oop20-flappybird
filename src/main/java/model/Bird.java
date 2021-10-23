package model;

/**
 * Bird's Model Interface.
 */

public interface Bird {

    /**
     * Set Y coordinate of bird.
     * @param posY current Y coordinate of bird
     */
   void updatePosition(double posY);
   
   /**
   *
   * @return value of the property centerX of bird
   */
   double getCenterX();
   
   /**
   *
   * @return value of the property centerY of bird
   */
   double getCenterY();
   
   /**
   *
   * @return value of the property radius of bird
   */
   double getRadius();
}
