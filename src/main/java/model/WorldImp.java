package model;

import java.awt.Point;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.shape.Circle;
import model.generator.Generator;
import model.generator.ObstacleGenerator;
import model.manager.Manager;
import model.manager.ManagerBird;

public class WorldImp implements World{
    
    
    private Manager manager;
    private Generator generator;
    private Score score;
    
   
    
    public WorldImp(double gameWorldWidth, double gameWorldHeight) {
        
        score = new ScoreImpl(this);
        this.generator = new ObstacleGenerator(gameWorldWidth, gameWorldHeight);
        
        this.manager = new ManagerBird();
    }

   

    @Override
    public Integer getScore() {
        return this.score.getScore();
    }

   

   

  

    @Override
    public void update() {
    
        this.generator.update();
        this.score.update();
        this.manager.update(getColumns());
    }



    @Override
    public List<Column> getColumns() {
        // TODO Auto-generated method stub
     
        return this.generator.getWorldElements();
        
    }



    @Override
    public Bird getBird() {
        // TODO Auto-generated method stub
        return this.manager.getBird();
    }
   
    

}
