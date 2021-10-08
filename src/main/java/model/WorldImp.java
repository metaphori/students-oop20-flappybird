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
    
        this.generator.update();
    }



    @Override
    public List<Column> getColumns() {
        // TODO Auto-generated method stub
     
        return this.generator.getWorldElements();
        
    }
   
    

}
