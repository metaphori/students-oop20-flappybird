package model;


import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

public class Entity implements GameObject, ImageObject{
    
    private Point entity;
    private Image image;
    
    
 
    
    public Entity(Point pos) {
        
      this.entity = new Point(pos);
    }

    @Override
    public void addImage(Image image) {
        // TODO Auto-generated method stub
        this.image = image;
    }

   

 
  

    @Override
    public Point getPosition() {
        // TODO Auto-generated method stub
        return this.entity.getLocation();
    }

    @Override
    public void update(Point pos) {
        // TODO Auto-generated method stub
        this.entity.setLocation(pos);
    }

   
}
