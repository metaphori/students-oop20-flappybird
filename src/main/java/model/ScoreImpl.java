package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class ScoreImpl implements Score {
    
    private World world;
    private Integer score;
    private double flyPosX;
    private List<Column> columnList;
    
    /**
     * Create a new Score
     * 
     * @param world
     *              the world which contains the game objects 
     */
    public ScoreImpl(World world) {
        
        
        this.flyPosX = 0;
        this.columnList = new ArrayList<>();
        this.score = 0;
        this.world = world;
        
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
       
        this.flyPosX = world.getBird().getCenterX();
        if (!this.world.getColumns().isEmpty()) {
           this.world.getColumns().forEach(a->{
               if (!columnList.contains(a) && a.getPosition().getX()<flyPosX) {
                   columnList.add(a);
                   score++;
                   System.out.println(score);
               }
           });
           
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getScore() {
        return score;
    }

}
