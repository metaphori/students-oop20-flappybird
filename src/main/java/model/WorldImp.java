package model;

import java.awt.Point;

import java.util.ArrayList;
import java.util.List;

import controller.Controller;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import model.generator.Generator;
import model.generator.ObstacleGenerator;
import model.manager.ManagerBird;
import model.manager.ManagerBirdImp;

public class WorldImp implements World{
    
    private static final double HEIGHT_FLOOR = 50;
    private ManagerBird manager;
    private Generator generator;
    private Score score;
    private double floorPosition;
    
    
   
    
    public WorldImp(double gameWorldWidth, double gameWorldHeight) {
        
        this.floorPosition = gameWorldHeight - HEIGHT_FLOOR;
        score = new ScoreImpl(this);
        this.generator = new ObstacleGenerator(gameWorldWidth, gameWorldHeight);
        
        this.manager = new ManagerBirdImp(floorPosition);
    }

   

    @Override
    public Integer getScore() {
        return this.score.getScore();
    }

   

   

  

    @Override
    public void update(boolean input, Controller controller) {
    
        this.generator.update();
        this.score.update();
        this.manager.checkEvent(input);
        this.manager.checkCollision(this.getColumns(),controller);
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
