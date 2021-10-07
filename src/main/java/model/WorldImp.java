package model;

import java.awt.Point;

import java.util.ArrayList;
import java.util.List;

import model.generator.Generator;
import model.generator.ObstacleGenerator;

public class WorldImp implements World{
    
    private List<ColumnImp> columList;
    private ColumnImp column;
    private Generator generator;
    
    
    public WorldImp(double gameWorldWidth, double gameWorldHeight) {
        this.columList= new ArrayList<>();
        this.column = new BasicColumn(new Point(800,0));
        this.generator = new ObstacleGenerator(gameWorldWidth, gameWorldHeight);
    }

   

    @Override
    public void addScore(Score score) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void updateScore() {
        // TODO Auto-generated method stub
        
    }

   

  

    @Override
    public void update() {
        // TODO Auto-generated method stub
      /*  double x = this.column.getPosition().getX();
        double y = this.column.getPosition().getY();
        Point a = new Point();
        a.setLocation(x-10, y);
        this.column.updatePosition(a);
        System.out.println(this.column.getPosition());
        */
        this.generator.update();
    }



    @Override
    public List<Column> getColumns() {
        // TODO Auto-generated method stub
     
        //return this.generator.getWorldElements();
        return null;
    }
   
    

}
