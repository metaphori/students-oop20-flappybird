package model.generator;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import model.Column;

public class ObstacleGenerator implements Generator{
    
    private List<Column> obstacles;
    private OperationGenerate suppler;
    private static final double SPACECOLUMN = 200;
    private double startNext;
    private boolean first = true;
    
    
    

    
    public ObstacleGenerator(double gameWorldWidth, double gameWorldHeight) {
        this.obstacles = new ArrayList<>();
        this.suppler = new OperationGenerateImpl(gameWorldWidth,gameWorldHeight);
        this.startNext = gameWorldWidth - SPACECOLUMN;
    }

    @Override
    public List<Column> getWorldElements() {
        // TODO Auto-generated method stub
        return this.obstacles;
    }


    private void addElement() {
        // TODO Auto-generated method stub
        this.obstacles.add(suppler.getElement());
    }
   

    
    private void removeElement() {
        // TODO Auto-generated method stub
       // this.obstacles.remove(element);
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        
        if(first) {
            addElement();
            first=false;
        }
        if (this.checkDistance()) {
            addElement();
          //  addElement(UpsideDown.DOWN);
            
        }
        System.out.println(this.obstacles.size());
       /* Point p = new Point();
        p.setLocation(this.obstacles.get(0).getPosition());
        p.translate(-10, 0);
        this.obstacles.get(0).updatePosition(p);*/
        this.obstacles.forEach(a->{
            Point c = new Point();
            c.setLocation(a.getPosition());
            c.translate(-10, 0);
            a.updatePosition(c);
        });
        
   
        
    }
    
    private boolean checkDistance() {
        
        
               Column col= this.obstacles.get(this.obstacles.size()-1);
              
               System.out.println(col.getPosition().getX());
                return col.getPosition().getX() < startNext;
        
    }

   

}
