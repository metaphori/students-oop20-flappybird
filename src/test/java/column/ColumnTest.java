package column;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.awt.Point;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.BasicColumn;
import model.Column;
import model.generator.GameStep;
import model.generator.Generator;
import model.generator.ObstacleGenerator;

public class ColumnTest {
    
    
    private static final double GAME_WORLD_WIDTH = 800;
    private static final double GAME_WORLD_HEIGHT = 600;
    private static final double SPACECOLUMN = 200;
    private double startNext;
    private GameStep gameStep;
    private Point upPosition;
    private double countColumn;
    private Point downPosition;
    private static double basemant = 250;
    private static final double interspace = 150;
    private double basemantHeight;
    
    
 
    private void update(Generator generator) {
     
        for (int i=0; i<101; i++) {
            generator.update();
        }
    }
    @Test
     public void testAddingColumns() {
        Generator generator = new ObstacleGenerator(GAME_WORLD_WIDTH, GAME_WORLD_HEIGHT);
        
        assertEquals(0, generator.getWorldElements().size());
        generator.update();
        assertEquals(1, generator.getWorldElements().size());
        update(generator);
        
        assertEquals(2, generator.getWorldElements().size());
        update(generator);
        assertEquals(3, generator.getWorldElements().size());
        update(generator);
        assertEquals(4, generator.getWorldElements().size());
        update(generator);
        assertEquals(4, generator.getWorldElements().size());
        update(generator);
        assertEquals(4, generator.getWorldElements().size());
        
    }
    
    @Test
    public void testColumnDown() {
        Generator generator = new ObstacleGenerator(GAME_WORLD_WIDTH, GAME_WORLD_HEIGHT);
        basemantHeight = GAME_WORLD_HEIGHT-basemant;
        this.downPosition = new Point();
        downPosition.setLocation(GAME_WORLD_WIDTH, basemantHeight);
        Column basicDown = new BasicColumn(downPosition, false);
        for (int i=0; i<10 ; i++) {
            update(generator);
            Column typeColumn = (Column) generator.getWorldElements().
                    get(generator.getWorldElements().size()-1);
            
            assertEquals(basicDown.getPosition().getY(),typeColumn.getPosition().getY());
        }
        update(generator);
        Column typeColumn = (Column) generator.getWorldElements().
                get(generator.getWorldElements().size()-1);
        assertNotEquals(basicDown.getPosition().getY(),typeColumn.getPosition().getY());
        
        
        
    }
    @Test
    public void testColumnUp() {
        Generator generator = new ObstacleGenerator(GAME_WORLD_WIDTH, GAME_WORLD_HEIGHT);
        this.upPosition = new Point();
        upPosition.setLocation(GAME_WORLD_WIDTH,0);
        Column basicUp = new BasicColumn(upPosition, false);
        for (int i=0; i<10 ; i++) {
            update(generator);
          
        }
        for (int i=0; i<10 ; i++) {
            update(generator);
            Column typeColumn = (Column) generator.getWorldElements().
                    get(generator.getWorldElements().size()-1);
          
            assertEquals(basicUp.getPosition().getY(),typeColumn.getPosition().getY());
        }
        update(generator);
        Column typeColumn = (Column) generator.getWorldElements().
                get(generator.getWorldElements().size()-1);
        assertNotEquals(basicUp.getPosition().getY(),typeColumn.getPosition().getY());
        
    }
    
  
       
        
        
  
   
    
}
