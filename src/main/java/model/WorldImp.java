package model;

import java.awt.Point;

import java.util.ArrayList;
import java.util.List;

import model.generator.Generator;
import model.generator.ObstacleGenerator;

public class WorldImp implements World{
    
    
  
    private Generator generator;
    private Score score;
    
    
    public WorldImp(double gameWorldWidth, double gameWorldHeight) {
        
        score = new ScoreImpl(this);
        this.generator = new ObstacleGenerator(gameWorldWidth, gameWorldHeight);
    }

   

    @Override
    public Integer getScore() {
        return this.score.getScore();
    }

   

   

  

    @Override
    public void update() {
    
        this.generator.update();
        this.score.update();
    }



    @Override
    public List<Column> getColumns() {
        // TODO Auto-generated method stub
     
        return this.generator.getWorldElements();
        
    }
   
    

}
