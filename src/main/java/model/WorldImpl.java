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
import model.manager.ManagerBirdImpl;

/**
 * 
 */
public class WorldImpl implements World{
    
    private static final double HEIGHT_FLOOR = 50;
    private ManagerBird manager;
    private Generator generator;
    private Score score;
    private double floorPosition;
    
    /**
     * Create a new World
     * 
     * @param gameWorldWidth
     *                       the width dimension of the world   
     *                                        
     * @param gameWorldHeight
     *                        the height dimension of the world
     */
    public WorldImpl(double gameWorldWidth, double gameWorldHeight) {
        
        this.floorPosition = gameWorldHeight - HEIGHT_FLOOR;
        score = new ScoreImpl(this);
        this.generator = new ObstacleGenerator(gameWorldWidth, gameWorldHeight);
        
        this.manager = new ManagerBirdImpl(floorPosition);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getScore() {
        return this.score.getScore();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(boolean input, Controller controller) {
    
        this.generator.update();
        this.score.update();
        this.manager.checkEvent(input);
        this.manager.checkCollision(this.getColumns(),controller);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Column> getColumns() {
      
        return this.generator.getWorldElements();
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Bird getBird() {
        // TODO Auto-generated method stub
        return this.manager.getBird();
    }


   
    

}
