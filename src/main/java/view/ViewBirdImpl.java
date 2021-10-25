package view;

import java.util.regex.Pattern;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import model.Bird;
import model.BirdImpl;

public class ViewBirdImpl implements ViewBird{

    private Pane pane;
    private Circle bird;
    private double h = 200;
    
  
    /**
     * This is the constructor method that initialize the circle and set the default image bird.
     */
    public ViewBirdImpl(Pane p) {
        // TODO Auto-generated constructor stub
        this.pane = p;
        this.bird = new Circle();
        this.bird.setFill(new ImagePattern(new Image(ImageID.PLAYER_ONE_BUTTON.getPath())));
        
    }

    public void render(Bird b) {
        // TODO Auto-generated method stub

        this.pane.getChildren().remove(bird);
        updatePosition(b);
        this.pane.getChildren().add(bird);
      
    }

    /**
     * Update circle's position.
     * @param b Bird.
     */
    private void updatePosition(Bird b) {
        // TODO Auto-generated method stub
        
        
        this.bird.setLayoutY(b.getCenterY());
        this.bird.setLayoutX(b.getCenterX());
        this.bird.setRadius(b.getRadius());
        
       
    }
    
    public void setImage(Image img){
       
        this.bird.setFill(new ImagePattern(img));
        
    }

}
