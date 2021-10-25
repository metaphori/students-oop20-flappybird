package bird;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;

import javax.management.loading.PrivateClassLoader;

import org.junit.jupiter.api.Test;

import javafx.scene.shape.Circle;
import model.Bird;
import model.manager.ManagerBird;
import model.manager.ManagerBirdImpl;
import model.manager.ManagerGravity;
import model.manager.ManagerGravityImpl;

public class BirdTest {
    
    private double floorPosition = 550;
    private int yMotion = 2;
    
  @Test public void testMovement() {
      
      
      ManagerBird managerBird = new ManagerBirdImpl(floorPosition);
      ManagerGravity managerGravity = new ManagerGravityImpl(floorPosition); 
      Bird bird = managerBird.getBird();
      double height = bird.getCenterY();
      
      for(int i=0; i< 10; i++) {
          
          bird.updatePosition(managerGravity.setGravity(bird));
          height = height + yMotion;
          assertEquals(height,bird.getCenterY());
          System.out.println(height);
          System.out.println(managerGravity.setGravity(bird));
      }
  }

}
